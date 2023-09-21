package com.project.concesionaria.persistence.repository.impl;

import com.project.concesionaria.domain.dto.CarPurchaseResponseDto;
import com.project.concesionaria.domain.dto.PurchaseBillResponseDto;
import com.project.concesionaria.domain.dto.PurchaseRequestDto;
import com.project.concesionaria.domain.dto.PurchaseResponseDto;
import com.project.concesionaria.domain.repository.IPurchaseRepository;
import com.project.concesionaria.persistence.repository.IPurchaseCrudRepository;
import com.project.concesionaria.persistence.entity.PurchaseEntity;
import com.project.concesionaria.persistence.mapper.IPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private final IPurchaseCrudRepository iPurchaseCrudRepository;

    private final IPurchaseMapper iPurchaseMapper;

    @Override
    public List<PurchaseResponseDto> getAll() {

        List<PurchaseEntity> listPurchasesEntity = iPurchaseCrudRepository.findAll();
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        List<PurchaseEntity> listPurchasesEntity = iPurchaseCrudRepository.findAllByCardIdCustomer(idCustomer);
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        Optional<PurchaseEntity> purchaseEntitySearch = iPurchaseCrudRepository.findById(numberBill);

        if(purchaseEntitySearch.isEmpty()) {
            return null;
        }

        return toPurchaseResponseDtoByEntity(purchaseEntitySearch.get());
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseEntity purchaseEntity = iPurchaseMapper.toPurchaseEntity(purchaseRequestDto);

        purchaseEntity.getCarsPurchase().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity));

        PurchaseEntity purchaseEntitySave = iPurchaseCrudRepository.save(purchaseEntity);
        return new PurchaseBillResponseDto(purchaseEntitySave.getNumberBill());
    }


    public PurchaseResponseDto toPurchaseResponseDtoByEntity(PurchaseEntity purchaseEntity) {
        PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();
        purchaseResponseDto.setNumberBill(purchaseEntity.getNumberBill());
        purchaseResponseDto.setCardIdCustomer(purchaseEntity.getCardIdCustomer());
        purchaseResponseDto.setDate(purchaseEntity.getDate());
        purchaseResponseDto.setTotal(purchaseEntity.getTotal());
        purchaseResponseDto.setPaymentMethod(purchaseEntity.getPaymentMethod());

        List<CarPurchaseResponseDto> carPurchaseResponseDtoList = new ArrayList<>();
        purchaseEntity.getCarsPurchase().forEach(carPurchaseEntity -> {
            String reference = carPurchaseEntity.getCarEntity().getReference();
            Integer quantity = carPurchaseEntity.getQuantity();
            Integer total = carPurchaseEntity.getTotal();
            carPurchaseResponseDtoList.add(new CarPurchaseResponseDto(reference, quantity, total));
        });

        purchaseResponseDto.setCarsPurchase(carPurchaseResponseDtoList);

        return purchaseResponseDto;
    }
}
