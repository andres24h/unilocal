package co.edu.uniquindio.unilocal.documentos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document ("clientes")
@NoArgsConstructor
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente extends Persona implements Serializable {

    @JsonProperty("")
    private String fotoPerfil;
    @JsonProperty("username")
    private String username;
    @JsonProperty("estado")
    private EstadoRegistro estado;
    @JsonProperty("tipoUsuario")
    private TipoUsuario tipoUsuario;
    @JsonProperty("telefonos")
    private List<String> telefonos;
    @JsonProperty("listaNegociosFavoritos")
    private List<TipoNegocio> listaNegociosFavoritos;

    @Builder
    public Cliente(String nombre, String email, String password, String fotoPerfil, String username, EstadoRegistro estado,
                   TipoUsuario tipoUsuario, List<String> telefonos, List<TipoNegocio> listaNegociosFavoritos) {
        super(nombre, email, password);
        this.fotoPerfil = fotoPerfil;
        this.username = username;
        this.estado = estado;
        this.tipoUsuario = tipoUsuario;
        this.telefonos = telefonos;
        this.listaNegociosFavoritos = listaNegociosFavoritos;
    }
}

