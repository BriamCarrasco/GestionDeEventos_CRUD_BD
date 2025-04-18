package com.sumativa2.exp2_s5_briam_carrasco.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

import com.sumativa2.exp2_s5_briam_carrasco.model.Evento;
import com.sumativa2.exp2_s5_briam_carrasco.model.Inscripcion;
import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.respository.EventoRepository;
import com.sumativa2.exp2_s5_briam_carrasco.respository.ParticipanteRepository;
import com.sumativa2.exp2_s5_briam_carrasco.service.InscripcionService;


@RestController
@RequestMapping("/inscripciones")
@CrossOrigin(origins = "*")
public class InscripcionController {
    

    @Autowired
    private InscripcionService inscripcionService;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ParticipanteRepository participanteRepository;


    @PostMapping
    public ResponseEntity<Inscripcion> createInscripcion(@RequestBody Map<String, Long> request) {
        // Obtiene los IDs desde el cuerpo de la solicitud
        Long eventoId = request.get("eventoId");
        Long participanteId = request.get("participanteId");
    
        // Busca las entidades en el repositorio
        Evento evento = eventoRepository.findById(eventoId).orElse(null);
        Participante participante = participanteRepository.findById(participanteId).orElse(null);
        
        if (evento == null || participante == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Retorna error si no se encuentran
        }
        
        // Crea la inscripcion con las entidades obtenidas
        Inscripcion inscripcionEntity = new Inscripcion();
        inscripcionEntity.setEvento(evento);
        inscripcionEntity.setParticipante(participante);
        
        // Guarda la inscripcion en el repositorio
        Inscripcion createdInscripcion = inscripcionService.createInscripcion(inscripcionEntity);
        
        return new ResponseEntity<>(createdInscripcion, HttpStatus.CREATED);
    }


    @GetMapping
    public List<Inscripcion> getallInscripcion() {
        return inscripcionService.getAllInscripciones();
    }

    @GetMapping("/{id}")
    public Optional<Inscripcion> getInscripcionById(@PathVariable Long id) {
        return inscripcionService.getInscripcionById(id);
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
