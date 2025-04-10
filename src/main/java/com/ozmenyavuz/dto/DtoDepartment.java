package com.ozmenyavuz.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoDepartment {

    private Long id;
    private String name;
    private  String location;

    public DtoDepartment() {} // ← Bu yoksa ekle!


}
