package com.selim.velos.repos;

import com.selim.velos.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import com.selim.velos.entities.Velo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface VeloRepository extends JpaRepository<Velo, Long> {
    List<Velo> findByModelVelo(String model);
    List<Velo> findByModelVeloContains(String model);
    /*@Query("select v from Velo v where v.modelVelo like %?1 and v.prixVelo > ?2")
    List<Velo> findByModelPrix (String model, Double prix);*/
    @Query("select v from Velo v where v.modelVelo like %:model and v.prixVelo > :prix")
    List<Velo> findByModelPrix (@Param("model") String model, @Param("prix") Double prix);
    @Query("select v from Velo v where v.type = ?1")
    List<Velo> findByType (Type type);
    List<Velo> findByTypeIdType(Long id);
    List<Velo> findByOrderByModelVeloAsc();
    @Query("select v from Velo v order by v.modelVelo ASC, v.prixVelo DESC")
    List<Velo> trierVelosModelsPrix ();



}