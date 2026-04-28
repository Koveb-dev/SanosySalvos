package com.sanosysalvos.gestion_mascotas.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReporteRequest {
    @NotBlank
    private String tipo;        // PERDIDO, ENCONTRADO, CLINICA

    private Long mascotaId;     // Si la mascota ya existe
    private String nombreMascota;
    private String especie;
    private String raza;
    private String color;
    private String tamaño;

    @NotNull
    private Double latitud;
    @NotNull
    private Double longitud;

    private String atributos;   // JSON con datos adicionales
    private String contacto;    // Teléfono o email de contacto

    // Campos específicos opcionales
    private boolean recompensa;
    private String ubicacionHallazgo;
    private String nombreClinica;
}