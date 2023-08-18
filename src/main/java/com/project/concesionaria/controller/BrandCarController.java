package com.project.concesionaria.controller;

import com.project.concesionaria.domain.dto.BrandCarDto;
import com.project.concesionaria.domain.useCase.IBrandCarUseCase;
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
@RequestMapping(path = "/brands-car")
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private final IBrandCarUseCase iBrandCarUseCase;


    @GetMapping
    public ResponseEntity<List<BrandCarDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(iBrandCarUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Long id) {
        return ResponseEntity.of(iBrandCarUseCase.getBrandCar(id));
    }

    @PostMapping
    public ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto brandCarDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarUseCase.save(brandCarDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PatchMapping
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarDtoUpdate) {
        return ResponseEntity.of(iBrandCarUseCase.update(brandCarDtoUpdate));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.iBrandCarUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }

}
