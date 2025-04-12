package com.sumativa2.exp2_s5_briam_carrasco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sumativa2.exp2_s5_briam_carrasco.model.Inscripcion;
import com.sumativa2.exp2_s5_briam_carrasco.respository.InscripcionRepository;


public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    @Override
    public Optional<Inscripcion> getInscripcionById(Long id) {
        return inscripcionRepository.findById(id);
    }

    @Override
    public Inscripcion createInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public void deleteInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }

    @Override
    public Inscripcion updateInscripcion(Long id, Inscripcion inscripcion) {
        if (inscripcionRepository.existsById(id)) {
            inscripcion.setIdInscripcion(id);
            return inscripcionRepository.save(inscripcion);
        } else {
            return null; 
        }
    }


    
}
