package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.documentos.Ciudad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends MongoRepository<Ciudad, String> {
}
