package com.project.concesionaria.controller;

import com.project.concesionaria.domain.pojo.BrandCarPojo;
import com.project.concesionaria.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controlador rest de Marca Coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marca-coche")
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private final IBrandCarService iBrandCarService;


    @GetMapping
    public ResponseEntity<List<BrandCarPojo>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(iBrandCarService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Long id) {
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    @PostMapping
    public ResponseEntity<BrandCarPojo> save(@RequestBody BrandCarPojo brandCarPojo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

}
