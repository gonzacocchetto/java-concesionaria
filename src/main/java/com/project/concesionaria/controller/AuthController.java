package com.project.concesionaria.controller;

import com.project.concesionaria.domain.dto.AuthCustomerDto;
import com.project.concesionaria.domain.dto.CustomerDto;
import com.project.concesionaria.domain.dto.JwtResponseDto;
import com.project.concesionaria.domain.dto.ResponseCustomerDto;
import com.project.concesionaria.domain.useCase.IAuthUseCase;
import com.project.concesionaria.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final IAuthUseCase iAuthUseCase;

    private final ICustomerUseCase iCustomerUseCase;


    @PostMapping(path = "/register")
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCustomerUseCase.save(customerDtoNew));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthCustomerDto authCustomerDto) {
        return ResponseEntity.ok(iAuthUseCase.signIn(authCustomerDto));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }

}
