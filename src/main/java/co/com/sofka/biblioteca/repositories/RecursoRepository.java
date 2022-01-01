package co.com.sofka.biblioteca.repositories;

import co.com.sofka.biblioteca.models.RecursoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository  extends MongoRepository<RecursoModel, String> {

    List<RecursoModel> findByTipo(String tipo);
    List<RecursoModel> findByAreaTematica(String area);
    List<RecursoModel> findByAreaYTipo(String area, String tipo);

}
