package com.sumativa2.exp2_s5_briam_carrasco.service;

import java.util.List;
import java.util.Optional;

import com.sumativa2.exp2_s5_briam_carrasco.model.Inscripcion;

public interface InscripcionService {

    List<Inscripcion> getAllInscripciones();
    Optional<Inscripcion> getInscripcionById(Long id);
    Inscripcion createInscripcion(Inscripcion inscripcion);
    void deleteInscripcion(Long id);
    Inscripcion updateInscripcion(Long id, Inscripcion inscripcion);
    
}
