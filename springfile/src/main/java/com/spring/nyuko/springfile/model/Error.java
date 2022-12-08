package com.spring.nyuko.springfile.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "error")
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "error_id")
    private Long error_id;

    @Column(name = "file_error_id")
    private Long file_error_id;

    @Column(name = "error_code")
    private String error_code;

    @Column(name = "error_name")
    private String error_name;

    public Long getError_id() {
        return error_id;
    }

    public void setError_id(Long error_id) {
        this.error_id = error_id;
    }

    public Long getFile_error_id() {
        return file_error_id;
    }

    public void setFile_error_id(Long file_error_id) {
        this.file_error_id = file_error_id;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_name() {
        return error_name;
    }

    public void setError_name(String error_name) {
        this.error_name = error_name;
    }

    public Error(String error_name) {
        this.error_name = error_name;
    }
}
