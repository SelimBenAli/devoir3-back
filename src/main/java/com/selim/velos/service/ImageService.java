package com.selim.velos.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.selim.velos.entities.Image;

public interface ImageService {
    Image uplaodImage(MultipartFile file) throws IOException;

    Image getImageDetails(Long id) throws IOException;

    ResponseEntity<byte[]> getImage(Long id) throws IOException;

    void deleteImage(Long id);

    Image uplaodImageVlo(MultipartFile file,Long idVlo) throws IOException;
    List<Image> getImagesParVlo(Long vloId);

}
