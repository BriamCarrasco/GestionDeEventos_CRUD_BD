package com.sumativa2.exp2_s5_briam_carrasco.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.respository.ParticipanteRepository;

import java.util.Optional;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ParticipanteRepositoryTest {

    @Autowired
    private ParticipanteRepository participanteRepository;

    private Participante participante;

    @BeforeEach
    public void setUp() {
        participante = new Participante();
        participante.setNombreParticipante("Pedro Pascal");
        participante.setRutParticipante("12345689-0");
        participante.setCorreoParticipante("Pedro.pascal@gmail.com");
        participante.setDireccionParticipante("Av. Siempre Viva 123");
        participante.setTelefonoParticipante("+569 8765432");
    }

    @AfterEach
    public void tearDown() {
        participanteRepository.deleteAll();
    }

    @Test
    public void createParticipanteTest() {

        Participante resultado = participanteRepository.save(participante);

        assertNotNull(resultado.getIdParticipante());
        assertEquals("Pedro Pascal", resultado.getNombreParticipante());
        
    }

    @Test
    public void findByIdTest() {
        Participante guardado = participanteRepository.save(participante);
        Optional<Participante> encontrado = participanteRepository.findById(guardado.getIdParticipante());

        assertNotNull(encontrado);
        assertEquals("Pedro Pascal", encontrado.get().getNombreParticipante());
    }
    
}
