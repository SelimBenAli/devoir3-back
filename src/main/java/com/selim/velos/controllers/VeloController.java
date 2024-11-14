package com.selim.velos.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.selim.velos.entities.Velo;
import com.selim.velos.service.VeloService;

@Controller
public class VeloController {
    @Autowired
    VeloService veloService;

    @RequestMapping("/ListeVelos")
    public String listeiVelos(ModelMap modelMap,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Velo> vls = veloService.getAllVelosParPage(page, size);
        modelMap.addAttribute("velos", vls);
        modelMap.addAttribute("pages", new int[vls.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeVelos";

    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createVelo";
    }

    @RequestMapping("/saveVelo")
    public String saveVelo(@ModelAttribute("velo") Velo velo,
                           @RequestParam("date") String date,
                           ModelMap modelMap) throws ParseException {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        velo.setDateCreation(dateCreation);

        Velo saveVelo = veloService.saveVelo(velo);
        String msg = "velo enregistré avec Id " + saveVelo.getIdVelo();
        modelMap.addAttribute("msg", msg);
        return "createVelo";
    }

    @RequestMapping("/supprimerVelo")
    public String supprimerVelo(@RequestParam("id") Long id,
                                ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size) {
        veloService.deleteVeloById(id);
        Page<Velo> vls = veloService.getAllVelosParPage(page, size);
        modelMap.addAttribute("velos", vls);
        modelMap.addAttribute("pages", new int[vls.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeVelos";
    }

    @RequestMapping("/modifierVelo")
    public String editerVelo(@RequestParam("id") Long id,
                             ModelMap modelMap) {
        Velo v = veloService.getVelo(id);
        modelMap.addAttribute("velo", v);
        return "editerVelo";
    }

    @RequestMapping("/updateVelo")
    public String updateVelo(@ModelAttribute("velo") Velo
                                     velo, @RequestParam("date") String date,
                             ModelMap modelMap) throws ParseException {

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        velo.setDateCreation(dateCreation);

        veloService.updateVelo(velo);
        List<Velo> vls = veloService.getAllVelos();
        modelMap.addAttribute("velos", vls);
        return "listeVelos";
    }
}
