package co.edu.uniquindio.unilocal.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document("historialRevisiones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistorialRevision implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codRegistro;

    private String codNegocio;
    private String descripcion;
    private String idModerador;
    private LocalDateTime fecha;
    private EstadoRevision estadoAsignado;
}
