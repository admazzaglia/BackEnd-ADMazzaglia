package com.portfolio.mad.Controller;

import com.portfolio.mad.Dto.dtoProyecto;
import com.portfolio.mad.Entity.Proyecto;
import com.portfolio.mad.Security.Controller.Mensaje;
import com.portfolio.mad.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://madfrontend-d13f8.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "http://localhost:4200")

public class CProyecto {

    @Autowired
    SProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro) {
        if (StringUtils.isBlank(dtopro.getNombre())) {
            return new ResponseEntity(new Mensaje("El Poryecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombre(dtopro.getNombre())) {
            return new ResponseEntity(new Mensaje("Proyecto ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtopro.getNombre(), dtopro.getDescripcion());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Nuevo Proyecto Agregado"), HttpStatus.OK);
    }

        
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro) {
        //Validamos si existe el ID
        if (!sProyecto.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        
        //Compara nombre de proyecto
        if (sProyecto.existsByNombre(dtopro.getNombre()) && sProyecto.getByNombre(dtopro.getNombre()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Ese Proyecto ya Existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if (StringUtils.isBlank(dtopro.getNombre())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombre(dtopro.getNombre());
        proyecto.setDescripcion(dtopro.getDescripcion());

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);

    }
 

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Validamos si Existe el ID
        if (!sProyecto.existsById(id)) 
            return new ResponseEntity(new Mensaje("No existe Proyecto"), HttpStatus.BAD_REQUEST);
        
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
      
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
}
