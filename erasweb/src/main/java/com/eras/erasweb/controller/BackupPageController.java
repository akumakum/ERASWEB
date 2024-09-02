package com.eras.erasweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackupPageController {

    @GetMapping("/maintenance/backup")
    public String showBackupPage() {
        return "BackupDatabase"; // Name of the Thymeleaf template (backup.html)
    }
    @GetMapping ("/maintenance/restore")
    public String showRestoreist() {
    	return "redirect:/maintenance/backup/list";
    }
}
