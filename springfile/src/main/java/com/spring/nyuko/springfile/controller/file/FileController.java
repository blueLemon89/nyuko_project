package com.spring.nyuko.springfile.controller.file;

import com.spring.nyuko.springfile.model.Error;
import com.spring.nyuko.springfile.model.File;
import com.spring.nyuko.springfile.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("http://localhost:8080")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<Error> uploadFile(@RequestParam("file")MultipartFile file){
        String name = "";
        Error error = new Error();
        try{
            fileService.save(file);
            name = "Upload the file successfully: " + file.getOriginalFilename();
            error.setError_name(name);
            return new ResponseEntity<>(error,HttpStatus.OK);
        } catch (Exception e){
            name = "Could not upload the file: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Error(name));
        }
    }
    @GetMapping("/files")
    public ResponseEntity<List<File>> getListFile(){
        List<File> files = fileService.loadAll().map(path -> {
            String fileName = path.getFileName().toString();
            String url = String.valueOf(MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()));
            return new File(fileName, url);
        }).collect(Collectors.toList());
        return  ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName){
        Resource file = fileService.load(fileName);
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName = \"" + file.getFilename() + "\"").body(file);
    }
}
