package com.ecomarket.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedidoId;

    private Double monto;

    private String metodoPago; // Ejemplo: "Tarjeta", "PayPal"

    private String estado; // Ejemplo: "Procesado", "Pendiente"

    private String fechaPago;
}
