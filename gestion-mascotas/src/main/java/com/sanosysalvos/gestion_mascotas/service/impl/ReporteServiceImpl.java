package com.sanosysalvos.gestion_mascotas.service.impl;


import com.sanosysalvos.gestion_mascotas.factory.ReporteFactory;
import com.sanosysalvos.gestion_mascotas.messaging.publisher.ReporteEventPublisher;
import com.sanosysalvos.gestion_mascotas.model.dto.ReporteRequest;
import com.sanosysalvos.gestion_mascotas.model.dto.ReporteResponse;
import com.sanosysalvos.gestion_mascotas.model.entity.Mascota;
import com.sanosysalvos.gestion_mascotas.model.entity.Reporte;
import com.sanosysalvos.gestion_mascotas.model.entity.Usuario;
import com.sanosysalvos.gestion_mascotas.repository.MascotaRepository;
import com.sanosysalvos.gestion_mascotas.repository.ReporteRepository;
import com.sanosysalvos.gestion_mascotas.repository.UsuarioRepository;
import com.sanosysalvos.gestion_mascotas.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;
    private final MascotaRepository mascotaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ReporteFactory reporteFactory;
    private final ReporteEventPublisher eventPublisher;

    @Override
    @Transactional
    public ReporteResponse crearReporte(ReporteRequest request) {
        // 1. Obtener o crear la mascota (simplificación: buscar por ID o crear nueva)
        Mascota mascota = obtenerOCrearMascota(request);

        // 2. Obtener el usuario reportador (simplificación: un usuario fijo o autenticado)
        Usuario reportador = usuarioRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 3. Usar la fábrica para instanciar el tipo de reporte adecuado
        Reporte reporte = reporteFactory.crearReporte(request, mascota, reportador);

        // 4. Persistir
        reporte = reporteRepository.save(reporte);

        // 5. Publicar evento para el motor de coincidencias
        eventPublisher.publicarNuevoReporte(reporte);

        // 6. Convertir a DTO de respuesta
        return ReporteResponse.builder()
                .id(reporte.getId())
                .tipo(reporte.getEstado())
                .mascotaId(mascota.getId())
                .nombreMascota(mascota.getNombre())
                .raza(mascota.getRaza())
                .color(mascota.getColor())
                .latitud(reporte.getLatitud())
                .longitud(reporte.getLongitud())
                .atributos(reporte.getAtributos())
                .fechaCreacion(reporte.getFechaCreacion())
                .build();
    }

    private Mascota obtenerOCrearMascota(ReporteRequest request) {
        if (request.getMascotaId() != null) {
            return mascotaRepository.findById(request.getMascotaId())
                    .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        }
        // Crear mascota nueva con los datos del reporte
        Mascota nueva = new Mascota();
        nueva.setNombre(request.getNombreMascota());
        nueva.setRaza(request.getRaza());
        nueva.setColor(request.getColor());
        nueva.setEspecie(request.getEspecie());
        nueva.setTamaño(request.getTamaño());
        // Dueño se podría asignar luego
        return mascotaRepository.save(nueva);
    }
}