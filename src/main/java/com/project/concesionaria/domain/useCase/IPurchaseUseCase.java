package com.project.concesionaria.domain.useCase;

import com.project.concesionaria.domain.dto.PurchaseBillResponseDto;
import com.project.concesionaria.domain.dto.PurchaseRequestDto;
import com.project.concesionaria.domain.dto.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseUseCase {

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto getByNumberBill(Integer numberBill);

    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);
}
