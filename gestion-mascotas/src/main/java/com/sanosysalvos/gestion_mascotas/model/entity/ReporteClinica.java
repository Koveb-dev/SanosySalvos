package com.sanosysalvos.gestion_mascotas.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CLINICA")
@Getter @Setter
public class ReporteClinica extends Reporte {
    private String nombreClinica;
    private String veterinarioResponsable;
}