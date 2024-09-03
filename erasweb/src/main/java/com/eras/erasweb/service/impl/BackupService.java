package com.eras.erasweb.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class BackupService {
	
	@Value("${backup.pguser}")
	private String pgUser;

	@Value("${backup.pgdb}")
	private String pgDb;

	@Value("${backup.pgpassword}")
	private String pgPassword;

	@Value("${backup.dir}")
	private String backupDir;

    private volatile String status = "Starting";

    public String getStatus() {
        return status;
    }

    public void startBackup() {
        try {
            // Create backup name
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            
            // Get the current date
            LocalDate currentDate = LocalDate.now();
            
            // Format the date
            String formattedDate = currentDate.format(formatter);
            
            // Create the filename
            String filename = "backup-" + formattedDate + ".backup";
            
        	String completePathandFile=backupDir+"\\"+filename;
            
        	// Assemble the command for pg_dump
            String command = String.format("pg_dump -U %s -d %s -F c -b -v -f \"%s\"",
                    pgUser, pgDb, completePathandFile);

            // Set environment variables
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.environment().put("PGPASSWORD", pgPassword);
        	
            // String command = "cmd.exe /c C:\\tmp\\ERAS-DB-Backup\\backup.bat";
           // ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true); // Redirect error stream to input stream
            Process process = processBuilder.start();

            // Capture and log output and error streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                status = line; // Update status with the latest output
                System.out.println(line); // Log the output
            }

            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                status = "Error: " + errorLine; // Update status with the latest error
                System.err.println(errorLine); // Log the error
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                status = "Backup Completed";
            } else {
                status = "Backup Failed with exit code: " + exitCode;
            }

        } catch (IOException | InterruptedException e) {
            status = "Backup Failed: " + e.getMessage();
            e.printStackTrace(); // Log the exception
        }
    }
}
