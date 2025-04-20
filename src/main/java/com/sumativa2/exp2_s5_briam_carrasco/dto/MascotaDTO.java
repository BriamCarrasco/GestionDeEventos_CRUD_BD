package com.sumativa2.exp2_s5_briam_carrasco.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MascotaDTO {

    @NotNull
    private String nombreMascota;

    @NotNull
    private String edadMascota;

    @NotNull
    private String especieMascota;

    @NotNull
    private String razaMascota;

    @NotNull
    private String colorMascota;

    @NotNull
    private String generoMascota;

    @NotNull
    private Long participanteId;
}


