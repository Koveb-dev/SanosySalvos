package com.sanosysalvos.gestion_mascotas.repository;

import com.sanosysalvos.gestion_mascotas.model.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}