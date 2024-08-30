package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.documentos.Cliente;
import co.edu.uniquindio.unilocal.documentos.EstadoRegistro;
import co.edu.uniquindio.unilocal.documentos.TipoNegocio;
import co.edu.uniquindio.unilocal.documentos.TipoUsuario;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void crear() {

        // Se crea el cliente con sus propiedades
        Cliente cliente = Cliente.builder()
                .nombre("andres1")
                .email("andres1@email.com")
                .password("12345")
                .fotoPerfil("url")
                .username("andres12")
                .estado(EstadoRegistro.valueOf("INACTIVO"))
                .tipoUsuario(TipoUsuario.valueOf("MODERADOR"))
                .telefonos(List.of("3117188224", "7408238"))
                .listaNegociosFavoritos(Collections.singletonList(TipoNegocio.valueOf("BAR")))
                .build();

        // Se guarda el cliente
        Cliente guaradado = clienteRepo.save(cliente);

        // Se verifica que se haya guardado, validando que no sea null
        //Assertions.assertNotNull(guardado);

        // Se verifica que el valor actual sea el mismo que el valor esperado
        assertEquals("andres1", guaradado.getNombre());

        // Se verifica que el registro no es null
        assertNotNull("registro");
    }

    @Test
    public void eliminar() {

        // Se crea el cliente con sus propiedades
        Cliente cliente = Cliente.builder()
                .nombre("andres")
                .email("andres@email.com")
                .password("12345")
                .fotoPerfil("url")
                .username("andres12")
                .estado(EstadoRegistro.valueOf("INACTIVO"))
                .tipoUsuario(TipoUsuario.valueOf("MODERADOR"))
                .telefonos(List.of("3117188224", "7408238"))
                .listaNegociosFavoritos(Collections.singletonList(TipoNegocio.valueOf("DISCOTECA"))).build();

        cliente.setCodigo(String.valueOf(1));

        // Se guarda el cliente
        Cliente guardado = clienteRepo.save(cliente);

        // Se elimina el cliente
        clienteRepo.delete(guardado);

        Optional<Cliente> buscado = clienteRepo.findById(String.valueOf(1));

        Assertions.assertNull(buscado.orElse(null));
    }

    @Test
    public void actualizar() {

        // Se crea el cliente con sus propiedades
        Cliente cliente = Cliente.builder()
                .nombre("andres")
                .email("andres@email.com")
                .password("12345")
                .fotoPerfil("url")
                .username("andres12")
                .estado(EstadoRegistro.valueOf("INACTIVO"))
                .tipoUsuario(TipoUsuario.valueOf("MODERADOR"))
                .telefonos(List.of("3117188224", "7408238"))
                .listaNegociosFavoritos(Collections.singletonList(TipoNegocio.valueOf("DISCOTECA"))).build();

        cliente.setCodigo(String.valueOf(1));

        // Se guarda el cliente
        Cliente guardado = clienteRepo.save(cliente);

        guardado.setEmail("nuevo_email@email.com");

        Cliente nuevo = clienteRepo.save(guardado);

        assertEquals("nuevo_email@email.com", nuevo.getEmail());

    }

    @Test
    public void obtener() throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();

        // Cargar el archivo JSON desde recursos
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("clientes.json");
        if (inputStream == null) {
            throw new IllegalArgumentException("El archivo clientes.json no se encontró en el directorio de recursos");
        }

        // Leer el archivo JSON y deserializarlo en una lista de Clientes
        List<Cliente> clientes = objectMapper.readValue(inputStream, new TypeReference<List<Cliente>>() {});

        // Buscar el cliente con el código "4" como String
        Optional<Cliente> clienteOpt = clientes.stream()
                .filter(c -> "2".equals(c.getCodigo())) // Comparar con String
                .findFirst();

        // Verificar que el cliente no sea nulo
        Cliente cliente = clienteOpt.orElse(null);
        assertNotNull(cliente, "El cliente con código 4 no se encontró");

        // Imprimir el cliente encontrado
        System.out.println(cliente);

        // Verificar algunos valores del cliente encontrado (opcional)
        assertEquals("2", cliente.getCodigo());
        assertEquals("mauricio", cliente.getNombre());

    }

   /* @Test
    public void obtener() {

        // Se crea el cliente con sus propiedades
        Cliente cliente = Cliente.builder()
                .nombre("andres")
                .email("andres@email.com")
                .password("12345")
                .fotoPerfil("url")
                .username("andres12")
                .estado(EstadoRegistro.valueOf("INACTIVO"))
                .tipoUsuario(TipoUsuario.valueOf("MODERADOR"))
                .telefonos(List.of("3117188224", "7408238"))
                .listaNegociosFavoritos(Collections.singletonList(TipoNegocio.valueOf("DISCOTECA"))).build();

        cliente.setCodigo(String.valueOf(1));

        Cliente guardado = clienteRepo.save(cliente);
        System.out.println(guardado);

        Optional<Cliente> buscado = clienteRepo.findById(String.valueOf(1));

        System.out.println(buscado.orElse(null));
    }*/

    @Test
    public void listar() throws IOException {

        // Leer archivo .JSON
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("clientes.json");
        List<Cliente> clientes = objectMapper.readValue(inputStream, new TypeReference<List<Cliente>>() {});

        // Se guarda los clientes en la bd
        clienteRepo.saveAll(clientes);

        // Listar todos los clientes
        List<Cliente> lista = clienteRepo.findAll();

        // Imprimir la lista de clientes
        //System.out.println(lista);

        lista.forEach(System.out::println);
    }
}


    /*@Test
    public void listar() {

        // Se crea el cliente con sus propiedades
        Cliente cliente = Cliente.builder()
                .nombre("andres")
                .email("andres@email.com")
                .password("12345")
                .fotoPerfil("url")
                .username("andres12")
                .estado(EstadoRegistro.valueOf("INACTIVO"))
                .tipoUsuario(TipoUsuario.valueOf("MODERADOR"))
                .telefonos(List.of("3117188224", "7408238"))
                .listaNegociosFavoritos(Collections.singletonList(TipoNegocio.valueOf("DISCOTECA"))).build();

        clienteRepo.save(cliente);

        // Se crea el cliente con sus propiedades
        Cliente cliente2 = Cliente.builder()
                .nombre("mauricio")
                .email("mauricio@email.com")
                .password("12345")
                .fotoPerfil("url")
                .username("mauricio12")
                .estado(EstadoRegistro.valueOf("INACTIVO"))
                .tipoUsuario(TipoUsuario.valueOf("MODERADOR"))
                .telefonos(List.of("3117188224", "7408238"))
                .listaNegociosFavoritos(Collections.singletonList(TipoNegocio.valueOf("DISCOTECA"))).build();

        List<Cliente> lista = clienteRepo.findAll();

        System.out.println(lista);
    }*/

