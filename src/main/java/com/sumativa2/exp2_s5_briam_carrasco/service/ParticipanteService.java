package com.sumativa2.exp2_s5_briam_carrasco.service;

import java.util.List;
import java.util.Optional;

import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;

public interface ParticipanteService {
    List<Participante> getAllParticipantes();
    Optional<Participante> getParticipanteById(Long id);
    Participante createParticipante(Participante participante);
    void deleteParticipante(Long id);
    Participante updateParticipante(Long id, Participante participante);

}
