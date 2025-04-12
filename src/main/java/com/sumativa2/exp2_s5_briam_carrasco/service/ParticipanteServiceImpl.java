package com.sumativa2.exp2_s5_briam_carrasco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.respository.ParticipanteRepository;

public class ParticipanteServiceImpl implements ParticipanteService {
    
    @Autowired
    private ParticipanteRepository participanteRepository;

    @Override
    public List<Participante> getAllParticipantes() {
        return participanteRepository.findAll();
    }

    @Override
    public Optional<Participante> getParticipanteById(Long id) {
        return participanteRepository.findById(id);
    }

    @Override
    public Participante createParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    @Override
    public void deleteParticipante(Long id) {
        participanteRepository.deleteById(id);
    }

    @Override
    public Participante updateParticipante(Long id, Participante participante) {
        if (participanteRepository.existsById(id)) {
            participante.setIdParticipante(id);
            return participanteRepository.save(participante);
        } else {
            return null;
        }
    }
}
