package co.edu.uniquindio.unilocal.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document ("negocios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Negocio implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String codCreador;
    private String nombre;
    private String descripcion;
    private TipoNegocio tipoNegocio;
    private EstadoRevision estado;
    private Ubicacion ubicacion;
    private List<String> listImagenes;
    private List<String> telefonos;
    private List<Horario> listHorarios;
    private List<Comentario> listComentarios;
    private List<Calificacion> listCalificaciones;
}
