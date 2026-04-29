package com.sanosysalvos.gestion_mascotas.messaging.publisher;



import com.sanosysalvos.gestion_mascotas.messaging.config.RabbitMQConfig;
import com.sanosysalvos.gestion_mascotas.model.entity.Reporte;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReporteEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publicarNuevoReporte(Reporte reporte) {
        // Podés mapear a un DTO específico para el mensaje
        var evento = new ReporteEvent(
                reporte.getId(),
                reporte.getEstado(),
                reporte.getMascota().getId(),
                reporte.getLatitud(),
                reporte.getLongitud(),
                reporte.getFechaCreacion()
        );
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                evento
        );
    }

    // Clase interna con los datos del evento (o podés crear un DTO separado)
    public record ReporteEvent(
            Long reporteId,
            String tipo,
            Long mascotaId,
            Double latitud,
            Double longitud,
            java.time.LocalDateTime fecha
    ) {}
}
