package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.documentos.Ubicacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepo extends MongoRepository<Ubicacion, String> {
}
