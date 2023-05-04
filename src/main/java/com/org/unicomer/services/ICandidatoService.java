package com.org.unicomer.services;

import com.org.unicomer.models.Candidato;

import java.util.List;
import java.util.Optional;

public interface ICandidatoService {
    List<Candidato> findAllCandidatos(String country);

    Optional<Candidato> createCandidato(Candidato candidato, String country);

    Optional<Candidato> updateCandidato(Candidato candidato, String country);
}
