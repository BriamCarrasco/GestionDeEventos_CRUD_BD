package com.sumativa2.exp2_s5_briam_carrasco.dto;

import java.util.List;

import lombok.Data;

@Data
public class EventoDTO {
    private Long id;
    private String nombre;
    private String lugar;
    private List<ParticipanteDTO> participantes;
}
