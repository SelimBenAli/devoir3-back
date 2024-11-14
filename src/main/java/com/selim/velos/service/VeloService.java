package com.selim.velos.service;

import com.selim.velos.entities.Type;
import com.selim.velos.entities.Velo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VeloService {
    Velo saveVelo(Velo v);
    Velo updateVelo(Velo v);
    void deleteVelo(Velo v);
    void deleteVeloById(Long id);
    Velo getVelo(Long id);
    List<Velo> getAllVelos();

    Page<Velo> getAllVelosParPage(int page, int size);
    List<Velo> findByModelVelo(String model);
    List<Velo> findByModelVeloContains(String model);
    List<Velo> findByModelPrix (String model, Double prix);
    List<Velo> findByType (Type type);
    List<Velo> findByTypeIdType(Long id);
    List<Velo> findByOrderByModelVeloAsc();
    List<Velo> trierVelosModelsPrix();


}
