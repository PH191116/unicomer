package com.org.unicomer.repository.guatemala;

import com.org.unicomer.models.Candidato;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para candidato de la bdd de Guatemala
 */
@Repository
public interface ICandidatoGTRepository extends JpaRepository<Candidato, Integer> {
}
