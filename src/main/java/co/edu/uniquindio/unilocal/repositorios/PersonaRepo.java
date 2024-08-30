package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.documentos.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends MongoRepository<Persona, String> {
}
