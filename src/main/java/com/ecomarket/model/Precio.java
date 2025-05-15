package com.ecomarket.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "precios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productoId; // ID del producto al que se asigna el precio

    private Double precioBase; // Precio base del producto

    private Double precioPromocion; // Precio promocional (si aplica)

    private String descripcionPromocion; // Descripción de la promoción

    private String fechaInicio; // Fecha de inicio de la promoción

    private String fechaFin; // Fecha de fin de la promoción
}
