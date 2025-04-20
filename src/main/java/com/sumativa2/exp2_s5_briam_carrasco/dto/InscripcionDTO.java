package com.sumativa2.exp2_s5_briam_carrasco.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InscripcionDTO {


    
    private long eventoId;

    @NotNull
    private long participanteId;
    
}
