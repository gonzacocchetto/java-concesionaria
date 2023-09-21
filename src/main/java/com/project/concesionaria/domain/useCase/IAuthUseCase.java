package com.project.concesionaria.domain.useCase;

import com.project.concesionaria.domain.dto.AuthCustomerDto;
import com.project.concesionaria.domain.dto.JwtResponseDto;

public interface IAuthUseCase {

    JwtResponseDto signIn(AuthCustomerDto authCustomerDto);

    JwtResponseDto signOut(String jwt);
}
