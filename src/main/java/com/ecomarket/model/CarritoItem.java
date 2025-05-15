package com.ecomarket.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carrito_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productoId;    // ID del producto en el carrito

    private Integer cantidad;   // Cantidad del producto

    private Double precioUnitario;  // Precio del producto
}