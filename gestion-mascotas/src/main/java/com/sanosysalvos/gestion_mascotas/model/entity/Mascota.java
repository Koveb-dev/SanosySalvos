package com.sanosysalvos.gestion_mascotas.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "mascotas")
@Getter @Setter
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especie;
    private String raza;
    private String color;
    private String tamaño;
    private String sexo;
    private Integer edadAproximada;

    @Column(columnDefinition = "jsonb")
    private String señasParticulares; // Datos flexibles

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario dueño;

    @OneToMany(mappedBy = "mascota")
    private List<Reporte> reportes;
}