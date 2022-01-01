package co.com.sofka.biblioteca.services;

import co.com.sofka.biblioteca.dtos.RecursoDTO;
import co.com.sofka.biblioteca.helpers.Mensaje;
import co.com.sofka.biblioteca.mappers.RecursoMapper;
import co.com.sofka.biblioteca.models.RecursoModel;
import co.com.sofka.biblioteca.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecursoService {

    @Autowired
    RecursoRepository repository;
    RecursoMapper mapper = new RecursoMapper();

    public RecursoDTO crear (RecursoDTO recursoDTO){
        RecursoModel recurso = mapper.fromDTO(recursoDTO);
        return mapper.fromCollection(repository.save(recurso));
    }

    public RecursoDTO findById(String id){
        RecursoModel recurso = repository.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(recurso);
    }

    public List<RecursoDTO> findAll() {
        List<RecursoModel> recurso = repository.findAll();
        return mapper.fromCollectionList(recurso);
    }

    public List<RecursoDTO> findByAreaTematica(String area){
        List<RecursoModel> recursos = repository.findByAreaTematica(area);
        return mapper.fromCollectionList(recursos);
    }

    public List<RecursoDTO> findByTipo(String tipo){
        List<RecursoModel> recursos = repository.findByTipo(tipo);
        return mapper.fromCollectionList(recursos);
    }

    public List<RecursoDTO> findByAreaYTipo(String area, String Tipo){
        List<RecursoModel> recursos = repository.findByAreaYTipo(area,Tipo);
        return mapper.fromCollectionList(recursos);
    }

    public void deleteByid(String id){
        repository.deleteById(id);
    }

    public Mensaje idDisponible(String id){
        RecursoDTO recursoDTO = findById(id);
        return new Mensaje().mostrarMensajeDisponible(recursoDTO.getDisponible(), recursoDTO.getFechaPrestamo());
    }

    public Mensaje mostrarPrestamoRecurso(String id){
        RecursoDTO recursoDTO = findById(id);
        Mensaje mensaje = new Mensaje().mostrarMensajePrestamo(recursoDTO.getDisponible(), recursoDTO.getFechaPrestamo());

        if(recursoDTO.getDisponible()){
            recursoDTO.setDisponible(false);
            recursoDTO.setFechaPrestamo(new Date());
            RecursoModel recurso = mapper.fromDTO(recursoDTO);
            mapper.fromCollection(repository.save(recurso));
        }
        return mensaje;
    }

    public Mensaje devolverRecurso(String id){
        RecursoDTO recursoDTO = findById(id);
        Mensaje mensaje = new Mensaje().mostrarMensajeDevolucion(recursoDTO.getDisponible(), recursoDTO.getFechaPrestamo());

        if(!recursoDTO.getDisponible()){
            recursoDTO.setDisponible(true);
            recursoDTO.setFechaPrestamo(null);
            RecursoModel recurso = mapper.fromDTO(recursoDTO);
            mapper.fromCollection(repository.save(recurso));
        }
        return mensaje;
    }



}
