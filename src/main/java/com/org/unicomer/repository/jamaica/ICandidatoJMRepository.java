package com.org.unicomer.repository.jamaica;

import com.org.unicomer.models.Candidato;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para candidato de la bdd de JAMAICA
 */
@Repository
public interface ICandidatoJMRepository extends JpaRepository<Candidato, Integer> {
}
