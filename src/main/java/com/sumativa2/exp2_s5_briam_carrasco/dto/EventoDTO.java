package com.sumativa2.exp2_s5_briam_carrasco.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class EventoDTO {
    private Long id;
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private String descripcion;
    private List<ParticipanteDTO> participantes;
}
