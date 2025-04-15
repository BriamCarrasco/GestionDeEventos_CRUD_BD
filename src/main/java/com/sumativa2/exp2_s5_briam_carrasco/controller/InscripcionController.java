package com.sumativa2.exp2_s5_briam_carrasco.controller;
import java.util.List;
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
import com.sumativa2.exp2_s5_briam_carrasco.model.Inscripcion;
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


    private Inscripcion convertToEntity(Inscripcion inscripcion) {
        Inscripcion inscripcionEntity = new Inscripcion();
        inscripcionEntity.setEvento(eventoRepository.findById(inscripcion.getEvento().getId()).orElse(null));
        inscripcionEntity.setParticipante(participanteRepository.findById(inscripcion.getParticipante().getIdParticipante()).orElse(null));
        return inscripcionEntity;
    }

    @PostMapping
    public ResponseEntity<Inscripcion> createInscripcion(@RequestBody Inscripcion inscripcion) {
        Inscripcion inscripcionEntity = convertToEntity(inscripcion);
        if (inscripcionEntity.getEvento() == null || inscripcionEntity.getParticipante() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
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



    /*
    @PostMapping
    public ResponseEntity<Inscripcion> createInscripcion(@RequestBody Inscripcion inscripcion) {
        Inscripcion createdInscripcion = inscripcionService.createInscripcion(inscripcion);
        return new ResponseEntity<>(createdInscripcion, HttpStatus.CREATED);
    }

    */
    /*@PostMapping
    public Inscripcion createEvento(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.createInscripcion(inscripcion);
    }*/

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id) {
        inscripcionService.deleteInscripcion(id);
    }

    @PutMapping("/{id}")
    public Inscripcion updateEvento(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        return inscripcionService.updateInscripcion(id, inscripcion);

    }

}
