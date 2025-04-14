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

import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.service.ParticipanteService;

@RestController
@RequestMapping("/participantes")
@CrossOrigin(origins = "*")
public class ParticipanteController {
    
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public List<Participante> getAllParticipantes() {
        return participanteService.getAllParticipantes();
    }

    @GetMapping("/{id}")
    public Optional<Participante> getParticipanteById(@PathVariable Long id) {
        return participanteService.getParticipanteById(id);
    }

    @PostMapping
    public Participante createParticipante(@RequestBody Participante participante) {
        return participanteService.createParticipante(participante);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipante(@PathVariable Long id) {
        participanteService.deleteParticipante(id);
    }

    @PutMapping("/{id}")
    public Participante updateParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        return participanteService.updateParticipante(id, participante);

    }

    
}
