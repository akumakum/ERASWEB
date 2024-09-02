package com.eras.erasweb.service.impl;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class RestoreService {
	
	private volatile String status = "Starting";

    private static final String BACKUP_DIRECTORY = "C:\\tmp\\ERAS-DB-Backup";
    private static final String USER_NAME= "postgres";
    private static final String DATABASE="ERAS";
    private static final String PASSWORD="###422rjeyO";
	public void restoreBackup(String backupFileName) throws IOException {
        String command = "pg_restore -U " + USER_NAME +"-c -C -e -l -d " + DATABASE  +" "+ BACKUP_DIRECTORY + "/" + backupFileName;

        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command); // For Windows

        //processBuilder.inheritIO();
        processBuilder.environment().put("PGPASSWORD", PASSWORD); 
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
        int exitCode=0;
		try {
			exitCode = process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (exitCode == 0) {
            status = "Restore Completed";
        } else {
            status = "Restore Failed with exit code: " + exitCode;
        }
        
         
    }
	
	public String getStatus() {
        return status;
    }
}
