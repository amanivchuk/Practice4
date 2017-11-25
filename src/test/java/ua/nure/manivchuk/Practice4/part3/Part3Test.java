package ua.nure.manivchuk.Practice4.part3;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 11/25/2017.
 */
public class Part3Test {

    private static final String ENCODING = "CP1251";
    private static final String REG_CHAR = "((?<!\\w)\\w(?!\\w))";
    private static final String REG_STRING = "(\\p{Alpha}{2,})";
    private static final String REG_INT = "(?<=\\s|^)[-+]?\\d+(?=\\s|$)";
    private static final String REG_DOUBLE = "(^|\\s)([-+]?[\\d+]*\\.\\d+)(\\s|$)";

    Part3 part3 = null;

    @Before
    public void constructorTest() {
        part3 = new Part3("src/main/resources/part3.txt");
    }

    @Test
    public void testTestString() {
        part3.printResult();
        part3.setFileName("INCORRECT_FILENAME");
        part3.printResult();
    }


    @Test
    public void testMain() {
        try {
            System.setIn(new ByteArrayInputStream(
                    "char\nString\nint\ndouble\nstop".getBytes(ENCODING)));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Wrong encoding in Part3Test");
        }

        Part3.main(new String[] {});
        System.setIn(System.in);
    }

}