package com.project.concesionaria.controller;

import com.project.concesionaria.domain.dto.CustomerDto;
import com.project.concesionaria.domain.dto.ResponseCustomerDto;
import com.project.concesionaria.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(iCustomerUseCase.getAll());

    }

    @GetMapping(path = "/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String cardId) {
        return ResponseEntity.of(iCustomerUseCase.getCustomerByCardId(cardId));

    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

    @PostMapping
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCustomerUseCase.save(customerDto));

    }

    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto modifyCustomer) {
        return ResponseEntity.of(iCustomerUseCase.update(modifyCustomer));

    }

    @DeleteMapping(path = "/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId) {
        return new ResponseEntity<>(this.iCustomerUseCase.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
