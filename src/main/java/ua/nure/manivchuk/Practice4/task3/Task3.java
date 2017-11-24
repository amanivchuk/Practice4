package ua.nure.manivchuk.Practice4.task3;

import ua.nure.manivchuk.Practice4.util.ReadFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lenovo on 11/24/2017.
 */
public class Task3 {
    private StringBuffer stringBuffer;

    StringBuffer typeData = new StringBuffer("char, String, int, double").append(System.lineSeparator()).
        append("*************************").append(System.lineSeparator()).append("-> ");

    private static final String REG_CHAR = "((?<!\\w)\\w(?!\\w))";
    private static final String REG_STRING = "(\\p{Alpha}{2,})";
    private static final String REG_INT = "(?<=\\s|^)[-+]?\\d+(?=\\s|$)";
    private static final String REG_DOUBLE = "(^|\\s)([-+]?[\\d+]*\\.\\d+)(\\s|$)";

    public void printResult() {
        stringBuffer = ReadFile.readFile("src/main/resources/part3.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Choose type or enter exit");
            System.out.print(typeData);
            try {
                String userData = bufferedReader.readLine().toLowerCase();
                if(userData.equalsIgnoreCase("exit")){
                    break;
                }
                switch (userData) {
                    case "char": {
                        printRes(regex(stringBuffer,REG_CHAR));
                    } break;
                    case "string" :{
                        printRes(regex(stringBuffer,REG_STRING));
                    } break;
                    case "int" : {
                        printRes(regex(stringBuffer,REG_INT));
                    } break;
                    case "double" : {
                        printRes(regex(stringBuffer,REG_DOUBLE));
                    } break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String regex(StringBuffer stringBuffer, String regExp){
        Pattern pattern = Pattern.compile(regExp, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(stringBuffer.toString());
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }
        return result.toString();
    }

    private void printRes(String result){
        System.out.println("===> " + result);
    }
}
