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

import com.sumativa2.exp2_s5_briam_carrasco.model.Mascota;
import com.sumativa2.exp2_s5_briam_carrasco.service.MascotaService;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {
    
    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public CollectionModel<EntityModel<Mascota>> getAllMascotas() {
        List<Mascota> mascotas = mascotaService.getAllMascotas();

        List<EntityModel<Mascota>> mascotaResources = mascotas.stream()
                .map(mascota -> EntityModel.of(mascota,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMascotaById(mascota.getIdMascota())).withSelfRel()))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMascotas());
        return CollectionModel.of(mascotaResources, linkTo.withRel("mascotas"));
    }

    @GetMapping("/{id}")
    public EntityModel<Mascota> getMascotaById(@PathVariable Long id) {
        Optional<Mascota> mascota = mascotaService.getMascotaById(id);
        if (mascota.isPresent()) {
            return EntityModel.of(mascota.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMascotaById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMascotas()).withRel("all-mascotas"));
        } else {
            throw new RuntimeException("Mascota no encontrada con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<Mascota> createMascota(@RequestBody Mascota mascota) {
        Mascota createdMascota = mascotaService.createMascota(mascota);
        return EntityModel.of(createdMascota,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMascotaById(createdMascota.getIdMascota())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMascotas()).withRel("all-mascotas"));
    }

    @PutMapping("/{id}")
    public EntityModel<Mascota> updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota updatedMascota = mascotaService.updateMascota(id, mascota);
        return EntityModel.of(updatedMascota,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMascotaById(updatedMascota.getIdMascota())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMascotas()).withRel("all-mascotas"));
    }

    @DeleteMapping("/{id}")
    public void deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
    }
    
}
