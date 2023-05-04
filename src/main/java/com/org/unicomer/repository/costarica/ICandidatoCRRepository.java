package com.org.unicomer.repository.costarica;

import com.org.unicomer.models.Candidato;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para candidato de la bdd de COSTA RICA
 */
@Repository
public interface ICandidatoCRRepository extends JpaRepository<Candidato, Integer> {
}
