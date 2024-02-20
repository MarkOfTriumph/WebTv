package org.generation.italy.webtv.repository;
import java.util.List;
import javax.persistence.EntityManager;
import org.generation.italy.webtv.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;



@Repository
public interface CustomQueryRepository extends JpaRepository<Video, Integer>  {

  
    @Query("SELECT v FROM Video v WHERE v.approvazione = false")
    public List<Video> findUnapprovedVideos();
    
    
}
