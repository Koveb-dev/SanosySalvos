package com.sanosysalvos.gestion_mascotas.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String nombre;
    private String telefono;
    private String rol;  // dueño, ciudadano, clinica, refugio, municipalidad

    @OneToMany(mappedBy = "reportador")
    private List<Reporte> reportes;
}