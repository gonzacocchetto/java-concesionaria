package com.project.concesionaria.domain.service;

import com.project.concesionaria.domain.dto.CustomerDto;
import com.project.concesionaria.domain.dto.ResponseCustomerDto;
import com.project.concesionaria.domain.repository.ICustomerRepository;
import com.project.concesionaria.domain.useCase.ICustomerUseCase;
import com.project.concesionaria.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {

        if(!newCustomer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }

        String passwordGenerated = generateRandomPassword(8);

        newCustomer.setPassword(passwordGenerated);
        newCustomer.setActive(1);
        iCustomerRepository.save(newCustomer);

        return new ResponseCustomerDto(passwordGenerated);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto modifyCustomer) {
        if (iCustomerRepository.getCustomerByCardId(modifyCustomer.getCardId()).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(modifyCustomer));
    }

    @Override
    public boolean delete(String cardId) {
        if(iCustomerRepository.getCustomerByCardId(cardId).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(cardId);
        return true;

    }

    //Metodo para generar una contraseña alfanumerica aleatoria de una longitud especifica
    private String generateRandomPassword(int len){

        //Rango ASCII - alfanumerico (0-9 y A-Z y a-z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";


        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        //Cada iteracion del bucle elige aleatoriamente un caracter
        //Rango ASCII lo agrega a la intancia de StringBuilder

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}

