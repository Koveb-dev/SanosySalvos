package com.sanosysalvos.gestion_mascotas.repository;



import com.sanosysalvos.gestion_mascotas.model.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {
    List<Reporte> findByEstado(String estado);
    List<Reporte> findByMascotaId(Long mascotaId);
}