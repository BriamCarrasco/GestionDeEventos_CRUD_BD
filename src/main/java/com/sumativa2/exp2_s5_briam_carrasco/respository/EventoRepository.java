package com.sumativa2.exp2_s5_briam_carrasco.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumativa2.exp2_s5_briam_carrasco.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
