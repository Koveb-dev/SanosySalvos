package com.sanosysalvos.gestion_mascotas.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("PERDIDO")
@Getter @Setter
public class ReportePerdido extends Reporte {
    // Validaciones y campos específicos si se requieren
    private String contactoDueño;
    private boolean recompensa;
}