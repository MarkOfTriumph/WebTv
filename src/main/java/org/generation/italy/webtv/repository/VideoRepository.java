package org.generation.italy.webtv.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.generation.italy.webtv.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.PersistenceContext;

public interface VideoRepository extends JpaRepository<Video, Integer> {


    List<Video> findByTitoloContainingIgnoreCase(String titolo);
    

}
