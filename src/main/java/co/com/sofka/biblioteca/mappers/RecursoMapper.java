package co.com.sofka.biblioteca.mappers;

import co.com.sofka.biblioteca.dtos.RecursoDTO;
import co.com.sofka.biblioteca.models.RecursoModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursoMapper {

    public RecursoModel fromDTO(RecursoDTO dto) {
        RecursoModel recurso = new RecursoModel();
        recurso.setId(dto.getId());
        recurso.setNombre(dto.getNombre());
        recurso.setDisponible(dto.getDisponible());
        recurso.setFechaPrestamo(dto.getFechaPrestamo());
        recurso.setTipo(dto.getTipo());
        recurso.setAreaTematica(dto.getAreaTematica());
        return recurso;
    }

    public RecursoDTO fromCollection(RecursoModel collection){
        RecursoDTO recursoDTO = new RecursoDTO();
        recursoDTO.setId(collection.getId());
        recursoDTO.setNombre(collection.getNombre());
        recursoDTO.setDisponible(collection.getDisponible());
        recursoDTO.setFechaPrestamo(collection.getFechaPrestamo());
        recursoDTO.setTipo(collection.getTipo());
        recursoDTO.setAreaTematica(collection.getAreaTematica());
        return recursoDTO;
    }

    public List<RecursoDTO> fromCollectionList(List<RecursoModel> collection){
        if (collection == null){
            return null;
        }
        List<RecursoDTO> list = new ArrayList<>(collection.size());
        Iterator listTracks = collection.iterator();

        while (listTracks.hasNext()){
            RecursoModel recurso = (RecursoModel) listTracks.next();
            list.add(fromCollection(recurso));
        }
        return list;
    }
}