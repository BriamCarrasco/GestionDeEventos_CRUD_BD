package com.sumativa2.exp2_s5_briam_carrasco.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParticipanteDTO {
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    @Email(message = "El correo no es válido, debe tener el formato correcto(nombre@dominio.com)")
    private String correo;
}
