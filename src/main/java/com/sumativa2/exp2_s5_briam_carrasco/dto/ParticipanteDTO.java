package com.sumativa2.exp2_s5_briam_carrasco.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParticipanteDTO {
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String correo;
}
