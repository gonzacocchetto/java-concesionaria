package com.project.concesionaria.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto del guardado de una compra
 */
public class PurchaseRequestDto {

    private Integer numberBill;

    private String carIdCustomer;

    private LocalDateTime date;

    private Double total;

    private String paymentMethod;

    private List<CarPurchaseRequestDto> carsPurchase;
}
