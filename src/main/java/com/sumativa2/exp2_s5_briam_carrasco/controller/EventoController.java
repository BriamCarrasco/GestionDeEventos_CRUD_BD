package com.sumativa2.exp2_s5_briam_carrasco.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumativa2.exp2_s5_briam_carrasco.dto.EventoDTO;
import com.sumativa2.exp2_s5_briam_carrasco.dto.ParticipanteDTO;
import com.sumativa2.exp2_s5_briam_carrasco.model.Evento;
import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.service.EventoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class EventoController {
    
    @Autowired
    private EventoService eventoService;

    private EventoDTO convertToDTO(Evento evento) {
    EventoDTO dto = new EventoDTO();
    dto.setId(evento.getId());
    dto.setNombre(evento.getNombre());
    dto.setFecha(evento.getFechaEvento());
    dto.setLugar(evento.getLugarEvento());
    dto.setDescripcion(evento.getDescripcionEvento());


    List<ParticipanteDTO> participantes = evento.getInscripciones().stream()
        .map(inscripcion -> {
            Participante p = inscripcion.getParticipante();
            ParticipanteDTO pdto = new ParticipanteDTO();
            pdto.setId(p.getIdParticipante());
            pdto.setNombre(p.getNombreParticipante());
            pdto.setCorreo(p.getCorreoParticipante());
            return pdto;
        }).collect(Collectors.toList());

    dto.setParticipantes(participantes);

    return dto;
}

    @GetMapping
    public ResponseEntity<List<EventoDTO>> getAllEventos() {
        List<Evento> eventos = eventoService.getAllEventos();

        List<EventoDTO> eventoDTOs = eventos.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());

        return ResponseEntity.ok(eventoDTOs);
    }

    @GetMapping("/{id}")
    public Optional<Evento> getEventoById(@PathVariable Long id) {
        return eventoService.getEventoById(id);
    }

    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.createEvento(evento);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
    }

    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
        return eventoService.updateEvento(id, evento);

    }
    
}
