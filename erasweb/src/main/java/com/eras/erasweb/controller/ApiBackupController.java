package com.eras.erasweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eras.erasweb.service.impl.BackupService;
import com.eras.erasweb.service.impl.RestoreService;

import org.springframework.http.ResponseEntity;


import java.io.*;

@RestController
@RequestMapping("/api/backup")
public class ApiBackupController {

    @Autowired
    private BackupService backupService;
    @Autowired
    private RestoreService restoreService;

    @GetMapping("/start")
    public ResponseEntity<String> startBackup() {
        try {
            backupService.startBackup();
            return ResponseEntity.ok("Backup started. Status: " + backupService.getStatus());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to start backup: " + e.getMessage());
        }
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok(backupService.getStatus());
    }
    
    
    @GetMapping("/restore/start")
    public ResponseEntity<String> startRestore(@RequestParam("backupFile") String backupFile) {
        try {
            // You can now use the backupFile string in your restore logic
            restoreService.restoreBackup(backupFile);
            return ResponseEntity.ok("Restore started for file: " + backupFile + ". Status: " + restoreService.getStatus());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to start backup for file: " + backupFile + ". Error: " + e.getMessage());
        }
    }
    
    @GetMapping("/restore/status")
    public ResponseEntity<String> getResponseStatus() {
            return ResponseEntity.ok(restoreService.getStatus());
    }
}
