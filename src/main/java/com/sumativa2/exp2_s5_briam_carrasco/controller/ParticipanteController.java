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

import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.service.ParticipanteService;


@RestController
@RequestMapping("/participantes")
@CrossOrigin(origins = "*")
public class ParticipanteController {
    
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public CollectionModel<EntityModel<Participante>> getAllParticipantes() {
        List<Participante> participantes = participanteService.getAllParticipantes();

        List<EntityModel<Participante>> participanteResources = participantes.stream()
                .map(participante -> EntityModel.of(participante,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getParticipanteById(participante.getIdParticipante())).withSelfRel()))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllParticipantes());
        return CollectionModel.of(participanteResources, linkTo.withRel("participantes"));
    }

    @GetMapping("/{id}")
    public EntityModel<Participante> getParticipanteById(@PathVariable Long id) {
        Optional<Participante> participante = participanteService.getParticipanteById(id);
        if (participante.isPresent()) {
            return EntityModel.of(participante.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getParticipanteById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllParticipantes()).withRel("all-participantes"));
        } else {
            throw new RuntimeException("Participante no encontrado con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<Participante> createParticipante(@RequestBody Participante participante) {
        Participante createdParticipante = participanteService.createParticipante(participante);
        return EntityModel.of(createdParticipante,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getParticipanteById(createdParticipante.getIdParticipante())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllParticipantes()).withRel("all-participantes"));
    }

    @PutMapping("/{id}")
    public EntityModel<Participante> updateParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        Participante updatedParticipante = participanteService.updateParticipante(id, participante);
        return EntityModel.of(updatedParticipante,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getParticipanteById(updatedParticipante.getIdParticipante())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllParticipantes()).withRel("all-participantes"));
    }

    @DeleteMapping("/{id}")
    public void deleteParticipante(@PathVariable Long id) {
        participanteService.deleteParticipante(id);
    }

}
