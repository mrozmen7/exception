package com.ozmenyavuz.handler;

import com.ozmenyavuz.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError> handleBaseException(BaseException exception, WebRequest request) {
        return ResponseEntity.badRequest().body(creteApiError(exception.getMessage(), request));
    }

    private String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName(); // sonucu ya da bilgisaryar adini alir
        } catch (UnknownHostException e) { // Eger hostname alÄ±namazsa hata firlatir, burada yakalanÄ±r.

            System.out.println("Hata Olustu : " + e.getMessage());
        }
        return null;
    }

    private <T> ApiError<T> creteApiError(T message, WebRequest request) {

        ApiError<T> apiError = new ApiError<>(); // Hata detaylarini tasiyacak ana container olusturur

        apiError.setStatus(HttpStatus.BAD_REQUEST.value()); // hata statusu 400 olan set eder

        CustomExceptionDetail<T> exception = new CustomExceptionDetail<>(); // Hata detayini olusran hata nesnesi
        exception.setHostName(getHostname()); // sonucunun adi ataniyor
        exception.setPath(request.getDescription(false).substring(4)); // /api/users/1 kÄ±smÄ±nÄ±Â kismini alir
        exception.setCreateTime(new Date()); // Hata olusma tarihini yazar
        exception.setMessaage(message);// HATA mesaji set eder

        apiError.setException(exception); // Hazirlanan detaylar ApiError icine set edilir.

        return apiError;  // JSON olarak dondurecek hata govdesini tamalkar
    }
}
