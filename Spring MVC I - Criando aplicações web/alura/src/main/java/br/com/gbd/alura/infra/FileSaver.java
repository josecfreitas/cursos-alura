package br.com.gbd.alura.infra;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/*
    Autor(es): José Carlos de Freitas
    Data: 08/03/2017 às 22:46:55
    Arquivo: FileSaver
 */
@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;

    public String grava(String baseFolder, MultipartFile file) {
        try {
            String realPath = request.getServletContext().getRealPath("/" + baseFolder);
            String path = realPath + "/" + file.getOriginalFilename();
            file.transferTo(new File(path));
            return path;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
