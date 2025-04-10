package com.ozmenyavuz.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomExceptionDetail<E> {

    private String hostName;
    private String path;
    private Date createTime;
    private E messaage;

}
