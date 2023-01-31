package com.fichierCrud.fihcierCrud.Controller;



import com.fichierCrud.fihcierCrud.Model.Document;
import com.fichierCrud.fihcierCrud.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController

public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/home")
    public String home(){
        return  "welcome !!!!";
    }




 @GetMapping("/doc")
    public  List<Document>getFile(Model model){
        List<Document> docs=fileService.getFiles();
        model.addAttribute("docs",docs);

        return docs;
    }

    @PostMapping("/File")
    public String uploadFile (@RequestParam("file") MultipartFile[] files) throws IOException {
        for (MultipartFile file: files) {
            fileService.saveFile(file);
        }
        return  "redirect:/";
    }

    @PostMapping("/Files")
    public String uploadFiles (@RequestParam("files") MultipartFile[] files) throws IOException {
        for (MultipartFile file: files) {
            fileService.saveFiles(files);
        }
        return  "redirect files:/";
    }

  /*  @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable UUID fileId){
        Document doc = fileService.getFile(fileId).get();
        return ResponseEntity.ok()
              //  .contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getTitre()+"\"")
                .body(new ByteArrayResource(doc.getData()));
    }*/



   /* @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) throws Exception{
        fileService.deleteFile(id);

        return new ResponseEntity<String>("Product with id "+id+"  has been deleted", HttpStatus.OK);
    }*/

}


