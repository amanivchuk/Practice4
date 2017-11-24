package ua.nure.manivchuk.Practice4.part3;

import ua.nure.manivchuk.Practice4.util.ReadFile;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lenovo on 11/24/2017.
 */
public class Part3 {
    private String fileName;
    private StringBuffer stringBuffer;
    private static final String ENCODING = "CP1251";

    private static final String REG_CHAR = "((?<!\\w)\\w(?!\\w))";
    private static final String REG_STRING = "(\\p{Alpha}{2,})";
    private static final String REG_INT = "(?<=\\s|^)[-+]?\\d+(?=\\s|$)";
    private static final String REG_DOUBLE = "(^|\\s)([-+]?[\\d+]*\\.\\d+)(\\s|$)";

    public Part3(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void printResult() {
        stringBuffer = ReadFile.readFile(fileName);

        Scanner sc = new Scanner(System.in, ENCODING);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            switch (str) {
                case "char": {
                    printRes(regex(stringBuffer, REG_CHAR));
                }
                break;
                case "String": {
                    printRes(regex(stringBuffer, REG_STRING));
                }
                break;
                case "int": {
                    printRes(regex(stringBuffer, REG_INT));
                }
                break;
                case "double": {
                    printRes(regex(stringBuffer, REG_DOUBLE));
                }
                break;
            }
        }
    }

    private String regex(StringBuffer stringBuffer, String regExp) {
        Pattern pattern = Pattern.compile(regExp, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(stringBuffer.toString());
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }
        return result.toString();
    }

    private void printRes(String result) {
        System.out.println("===> " + result);
    }

    public static void main(String[] args) {
        String file = "src/main/resources/part3.txt";
        Part3 part3 = new Part3(file);
        part3.printResult();
    }
}
