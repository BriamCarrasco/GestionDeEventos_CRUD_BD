package com.sumativa2.exp2_s5_briam_carrasco.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "MASCOTA")
public class Mascota {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idMascota;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "NOMBRE_MASCOTA")
    private String nombreMascota;

    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EDAD_MASCOTA")
    private String edadMascota;

    @Size(min = 4, max = 50)
    @NotNull
    @Column(name = "ESPECIE_MASCOTA")
    private String especieMascota;

    @Size(min = 4, max = 50)
    @NotNull
    @Column(name = "RAZA_MASCOTA")
    private String razaMascota;

    @Size(min = 4, max = 50)
    @NotNull
    @Column(name = "COLOR_MASCOTA")
    private String colorMascota;

    @Size(min = 4, max = 10)
    @NotNull
    @Pattern(regexp = "Macho|Hembra", flags = Pattern.Flag.CASE_INSENSITIVE, message = "El género debe ser 'macho' o 'hembra'")
    @Column(name = "GENERO_MASCOTA")
    private String generoMascota;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PARTICIPANTE_ID")
    private Participante participante;

    public Mascota() {
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(String edadMascota) {
        this.edadMascota = edadMascota;
    }

    public String getEspecieMascota() {
        return especieMascota;
    }

    public void setEspecieMascota(String especieMascota) {
        this.especieMascota = especieMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getColorMascota() {
        return colorMascota;
    }

    public void setColorMascota(String colorMascota) {
        this.colorMascota = colorMascota;
    }

    public String getGeneroMascota() {
        return generoMascota;
    }

    public void setGeneroMascota(String generoMascota) {
        this.generoMascota = generoMascota;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }


}
