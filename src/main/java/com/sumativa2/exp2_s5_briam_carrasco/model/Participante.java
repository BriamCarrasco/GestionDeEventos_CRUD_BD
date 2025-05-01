package com.sumativa2.exp2_s5_briam_carrasco.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PARTICIPANTE")
public class Participante extends RepresentationModel<Participante> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idParticipante;


    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "NOMBRE_PARTICIPANTE")
    private String nombreParticipante;

    @NotNull
    @Size(min = 9, max = 12)
    @Column(name = "RUT_PARTICIPANTE")
    private String rutParticipante;

    @NotNull
    @Email(message = "El correo no es válido, debe tener el formato correcto(nombre@dominio.com)")
    @Column(name = "CORREO_PARTICIPANTE")
    private String correoParticipante;

    @NotNull
    @Size(min = 9, max = 12)
    @Column(name = "TELEFONO_PARTICIPANTE")
    private String telefonoParticipante;

    @NotNull
    @Size(min = 10, max = 100)
    @Column(name = "DIRECCION_PARTICIPANTE")
    private String direccionParticipante;

    public Participante() {
    }

    public Long getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Long idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public String getRutParticipante() {
        return rutParticipante;
    }

    public void setRutParticipante(String rutParticipante) {
        this.rutParticipante = rutParticipante;
    }

    public String getCorreoParticipante() {
        return correoParticipante;
    }

    public void setCorreoParticipante(String correoParticipante) {
        this.correoParticipante = correoParticipante;
    }

    public String getTelefonoParticipante() {
        return telefonoParticipante;
    }

    public void setTelefonoParticipante(String telefonoParticipante) {
        this.telefonoParticipante = telefonoParticipante;
    }

    public String getDireccionParticipante() {
        return direccionParticipante;
    }

    public void setDireccionParticipante(String direccionParticipante) {
        this.direccionParticipante = direccionParticipante;
    }


}
