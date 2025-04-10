package com.ozmenyavuz.controller;

import com.ozmenyavuz.dto.DtoEmployee;
import com.ozmenyavuz.model.RootEntity;

public interface RestEmployeeController {

    public RootEntity<DtoEmployee> findEmployeeById(Long id);
}
