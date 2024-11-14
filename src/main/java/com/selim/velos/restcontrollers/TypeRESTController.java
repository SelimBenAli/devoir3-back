package com.selim.velos.restcontrollers;

import com.selim.velos.entities.Type;
import com.selim.velos.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type")
@CrossOrigin("*")
public class TypeRESTController {

    @Autowired
    TypeRepository typeRepository;

    @RequestMapping(method= RequestMethod.GET)
    public List<Type> getAllTypes()
    {
        return typeRepository.findAll();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Type getTypeById(@PathVariable("id") Long id) {
        return typeRepository.findById(id).get();
    }
}
