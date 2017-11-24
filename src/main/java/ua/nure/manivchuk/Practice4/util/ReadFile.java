package ua.nure.manivchuk.Practice4.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nec on 15.11.17.
 */
public class ReadFile {

    public static StringBuffer readFile(String fileName){
        StringBuffer buffer = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"))) {
            String currentLine;
            while((currentLine = reader.readLine()) != null){
                buffer.append(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
