package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.documentos.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepo extends MongoRepository<Horario, String> {
}
