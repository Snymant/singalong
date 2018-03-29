/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bronkode.singalong.home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author theuns
 */
@Controller
public class homeController {
    
    @Value("${audioFolder}")
    private String audioFolder;
    
    
    @GetMapping({"/",""})
    public String getHomePage(Model model){
        model.addAttribute("audioFolder", audioFolder);
        return "home";
    }
    
    @GetMapping(value = "/audio/{filename}", 
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] getAudioFile(@PathVariable("filename") String fileName){
        
        try {
            FileInputStream fis = new FileInputStream(audioFolder + "\\" + fileName);
            return IOUtils.toByteArray(fis);
        } catch (Exception ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
