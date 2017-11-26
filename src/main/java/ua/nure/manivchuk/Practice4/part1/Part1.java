package ua.nure.manivchuk.Practice4.part1;

import ua.nure.manivchuk.Practice4.util.ReadFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lenovo on 11/21/2017.
 */
public class Part1 {
    private String fileName;

    public Part1(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String convertToUpperCase(){

        StringBuffer buffer = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"))) {
            String currentLine;
            while((currentLine = reader.readLine()) != null){
                buffer.append(currentLine);

                Pattern pattern = Pattern.compile("(\\p{Alpha}{4,})", Pattern.UNICODE_CHARACTER_CLASS);
                Matcher matcher = pattern.matcher(buffer.toString());

                while (matcher.find()){
                   buffer.replace(matcher.start(),matcher.end(),matcher.group().toUpperCase());
                }
                buffer.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1("src/main/resources/part1.txt");
        System.out.println(part1.convertToUpperCase());
    }
}
