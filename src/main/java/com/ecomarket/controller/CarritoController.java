package com.ecomarket.controller;

import com.ecomarket.model.Carrito;
import com.ecomarket.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // Obtener carrito por clienteId
    @GetMapping("/{clienteId}")
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable Long clienteId) {
        return carritoService.getCarritoByClienteId(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo carrito
    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito) {
        Carrito nuevo = carritoService.crearCarrito(carrito);
        return ResponseEntity.ok(nuevo);
    }

    // Actualizar un carrito existente
    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Long id, @RequestBody Carrito carrito) {
        carrito.setId(id);
        Carrito actualizado = carritoService.actualizarCarrito(carrito);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar un carrito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id) {
        carritoService.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }
}

