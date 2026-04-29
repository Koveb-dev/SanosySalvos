package com.sanosysalvos.gestion_mascotas.factory;



import com.sanosysalvos.gestion_mascotas.model.dto.ReporteRequest;
import com.sanosysalvos.gestion_mascotas.model.entity.*;
import org.springframework.stereotype.Component;

@Component
public class ReporteFactory {

    public Reporte crearReporte(ReporteRequest request, Mascota mascota, Usuario reportador) {
        Reporte reporte = switch (request.getTipo().toUpperCase()) {
            case "PERDIDO" -> {
                ReportePerdido rp = new ReportePerdido();
                rp.setContactoDueño(request.getContacto());
                rp.setRecompensa(request.isRecompensa());
                yield rp;
            }
            case "ENCONTRADO" -> {
                ReporteEncontrado re = new ReporteEncontrado();
                re.setContactoHallador(request.getContacto());
                re.setUbicacionHallazgo(request.getUbicacionHallazgo());
                yield re;
            }
            case "CLINICA" -> {
                ReporteClinica rc = new ReporteClinica();
                rc.setNombreClinica(request.getNombreClinica());
                yield rc;
            }
            default -> throw new IllegalArgumentException("Tipo de reporte no soportado: " + request.getTipo());
        };

        reporte.setEstado(request.getTipo().toUpperCase());
        reporte.setLatitud(request.getLatitud());
        reporte.setLongitud(request.getLongitud());
        reporte.setAtributos(request.getAtributos());
        reporte.setMascota(mascota);
        reporte.setReportador(reportador);

        return reporte;
    }
}