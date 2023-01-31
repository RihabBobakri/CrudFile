package com.fichierCrud.fihcierCrud.Service;


import com.fichierCrud.fihcierCrud.Model.Document;
import com.fichierCrud.fihcierCrud.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {
    @Autowired
    private FileRepository repository;

    public Document saveFile(MultipartFile file) throws IOException {

        String titre = file.getOriginalFilename();
        try {
           Document document=new Document();
           /* document.setTitre(titre);
            document.setDate(new Date());
            document.setMotCle(file);
        */
            document.setTitre(titre);
           // document.setType(file.getContentType());
            document.setData(file.getBytes());
            return  repository.save(document);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;

    }
    public Document saveFiles(MultipartFile[] files) {
        for (MultipartFile file : files) {

            Document document=new Document();

            try {
                document.setTitre(document.getTitre());
                document.setData(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return  repository.save(document);
        }
        return null ;
    }


    public  Optional<Document> getFile(int fileId ){
        return repository.findById(fileId);    }


    public List<Document> getFiles(){
        return  repository.findAll();
    }

  public void deleteFile( int id) throws Exception {
        repository.deleteById(id);


    }



    }



