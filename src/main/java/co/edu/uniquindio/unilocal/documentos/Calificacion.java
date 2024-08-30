package co.edu.uniquindio.unilocal.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("calificaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Calificacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codUsuario;

    private Integer calificacion;
}
