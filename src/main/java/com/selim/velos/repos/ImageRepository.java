package com.selim.velos.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.selim.velos.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}

