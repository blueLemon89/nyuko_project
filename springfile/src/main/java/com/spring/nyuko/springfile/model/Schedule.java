package com.spring.nyuko.springfile.model;


import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;

//    @Transient
//    private MultipartFile fileType;

    public Schedule(){

    }

    public Schedule(Long id, String name, String description, String status /*MultipartFile fileType*/) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        //this.fileType = fileType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
