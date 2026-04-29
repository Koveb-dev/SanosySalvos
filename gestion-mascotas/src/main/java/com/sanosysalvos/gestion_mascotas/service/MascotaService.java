package com.sanosysalvos.gestion_mascotas.service;



import com.sanosysalvos.gestion_mascotas.model.entity.Mascota;
import java.util.Optional;

public interface MascotaService {
    Mascota crearMascota(Mascota mascota);
    Optional<Mascota> buscarPorId(Long id);
}