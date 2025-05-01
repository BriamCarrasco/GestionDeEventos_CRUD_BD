package com.sumativa2.exp2_s5_briam_carrasco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.respository.ParticipanteRepository;

@ExtendWith(MockitoExtension.class)
public class ParticipanteServiceTest {

    @InjectMocks
    private ParticipanteServiceImpl participanteService;

    @Mock
    private ParticipanteRepository participanteRepositoryMock;

    private Participante participante;

    @BeforeEach
    public void setUp() {
        participante = new Participante();
        participante.setNombreParticipante("Juana de Arco");
        participante.setRutParticipante("12345678-9");
        participante.setCorreoParticipante("juanade.arco@gmail.com");
        participante.setTelefonoParticipante("+569 78945612");
        participante.setDireccionParticipante("Calle de la Libertad 456");
            
    }

    @AfterEach
    public void tearDown() {
        participante = null;
    }

    @Test
    @DisplayName("Test createParticipante")
    public void createParticipanteTest() 
    throws Exception 
    {
        when(participanteRepositoryMock.save(participante)).thenReturn(participante);
        Participante createdParticipante = participanteService.createParticipante(participante);
        assertEquals("Juana de Arco", createdParticipante.getNombreParticipante());
        assertEquals("12345678-9", createdParticipante.getRutParticipante());
    }

    @Test
    @DisplayName("Test getParticipanteById")
    public void getParticipanteByIdTest()
    throws Exception 
    {
        when(participanteRepositoryMock.findById(1L)).thenReturn(Optional.of(participante));
        Optional<Participante> foundParticipante = participanteService.getParticipanteById(1L);
        assertEquals("Juana de Arco", foundParticipante.get().getNombreParticipante());
        assertEquals("12345678-9", foundParticipante.get().getRutParticipante());
    }
}
