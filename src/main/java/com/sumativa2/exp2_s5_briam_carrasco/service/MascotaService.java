package com.sumativa2.exp2_s5_briam_carrasco.service;

import java.util.List;
import java.util.Optional;

import com.sumativa2.exp2_s5_briam_carrasco.model.Mascota;

public interface MascotaService {
    List<Mascota> getAllMascotas();
    Optional<Mascota> getMascotaById(Long id);
    Mascota createMascota(Mascota mascota);
    void deleteMascota(Long id);
    Mascota updateMascota(Long id, Mascota mascota);
}
