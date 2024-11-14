package com.selim.velos.repos;

import com.selim.velos.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "type")
@CrossOrigin(origins = "http://localhost:4200/") //pour autoriser angular
public interface TypeRepository extends JpaRepository<Type, Long> {
}
