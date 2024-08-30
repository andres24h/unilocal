package co.edu.uniquindio.unilocal.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document ("ubicaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ubicacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String codCiudad;
    private String CodDepartamento;
    private String direccion;
    private String longitud;
    private String latitud;
}
