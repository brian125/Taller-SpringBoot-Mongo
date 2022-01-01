package co.com.sofka.biblioteca.controllers;

import co.com.sofka.biblioteca.dtos.RecursoDTO;
import co.com.sofka.biblioteca.helpers.Buscar;
import co.com.sofka.biblioteca.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    @Autowired
    RecursoService service;

    @PostMapping()
    public ResponseEntity<RecursoDTO> postRecurso(@RequestBody RecursoDTO recursoDTO){
        return new ResponseEntity(service.crear(recursoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/diponible/{id}")
    public ResponseEntity<RecursoDTO> getDisponibilidad(@PathVariable("id") String id){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<RecursoDTO> getRecursos() {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/prestamo/{id}")
    public ResponseEntity<RecursoDTO> putPrestamo(@PathVariable String id){
        return new ResponseEntity(service.mostrarPrestamoRecurso(id), HttpStatus.OK);
    }

    @PutMapping("/devolver/{id}")
    public ResponseEntity<RecursoDTO> putDevolucion(@PathVariable String id){
        return new ResponseEntity(service.devolverRecurso(id), HttpStatus.OK);
    }

    @GetMapping("/buscar/area/{area}")
    public ResponseEntity<RecursoDTO> buscarArea(@PathVariable String area){
        return new ResponseEntity(service.findByAreaTematica(area), HttpStatus.OK);
    }

    @GetMapping("/buscar/tipo/{tipo}")
    public ResponseEntity<RecursoDTO> buscarTipo(@PathVariable String tipo){
        return new ResponseEntity(service.findByTipo(tipo), HttpStatus.OK);
    }

    @GetMapping("/buscar/areaytipo")
    public ResponseEntity<RecursoDTO> buscarAreaYTipo(@RequestBody Buscar buscar){
        return new ResponseEntity(service.findByAreaYTipo(buscar.getAreaTematica(), buscar.getTipo()), HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity deleteRecurso(@PathVariable("id") String id){
        try {
            service.deleteByid(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }




}
