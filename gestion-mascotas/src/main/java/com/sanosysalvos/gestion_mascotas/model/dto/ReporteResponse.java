package com.sanosysalvos.gestion_mascotas.model.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ReporteResponse {
    private Long id;
    private String tipo;
    private Long mascotaId;
    private String nombreMascota;
    private String raza;
    private String color;
    private Double latitud;
    private Double longitud;
    private String atributos;
    private LocalDateTime fechaCreacion;
}