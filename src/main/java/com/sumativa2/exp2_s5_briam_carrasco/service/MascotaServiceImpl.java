package com.sumativa2.exp2_s5_briam_carrasco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumativa2.exp2_s5_briam_carrasco.model.Mascota;
import com.sumativa2.exp2_s5_briam_carrasco.respository.MascotaRepository;


@Service
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> getMascotaById(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public Mascota createMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public Mascota updateMascota(Long id, Mascota mascota) {
        if (mascotaRepository.existsById(id)) {
            mascota.setIdMascota(id);
            return mascotaRepository.save(mascota);
        } else {
            return null;
        }
    }
}
