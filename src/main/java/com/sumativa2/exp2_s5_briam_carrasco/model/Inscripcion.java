package com.sumativa2.exp2_s5_briam_carrasco.model;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "INSCRIPCION")
public class Inscripcion extends RepresentationModel<Inscripcion> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENTO_PARTICIPANTE")
    private Long idInscripcion;

    @NotNull
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "EVENTO_ID")
    private Evento evento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PARTICIPANTE_ID")
    private Participante participante;

    public Inscripcion() {
    }

    public Long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    
}
