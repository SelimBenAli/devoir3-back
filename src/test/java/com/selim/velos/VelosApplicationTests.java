package com.selim.velos;

import com.selim.velos.entities.Type;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.selim.velos.entities.Velo;
import com.selim.velos.repos.VeloRepository;
import org.springframework.data.domain.Page;
import com.selim.velos.service.VeloService;

import java.util.Date;
import java.util.List;


@SpringBootTest
class VelosApplicationTests {
    @Autowired
    private VeloRepository veloRepository;

    @Autowired
    private VeloService veloService;

    @Test
    public void testFindByNomVelo()
    {
        List<Velo> vls = veloRepository.findByModelVelo("SCOTT 20");
        for (Velo v : vls)
        {
            System.out.println(v);
        }
        System.out.println("////////////////");
    }

    @Test
    public void testfindByModelPrix()
    {
        List<Velo> vls = veloRepository.findByModelPrix("SCOTT 20", 800.0);
        for (Velo v : vls)
        {
            System.out.println("/////" + v);
        }
        System.out.println("///////////");
    }

    @Test
    public void testfindByType()
    {
        Type tp = new Type();
        tp.setIdType(1L);
        List<Velo> vls = veloRepository.findByType(tp);
        for (Velo v : vls)
        {
            System.out.println(v);
        }
        System.out.println("******");
    }

    @Test
    public void findByTypeIdType()
    {
        List<Velo> vls = veloRepository.findByTypeIdType(1L);
        for (Velo v : vls)
        {
            System.out.println(v);
        }
    }

    @Test
    public void testfindByOrderByModelVeloAsc()
    {
        List<Velo> vls =
                veloRepository.findByOrderByModelVeloAsc();
        for (Velo v : vls)
        {
            System.out.println(v);
        }
    }

    @Test
    public void testTrierVelosModelsPrix()
    {
        List<Velo> vls = veloRepository.trierVelosModelsPrix();
        for (Velo v : vls)
        {
            System.out.println(v);
        }
    }

    /*@Test
    public void testCreateVelo() {
        Velo vel = new Velo("Trek Fues 9.5", 1500.0, new Date());
        veloRepository.save(vel);
    }


    @Test
    public void testFindVelo() {
        Velo v = veloRepository.findById(1L).get();
        System.out.println(v);
    }

    @Test
    public void testUpdateVelo()
    {
        Velo v = veloRepository.findById(1L).get();
        v.setPrixVelo(1000.0);
        veloRepository.save(v);
    }

        @Test
        public void testDeleteVelo()
        {
            veloRepository.deleteById(1L);;
        }*/


    @Test
    public void testListerTousVelos()
    {
        List<Velo> vls = veloRepository.findAll();
        for (Velo v : vls)
        {
            System.out.println(v);
        }
    }

    @Test
    public void testFindByNomVeloContains()
    {
        Page<Velo> vls = veloService.getAllVelosParPage(0,2);
        System.out.println(vls.getSize());
        System.out.println(vls.getTotalElements());
        System.out.println(vls.getTotalPages());
        vls.getContent().forEach(v -> {System.out.println(v.toString());
        });

    }

}
