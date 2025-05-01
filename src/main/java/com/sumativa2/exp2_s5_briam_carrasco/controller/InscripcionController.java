package com.sumativa2.exp2_s5_briam_carrasco.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public CollectionModel<EntityModel<Inscripcion>> getAllInscripciones() {
        List<Inscripcion> inscripciones = inscripcionService.getAllInscripciones();

        List<EntityModel<Inscripcion>> inscripcionResources = inscripciones.stream()
                .map(inscripcion -> EntityModel.of(inscripcion,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getInscripcionById(inscripcion.getIdInscripcion())).withSelfRel()))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllInscripciones());
        return CollectionModel.of(inscripcionResources, linkTo.withRel("inscripciones"));
    }

    @GetMapping("/{id}")
    public EntityModel<Inscripcion> getInscripcionById(@PathVariable Long id) {
        Optional<Inscripcion> inscripcion = inscripcionService.getInscripcionById(id);
        if (inscripcion.isPresent()) {
            return EntityModel.of(inscripcion.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getInscripcionById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllInscripciones()).withRel("all-inscripciones"));
        } else {
            throw new RuntimeException("Inscripción no encontrada con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<Inscripcion> createInscripcion(@RequestBody Inscripcion inscripcion) {
        Inscripcion createdInscripcion = inscripcionService.createInscripcion(inscripcion);
        return EntityModel.of(createdInscripcion,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getInscripcionById(createdInscripcion.getIdInscripcion())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllInscripciones()).withRel("all-inscripciones"));
    }

    @PutMapping("/{id}")
    public EntityModel<Inscripcion> updateInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        Inscripcion updatedInscripcion = inscripcionService.updateInscripcion(id, inscripcion);
        return EntityModel.of(updatedInscripcion,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getInscripcionById(updatedInscripcion.getIdInscripcion())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllInscripciones()).withRel("all-inscripciones"));
    }

    @DeleteMapping("/{id}")
    public void deleteInscripcion(@PathVariable Long id) {
        inscripcionService.deleteInscripcion(id);
    }
}

    
