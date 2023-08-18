package com.project.concesionaria.controller;

import com.project.concesionaria.domain.dto.CarDto;
import com.project.concesionaria.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cars")
public class CarController {

    private final ICarUseCase iCarUseCase;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(iCarUseCase.getAll());
    }

    @GetMapping(path = "/brand-car/{idBrand}")
    public ResponseEntity<List<CarDto>> getByIdBrand(@PathVariable Long idBrand) {
        return ResponseEntity.ok(iCarUseCase.getByIdBrand(idBrand));
    }

    @GetMapping(path = "/price/{price}")
    public ResponseEntity<List<CarDto>> getCarsByPrice(@PathVariable Double price) {
        return ResponseEntity.ok(iCarUseCase.getCarsByPrice(price));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable Long id) {
        return ResponseEntity.of(iCarUseCase.getCar(id));

    }

    @PostMapping(path = "/{cardId}")
    public ResponseEntity<CarDto> save(CarDto newCar) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCarUseCase.save(newCar));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(Long id) {
        return new ResponseEntity<>(this.iCarUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
