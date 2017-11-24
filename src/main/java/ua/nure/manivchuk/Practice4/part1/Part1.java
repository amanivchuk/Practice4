package ua.nure.manivchuk.Practice4.part1;

import ua.nure.manivchuk.Practice4.util.ReadFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lenovo on 11/21/2017.
 */
public class Part1 {
//    private String file = "src/main/resources/part1.txt";
    private String fileName;
    private StringBuffer stringBuffer;

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
        stringBuffer = new StringBuffer();
        StringBuffer list = ReadFile.readFile(fileName);
//        System.out.println(list);

        Pattern pattern = Pattern.compile("(\\p{Alpha}{3,})", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(list);
        while (matcher.find()){
            list.replace(matcher.start(),matcher.end(),matcher.group().toUpperCase());
        }
        return list.toString();
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1("src/main/resources/part1.txt");
        System.out.println(part1.convertToUpperCase());
    }
}
