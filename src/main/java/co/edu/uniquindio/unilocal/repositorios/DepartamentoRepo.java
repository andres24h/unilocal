package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.documentos.Departamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepo extends MongoRepository<Departamento, String> {
}
