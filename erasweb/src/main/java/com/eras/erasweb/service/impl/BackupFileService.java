package com.eras.erasweb.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class BackupFileService {

    private static final String BACKUP_DIRECTORY = "C:\\tmp\\ERAS-DB-Backup"; 

    public List<String> listBackupFiles() {
        File dir = new File(BACKUP_DIRECTORY);
        List<String> backupFiles = new ArrayList<>();

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((d, name) -> name.endsWith(".backup")); 
            if (files != null) {
                for (File file : files) {
                    backupFiles.add(file.getName());
                }
            }
        }
        return backupFiles;
    }
}
