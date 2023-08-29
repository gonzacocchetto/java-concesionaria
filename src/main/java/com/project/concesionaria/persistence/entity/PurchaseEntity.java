package com.project.concesionaria.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity de compra
 */
@Entity
@Table(name = "compras")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer numberBill;
    @Column(name = "cliente_cedula")
    private String carIdCustomer;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    private Double total;
    @Column(name = "medio_pago")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "purchaseEntity", cascade = {CascadeType.ALL})
    private List<CarPurchaseEntity> carsPurchase;
}
