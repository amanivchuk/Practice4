package ua.nure.manivchuk.Practice4.task1;

import ua.nure.manivchuk.Practice4.util.ReadFile;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lenovo on 11/21/2017.
 */
public class Task1 {
    private List<String> stringList;
    private StringBuffer stringBuffer;

    public String showTextFromFile(){
        stringBuffer = new StringBuffer();
        StringBuffer list = ReadFile.readFile("src/main/resources/part1.txt");
//        System.out.println(list);

        Pattern pattern = Pattern.compile("(\\p{Alpha}{3,})", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(list);
        StringBuffer result = new StringBuffer();
        while (matcher.find()){
            list.replace(matcher.start(),matcher.end(),matcher.group().toUpperCase());
        }
//        System.out.println(result.toString());

        return list.toString();
    }
}
