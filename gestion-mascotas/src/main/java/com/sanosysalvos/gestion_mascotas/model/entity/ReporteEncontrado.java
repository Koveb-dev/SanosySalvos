package com.sanosysalvos.gestion_mascotas.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("ENCONTRADO")
@Getter @Setter
public class ReporteEncontrado extends Reporte {
    private String contactoHallador;
    private String ubicacionHallazgo;
}