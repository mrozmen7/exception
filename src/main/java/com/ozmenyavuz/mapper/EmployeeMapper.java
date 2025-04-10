package com.ozmenyavuz.mapper;

import com.ozmenyavuz.dto.DtoDepartment;
import com.ozmenyavuz.dto.DtoEmployee;
import com.ozmenyavuz.model.Department;
import com.ozmenyavuz.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    DtoEmployee toDto(Employee employee);
    Employee toEntity(DtoEmployee dtoEmployee);

    DtoDepartment toDto(Department department);
    Department toEntity(DtoDepartment dtoDepartment);
}