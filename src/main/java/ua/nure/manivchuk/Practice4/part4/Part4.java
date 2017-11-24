package ua.nure.manivchuk.Practice4.part4;

import ua.nure.manivchuk.Practice4.util.ReadFile;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lenovo on 11/24/2017.
 */
public class Part4 implements Iterable<String>{
    private String fileName;
    private StringBuffer strFromFile;

    public Part4(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void output(){

        strFromFile = ReadFile.readFile(fileName);

        for (Iterator<String> it = iterator(); it.hasNext(); ) {
            String str = it.next();
            System.out.println(str);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            Pattern pattern = Pattern.compile("\\p{javaUpperCase}.*?(\\.|\\s)(\\s|$)", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher matcher = pattern.matcher(strFromFile.toString());

            @Override
            public boolean hasNext() {
                return matcher.find();
            }

            @Override
            public String next() {
                return matcher.group();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        String file = "src/main/resources/part4.txt";
        new Part4(file).output();
    }
}
