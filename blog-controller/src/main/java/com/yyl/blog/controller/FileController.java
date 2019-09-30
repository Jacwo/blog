package com.yyl.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * author:yangyuanliang Date:2019-09-30 Time:10:18
 **/
@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping(value = "/down/{fileName}")
    public void fileDown(
            @PathVariable("fileName") String fileName,
             HttpServletRequest request,
            final HttpServletResponse response) throws  IOException {
        Enumeration<String> paramName = request.getParameterNames();
        Map<String, Object> paramMap = new HashMap<>();
        while (paramName.hasMoreElements()) {
            String param = paramName.nextElement();
            paramMap.put(param, request.getParameter(param));
        }
        fileName = URLEncoder.encode(fileName, "UTF-8").replace(".dmg", "");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "_" + sdf.format(new Date()) + ".dmg\"");
        response.setContentType("application/octet-stream;charset=UTF-8");
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        String path = FileController.class.getClassLoader().getResource("").getPath()
                + File.separator + "template" + File.separator;
        File file = new File(path + fileName + "_"  + ".dmg");
        if (!file.exists()) {
            if (!file.exists()) {
                file = new File(path + fileName + ".dmg");
            }
            if (!file.exists()) {
                file = new File(path + fileName + "_" + ".dmg");
            }

        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] b = new byte[1024];
        while(fileInputStream.read(b) > 0){
            outputStream.write(b);
        }
        fileInputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}
