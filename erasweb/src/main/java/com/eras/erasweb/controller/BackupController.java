package com.eras.erasweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eras.erasweb.service.impl.BackupFileService;
import com.eras.erasweb.service.impl.RestoreService;

import java.io.IOException;
import java.util.List;

@Controller
public class BackupController {

    @Autowired
    private BackupFileService backupFileService;

    @GetMapping("/maintenance/backup/list")
    public String showBackupFiles(Model model) {
        List<String> backupFiles = backupFileService.listBackupFiles();
        model.addAttribute("backupFiles", backupFiles);
        return "backupList"; // The name of your Thymeleaf template
    }
    
    @Autowired
    private RestoreService restoreService;

    @PostMapping("/maintenance/restore")
    public String restoreBackup(@RequestParam("backupFile") String backupFile) {
        try {
            restoreService.restoreBackup(backupFile);
            return "redirect:/backup/success"; // Redirect to a success page
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/backup/failure"; // Redirect to a failure page
        }
    }
}
