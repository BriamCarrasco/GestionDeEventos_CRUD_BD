package com.sumativa2.exp2_s5_briam_carrasco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sumativa2.exp2_s5_briam_carrasco.model.Inscripcion;
import com.sumativa2.exp2_s5_briam_carrasco.service.InscripcionService;


@RestController
@RequestMapping("/inscripciones")
@CrossOrigin(origins = "*")
public class InscripcionController {
    

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public List<Inscripcion> getallInscripcion() {
        return inscripcionService.getAllInscripciones();
    }

    @GetMapping("/{id}")
    public Optional<Inscripcion> getInscripcionById(@PathVariable Long id) {
        return inscripcionService.getInscripcionById(id);
    }

    @PostMapping
    public Inscripcion createEvento(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.createInscripcion(inscripcion);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id) {
        inscripcionService.deleteInscripcion(id);
    }

    @PutMapping("/{id}")
    public Inscripcion updateEvento(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        return inscripcionService.updateInscripcion(id, inscripcion);

    }

}
