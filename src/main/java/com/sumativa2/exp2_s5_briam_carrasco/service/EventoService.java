package com.sumativa2.exp2_s5_briam_carrasco.service;

import java.util.List;
import java.util.Optional;

import com.sumativa2.exp2_s5_briam_carrasco.model.Evento;

public interface EventoService {
    List<Evento> getAllEventos();
    Optional<Evento> getEventoById(Long id);
    Evento createEvento(Evento evento);
    Evento updateEvento(Long id, Evento evento);
    void deleteEvento(Long id);
}
