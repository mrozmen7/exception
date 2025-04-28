package com.ozmenyavuz.service.impl;

import com.ozmenyavuz.dto.DtoDepartment;
import com.ozmenyavuz.dto.DtoEmployee;
import com.ozmenyavuz.exception.BaseException;
import com.ozmenyavuz.exception.ErrorMessage;
import com.ozmenyavuz.exception.MessageType;
import com.ozmenyavuz.mapper.EmployeeMapper;
import com.ozmenyavuz.model.Employee;
import com.ozmenyavuz.repository.EmployeeRepository;
import com.ozmenyavuz.service.IEmployeeService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@ComponentScan()
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }
    @Override
    public DtoEmployee findEmployeeById(Long id) {
        // 1. Veritabanından Employee nesnesini al, yoksa özel bir istisna fırlat
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        Employee employee = optionalEmployee.get();

        // 2. Employee nesnesini MapStruct ile DtoEmployee nesnesine dönüştür
        DtoEmployee dtoEmployee = employeeMapper.toDto(employee);

        // 3. Eğer departman bilgisi varsa, onu da DTO'ya dönüştürüp set et
        if (employee.getDepartment() != null) {
            DtoDepartment dtoDepartment = employeeMapper.toDto(employee.getDepartment());
            dtoEmployee.setDepartment(dtoDepartment);
        }

        // 4. Hazırlanan DTO nesnesini döndür
        return dtoEmployee;
    }

//    @Override
//    public DtoEmployee findEmployeeById(Long id) {
//
//        DtoEmployee dtoEmployee = new DtoEmployee();
//        DtoDepartment dtodepartment = new DtoDepartment();
//
//        Optional<Employee> optional = employeeRepository.findById(id);
//
//        if (optional.isEmpty()) {
//            return null;
//
//        }
//
//        Employee employee = optional.get();
//        Department department = employee.getDepartment();
//
//        BeanUtils.copyProperties(employee, dtoEmployee);
//        BeanUtils.copyProperties(department, dtodepartment);
//
//        dtoEmployee.setDepartment(dtodepartment);
//
//        return dtoEmployee;
//    }
}
