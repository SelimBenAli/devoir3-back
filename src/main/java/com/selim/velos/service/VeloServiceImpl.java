package com.selim.velos.service;

import com.selim.velos.entities.Type;
import com.selim.velos.repos.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.selim.velos.entities.Velo;
import com.selim.velos.repos.VeloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class VeloServiceImpl implements VeloService  {

    @Autowired
    VeloRepository veloRepository;

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Velo saveVelo(Velo v) {
        return veloRepository.save(v);
    }

    /*@Override
    public Velo updateVelo(Velo v) {
        return veloRepository.save(v);
    }*/

    @Override
    public Velo updateVelo(Velo v) {
        //Long oldVloImageId = this.getVelo(v.getIdVelo()).getImage().getIdImage();
        //Long newVloImageId = v.getImage().getIdImage();
        Velo vloUpdated = veloRepository.save(v);
        //if (oldVloImageId != newVloImageId) //si l'image a été modifiée
        //    imageRepository.deleteById(oldVloImageId);
        return vloUpdated;
    }

    @Override
    public void deleteVelo(Velo v) {
        veloRepository.delete(v);
    }
    @Override
    public void deleteVeloById(Long id) {
        Velo v=getVelo(id);
        try {
            Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+v.getImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        veloRepository.deleteById(id);
    }
    @Override
    public Velo getVelo(Long id) {
        return veloRepository.findById(id).get();
    }
    @Override
    public List<Velo> getAllVelos() {
        return veloRepository.findAll();
    }

    @Override
    public Page<Velo> getAllVelosParPage(int page, int size) {
        return veloRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Velo> findByModelVelo(String model) {
        return veloRepository.findByModelVelo(model);
    }

    @Override
    public List<Velo> findByModelVeloContains(String model) {
        return veloRepository.findByModelVeloContains(model);
    }

    @Override
    public List<Velo> findByModelPrix(String model, Double prix) {
        return veloRepository.findByModelPrix(model, prix);
    }

    @Override
    public List<Velo> findByType(Type type) {
        return veloRepository.findByType(type);
    }

    @Override
    public List<Velo> findByTypeIdType(Long id) {
        return veloRepository.findByTypeIdType(id);
    }

    @Override
    public List<Velo> findByOrderByModelVeloAsc() {
        return veloRepository.findByOrderByModelVeloAsc();
    }

    @Override
    public List<Velo> trierVelosModelsPrix() {
        return veloRepository.trierVelosModelsPrix();
    }


}
