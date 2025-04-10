package com.ozmenyavuz.service;

import com.ozmenyavuz.dto.DtoEmployee;
import com.ozmenyavuz.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeService {

    public DtoEmployee findEmployeeById(Long id);
}
