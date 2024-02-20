package org.generation.italy.webtv.repository;

import java.util.Optional;

import org.generation.italy.webtv.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	Optional <Utente> findByUsername (String username);
}
