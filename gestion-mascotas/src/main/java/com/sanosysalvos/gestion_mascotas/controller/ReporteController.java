package com.sanosysalvos.gestion_mascotas.controller;



import com.sanosysalvos.gestion_mascotas.model.dto.ReporteRequest;
import com.sanosysalvos.gestion_mascotas.model.dto.ReporteResponse;
import com.sanosysalvos.gestion_mascotas.service.ReporteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @PostMapping
    public ResponseEntity<ReporteResponse> crearReporte(@Valid @RequestBody ReporteRequest request) {
        ReporteResponse response = reporteService.crearReporte(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Podés agregar endpoints adicionales (listar reportes, etc.)
}