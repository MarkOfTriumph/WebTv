package org.generation.italy.webtv.repository;

import org.generation.italy.webtv.model.StaffVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffVideoRepository extends JpaRepository<StaffVideo, String> {

}
