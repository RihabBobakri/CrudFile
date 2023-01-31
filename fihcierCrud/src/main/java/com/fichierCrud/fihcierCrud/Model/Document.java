package com.fichierCrud.fihcierCrud.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="Document")
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idd", nullable = false)
    private UUID idd;

   /* @Id
    @GeneratedValue(generator = "uuid2",strategy = GenerationType.AUTO)
    @GenericGenerator(name  ="uuid2",strategy ="uuid2")
    @Column(name = "id")
    private UUID id;*/


   /* @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;*/




    private  String titre;
    private  String motCle;
    private Date date ;


    @Lob
    private byte[] data;

   /* public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }
//import org.springframework.ui.Model;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/
}
