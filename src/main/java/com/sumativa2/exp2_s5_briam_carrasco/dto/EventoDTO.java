package com.sumativa2.exp2_s5_briam_carrasco.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventoDTO {

    
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private String lugar;

    @NotNull
    private String descripcion;

    @NotNull
    private List<ParticipanteDTO> participantes;
}
