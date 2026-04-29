package com.sanosysalvos.gestion_mascotas.service;



import com.sanosysalvos.gestion_mascotas.model.dto.ReporteRequest;
import com.sanosysalvos.gestion_mascotas.model.dto.ReporteResponse;

public interface ReporteService {
    ReporteResponse crearReporte(ReporteRequest request);
}