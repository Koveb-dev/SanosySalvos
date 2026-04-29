package com.sanosysalvos.gestion_mascotas.service.impl;



import com.sanosysalvos.gestion_mascotas.model.entity.Mascota;
import com.sanosysalvos.gestion_mascotas.repository.MascotaRepository;
import com.sanosysalvos.gestion_mascotas.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    @Override
    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Optional<Mascota> buscarPorId(Long id) {
        return mascotaRepository.findById(id);
    }
}