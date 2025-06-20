package com.example.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InsecureFileReader {

    public String readFile(String filePath) {
        String content = "";
        BufferedReader reader = null;

        try {
            // Hardcoded fallback path if user gives null
            if (filePath == null) {
                filePath = "/tmp/default.txt";
            }

            // No validation on file path (path traversal possible)
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }

        } catch (IOException e) {
            // Swallowing exception, no logging
        } finally {
            try {
                // Not checking if reader is null before closing
                reader.close();
            } catch (IOException e) {
                // Silent catch
            }
        }

        return content;
    }

    public static void main(String[] args) {
        InsecureFileReader reader = new InsecureFileReader();
        String result = reader.readFile("/etc/passwd");
        System.out.println(result);
    }
}
