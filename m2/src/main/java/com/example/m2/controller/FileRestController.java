package com.example.m2.controller;


import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

    @Controller
    @AllArgsConstructor
    public class FileRestController {
        //点击播放按钮，开始播放视频
        @RequestMapping(value = "/video")
        public String videoPlayByIdAndAdmin(Model model) {
            System.out.println("1212121212");
            String sourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);
            // 在mac环境下前面不加“/”读不到文件
            String realPath = "/" + sourcePath + "static/1.mp4";
            File file = new File(realPath);
            Path filePath = Paths.get(realPath);
            System.out.println(filePath);
            model.addAttribute("filePath",filePath);
//            /Users/fuyachao/IdeaProjects/m2/target/classes/static/1.mp4
            return "redirect:/user_dashboard.html";
        }


    }

