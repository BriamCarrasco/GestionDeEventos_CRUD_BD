package com.sumativa2.exp2_s5_briam_carrasco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sumativa2.exp2_s5_briam_carrasco.model.Evento;
import com.sumativa2.exp2_s5_briam_carrasco.model.Inscripcion;
import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.respository.EventoRepository;
import com.sumativa2.exp2_s5_briam_carrasco.respository.InscripcionRepository;



@ExtendWith(MockitoExtension.class)
public class EventoServiceTest {

    @InjectMocks
    private EventoServiceImpl eventoService;

    @Mock
    private EventoRepository eventoRepositoryMock;

    @Mock
    private InscripcionRepository inscripcionRepository;

    private Evento evento;
    private Participante participante;
    private Inscripcion inscripcion;

    @BeforeEach
    public void setUp() {
        evento = new Evento();
        evento.setId(1L);
        evento.setNombre("Feria de mascotas");
        evento.setFechaEvento(LocalDate.of(2025, 5, 15));
        evento.setLugarEvento("Parque O'Higgins");
        evento.setDescripcionEvento("Feria de adopción de mascotas");

        participante = new Participante();
        participante.setIdParticipante(1L);
        participante.setNombreParticipante("Pedro Pascal");
        participante.setRutParticipante("12345689-0");
        participante.setCorreoParticipante("Pedro.pascal@gmail.com");
        participante.setDireccionParticipante("Av. Siempre Viva 123");
        participante.setTelefonoParticipante("+569 8765432");

        inscripcion = new Inscripcion();
        inscripcion.setIdInscripcion(1L);
        inscripcion.setEvento(evento);
        inscripcion.setParticipante(participante);

    }

    @Test
    void createEvento() {

        evento.getInscripciones().add(inscripcion);
        when(eventoRepositoryMock.findById(1L)).thenReturn(Optional.of(evento));
        Optional<Evento> resultado = eventoService.getEventoById(1L);
        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getInscripciones().size());
        assertEquals("Pedro Pascal", resultado.get().getInscripciones().get(0).getParticipante().getNombreParticipante());
    }


    
}
