package com.sumativa2.exp2_s5_briam_carrasco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumativa2.exp2_s5_briam_carrasco.model.Evento;
import com.sumativa2.exp2_s5_briam_carrasco.respository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Optional<Evento> getEventoById(Long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public Evento createEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    @Override
    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    @Override
    public Evento updateEvento(Long id, Evento evento) {
        if (eventoRepository.existsById(id)) {
            evento.setId(id);
            return eventoRepository.save(evento);
        } else {
            return null; 
        }
    }

    
}
