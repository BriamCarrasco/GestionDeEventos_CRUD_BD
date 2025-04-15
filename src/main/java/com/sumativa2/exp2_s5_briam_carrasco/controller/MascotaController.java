package com.sumativa2.exp2_s5_briam_carrasco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumativa2.exp2_s5_briam_carrasco.dto.MascotaDTO;
import com.sumativa2.exp2_s5_briam_carrasco.model.Mascota;
import com.sumativa2.exp2_s5_briam_carrasco.model.Participante;
import com.sumativa2.exp2_s5_briam_carrasco.respository.MascotaRepository;
import com.sumativa2.exp2_s5_briam_carrasco.respository.ParticipanteRepository;
import com.sumativa2.exp2_s5_briam_carrasco.service.MascotaService;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {
    
    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @PostMapping
    public ResponseEntity<Mascota> createMascota(@RequestBody MascotaDTO mascotaDTO) {
        Participante participante = participanteRepository.findById(mascotaDTO.getParticipanteId())
                .orElseThrow(() -> new RuntimeException("Participante no encontrado"));

        Mascota mascota = new Mascota();
        mascota.setNombreMascota(mascotaDTO.getNombreMascota());
        mascota.setEdadMascota(mascotaDTO.getEdadMascota());
        mascota.setEspecieMascota(mascotaDTO.getEspecieMascota());
        mascota.setRazaMascota(mascotaDTO.getRazaMascota());
        mascota.setColorMascota(mascotaDTO.getColorMascota());
        mascota.setGeneroMascota(mascotaDTO.getGeneroMascota());
        mascota.setParticipante(participante);

        Mascota savedMascota = mascotaRepository.save(mascota);
        return new ResponseEntity<>(savedMascota, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Mascota> getAllMascotas() {
        return mascotaService.getAllMascotas();
    }

    @GetMapping("/{id}")
    public Optional<Mascota> getMascotaById(@PathVariable Long id) {
        return mascotaService.getMascotaById(id);
    }

    /* 
    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.createMascota(mascota);
    }

    */

    @DeleteMapping("/{id}")
    public void deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
    }

    @PutMapping("/{id}")
    public Mascota updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        return mascotaService.updateMascota(id, mascota);
    }

        
}
