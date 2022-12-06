package com.spring.nyuko.springfile.controller;

import com.spring.nyuko.springfile.model.Schedule;
import com.spring.nyuko.springfile.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    public static String upLoadDirectory = System.getProperty("user.dir") + "/uploads";

    @GetMapping(value = "/")
    public String home(Model model) {
//        model.addAttribute("schedule", new Schedule());
//        List<Schedule> list = (List<Schedule>) scheduleService.findAll();
//
//        model.addAttribute("schedule", list);
        return "view/uploadfile";
    }

    @RequestMapping("/upload")
    public String upload(Model model, @RequestParam("files") MultipartFile[] files) {
        StringBuilder fileName = new StringBuilder();
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(upLoadDirectory, file.getOriginalFilename());
            fileName.append(file.getOriginalFilename());
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            model.addAttribute("msg", "Successfully uploaded files " + fileName.toString());
        }
        return "view/uploadstatusview";
    }
}
