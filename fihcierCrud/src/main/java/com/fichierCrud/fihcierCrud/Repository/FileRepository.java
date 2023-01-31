package com.fichierCrud.fihcierCrud.Repository;


import com.fichierCrud.fihcierCrud.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository  extends JpaRepository<Document,Integer> {
}
