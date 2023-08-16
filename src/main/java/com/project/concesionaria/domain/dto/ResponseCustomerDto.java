package com.project.concesionaria.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ResponseCustomerDto {

    private String password;

    public ResponseCustomerDto(String passwordGenerated) {
    }
}
