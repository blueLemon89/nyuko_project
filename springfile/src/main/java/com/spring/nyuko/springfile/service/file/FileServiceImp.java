package com.spring.nyuko.springfile.service.file;

import com.spring.nyuko.springfile.model.File;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileServiceImp implements FileService{

    private static final Path root = Paths.get("uploads");

    @Override
    public void init(){
        try{
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload");
        }
    }
    @Override
    public void save(MultipartFile file){
        try{

            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e){
            if( e instanceof FileAlreadyExistsException){
                throw new RuntimeException("The file of that name already exists");
            }
        }
    }
    @Override
    public void deleteAll(){
        FileSystemUtils.deleteRecursively(root.toFile());

    }

    public  Resource load(String fileName){
        try {
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            }
            else {
                throw  new RuntimeException("Your file is not readable");
            }
        }
        catch (MalformedURLException e){
            throw new RuntimeException("Error" + e.getMessage());
        }

    }
    @Override
    public Stream<Path> loadAll(){
        try{
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e ){
            throw new RuntimeException("Could not load the files! ");
        }

    }
}
