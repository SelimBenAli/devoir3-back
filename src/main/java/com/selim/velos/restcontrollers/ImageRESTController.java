package com.selim.velos.restcontrollers;

import com.selim.velos.entities.Velo;
import com.selim.velos.service.VeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.selim.velos.entities.Image;
import com.selim.velos.service.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRESTController {
    @Autowired
    ImageService imageService;

    @Autowired
    VeloService veloService;


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }

    @PostMapping(value = "/uplaodImageVlo/{idVlo}")
    public Image uploadMultiImages(@RequestParam("image") MultipartFile file,
                                   @PathVariable("idVlo") Long idVlo)
            throws IOException {
        return imageService.uplaodImageVlo(file, idVlo);
    }

    @RequestMapping(value = "/getImagesVlo/{idVlo}",
            method = RequestMethod.GET)
    public List<Image> getImagesVlo(@PathVariable("idVlo") Long idVlo)
            throws IOException {
        return imageService.getImagesParVlo(idVlo);
    }


    @RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        return imageService.getImage(id);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }

    @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
    public void uploadImageFS(@RequestParam("image") MultipartFile
                                      file,@PathVariable("id") Long id) throws IOException {
        Velo p = veloService.getVelo(id);
        p.setImagePath(id+".jpg");

        Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
                , file.getBytes());
        veloService.saveVelo(p);

    }
    @RequestMapping(value = "/loadfromFS/{id}" ,
            method = RequestMethod.GET,
            produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

        Velo p = veloService.getVelo(id);
        return
                Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
    }

}

