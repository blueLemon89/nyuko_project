package com.spring.nyuko.springfile.service.file;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;


public interface FileService {
    void init();
    void save(MultipartFile file);

    void deleteAll();

    public Resource load(String fileName);

    Stream<Path> loadAll();
}
