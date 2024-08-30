package co.edu.uniquindio.unilocal.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document ("ciudades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String nombre;
}
