package com.gestiontickets.core_api.dto;

import lombok.Data;

@Data // Lombok genera Getters y Setters
public class CreateTicketDTO {
    private String title;
    private String description;
    private String priority; // LOW, MEDIUM, HIGH
    private Long categoryId; // Solo el ID, no el objeto entero
    private Long creatorId;  // Solo el ID del usuario
}
