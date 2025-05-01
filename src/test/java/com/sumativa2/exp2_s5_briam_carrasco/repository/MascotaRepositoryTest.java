package com.sumativa2.exp2_s5_briam_carrasco.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.sumativa2.exp2_s5_briam_carrasco.model.Mascota;
import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.respository.MascotaRepository;
import com.sumativa2.exp2_s5_briam_carrasco.respository.ParticipanteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MascotaRepositoryTest {
    
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private ParticipanteRepository participanteRepository;

    private Participante participante;
    private Mascota mascota;

    @BeforeEach
    public void setUp() {
        participante = new Participante();
        participante.setNombreParticipante("Pedro Pascal");
        participante.setRutParticipante("12345689-0");
        participante.setCorreoParticipante("Pedro.pascal@gmail.com");
        participante.setDireccionParticipante("Av. Siempre Viva 123");
        participante.setTelefonoParticipante("+569 8765432");

        mascota = new Mascota();
        mascota.setNombreMascota("boby");
        mascota.setEdadMascota("5");
        mascota.setEspecieMascota("perro");
        mascota.setRazaMascota("labrador");
        mascota.setColorMascota("marron");
        mascota.setGeneroMascota("Macho");
        mascota.setParticipante(participante);
    }

    @AfterEach
    public void tearDown() {
        mascotaRepository.deleteAll();
    }


    @Test
    public void createMascotaTest() {
    Participante participanteGuardado = participanteRepository.save(participante);
    
    mascota.setParticipante(participanteGuardado);
    Mascota resultado = mascotaRepository.save(mascota);

    assertNotNull(resultado.getIdMascota());
    assertEquals("boby", resultado.getNombreMascota());
    assertEquals("Pedro Pascal", resultado.getParticipante().getNombreParticipante());
    }

    @Test
    public void findByIdTest() {
        Participante participanteGuardado = participanteRepository.save(participante);
        mascota.setParticipante(participanteGuardado);
        Mascota guardado = mascotaRepository.save(mascota);
        Mascota encontrado = mascotaRepository.findById(guardado.getIdMascota()).orElse(null);

        assertNotNull(encontrado);
        assertEquals("boby", encontrado.getNombreMascota());
        assertEquals("Pedro Pascal", encontrado.getParticipante().getNombreParticipante());
    }


}
