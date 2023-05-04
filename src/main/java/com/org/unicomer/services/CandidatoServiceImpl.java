package com.org.unicomer.services;

import com.org.unicomer.models.Candidato;
import com.org.unicomer.repository.costarica.ICandidatoCRRepository;
import com.org.unicomer.repository.guatemala.ICandidatoGTRepository;
import com.org.unicomer.repository.jamaica.ICandidatoJMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para candidato unicomer
 */
@Service
public class CandidatoServiceImpl implements ICandidatoService {
    private ICandidatoGTRepository candidatoGuatemalaRepository;
    private ICandidatoCRRepository candidatoCostaRicaRepository;
    private ICandidatoJMRepository candidatoJamaicaRepository;

    @Autowired
    public CandidatoServiceImpl(ICandidatoGTRepository candidatoGuatemalaRepository, ICandidatoCRRepository candidatoCostaRicaRepository, ICandidatoJMRepository candidatoJamaicaRepository) {
        this.candidatoGuatemalaRepository = candidatoGuatemalaRepository;
        this.candidatoCostaRicaRepository = candidatoCostaRicaRepository;
        this.candidatoJamaicaRepository = candidatoJamaicaRepository;
    }

    @Override
    public List<Candidato> findAllCandidatos(String country) {
        List<Candidato> candidatos = null;
        if (country.equalsIgnoreCase("Costa Rica")){
            candidatos = candidatoCostaRicaRepository.findAll();
            return candidatos;
        } else if (country.equalsIgnoreCase("Guatemala")) {
             candidatos = candidatoGuatemalaRepository.findAll();
            return candidatos;
        }else{
             candidatos = candidatoJamaicaRepository.findAll();
            return candidatos;
        }
    }

    @Override
    public Optional<Candidato> createCandidato(Candidato candidato, String country) {
        if (country.equalsIgnoreCase("Costa Rica")&& !country.isEmpty())
            return Optional.of(candidatoCostaRicaRepository.save(candidato));
        else if (country.equalsIgnoreCase("Guatemala")&& !country.isEmpty())
            return Optional.of(candidatoGuatemalaRepository.save(candidato));
        else if (country.equalsIgnoreCase("Jamaica") && !country.isEmpty())
            return Optional.of(candidatoJamaicaRepository.save(candidato));
        else
            return Optional.empty();
    }

    @Override
    public Optional<Candidato> updateCandidato(Candidato candidato, String country) {
        if (country.equalsIgnoreCase("Costa Rica")&& !country.isEmpty()){
            if(candidatoCostaRicaRepository.findById(candidato.getId_candidato()).isEmpty())
                return Optional.empty();
            return Optional.of(candidatoCostaRicaRepository.save(candidato));
        } else if (country.equalsIgnoreCase("Guatemala")&& !country.isEmpty()){
                if (candidatoGuatemalaRepository.findById(candidato.getId_candidato()).isEmpty())
                    return Optional.empty();
            return Optional.of(candidatoGuatemalaRepository.save(candidato));
        } else if (country.equalsIgnoreCase("Jamaica") && !country.isEmpty()){
            if (candidatoJamaicaRepository.findById(candidato.getId_candidato()).isEmpty())
                return Optional.empty();
            return Optional.of(candidatoJamaicaRepository.save(candidato));
        }else {
            return Optional.empty();
        }
    }
}
