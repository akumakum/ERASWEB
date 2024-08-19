package com.eras.erasweb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/maintenance/backup")
public class BackupController {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @PostMapping("/create")
    public String createBackup(@RequestParam String filename, @RequestParam String location) throws IOException, InterruptedException {
        Path backupPath = Paths.get(location, filename);
        String command = String.format("pg_dump -h localhost -U %s -F c -b -v -f \"%s\" %s",
                dbUsername, backupPath.toString(), "your_database_name");

        Process process = Runtime.getRuntime().exec(command, null, new File(location));
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            return "Backup created successfully!";
        } else {
            return "Error creating backup. Exit code: " + exitCode;
        }
    }

    @PostMapping("/restore")
    public String restoreBackup(@RequestParam String filename, @RequestParam String location) throws IOException, InterruptedException {
        Path backupPath = Paths.get(location, filename);
        if (!Files.exists(backupPath)) {
            return "Backup file does not exist!";
        }

        String command = String.format("pg_restore -h localhost -U %s -d %s -v \"%s\"",
                dbUsername, "your_database_name", backupPath.toString());

        Process process = Runtime.getRuntime().exec(command, null, new File(location));
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            return "Restore completed successfully!";
        } else {
            return "Error restoring backup. Exit code: " + exitCode;
        }
    }
}
