package com.ecomarket.controller;

import com.ecomarket.model.Precio;
import com.ecomarket.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/precios")
public class PrecioController {

    @Autowired
    private PrecioService precioService;

    @GetMapping
    public ResponseEntity<List<Precio>> getAllPrecios() {
        return ResponseEntity.ok(precioService.getAllPrecios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Precio> getPrecioById(@PathVariable Long id) {
        return precioService.getPrecioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<Precio>> getPreciosByProductoId(@PathVariable Long productoId) {
        return ResponseEntity.ok(precioService.getPreciosByProductoId(productoId));
    }

    @PostMapping
    public ResponseEntity<Precio> createPrecio(@RequestBody Precio precio) {
        return ResponseEntity.ok(precioService.createPrecio(precio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Precio> updatePrecio(@PathVariable Long id, @RequestBody Precio precio) {
        try {
            return ResponseEntity.ok(precioService.updatePrecio(id, precio));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrecio(@PathVariable Long id) {
        precioService.deletePrecio(id);
        return ResponseEntity.noContent().build();
    }
}
