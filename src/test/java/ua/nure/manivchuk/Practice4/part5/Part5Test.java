package ua.nure.manivchuk.Practice4.part5;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 11/25/2017.
 */
public class Part5Test {

    Part5 part5;
    private static final String ENCODING = "Cp1251";
    private String s = new String(System.lineSeparator());

    @Before
    public void setUp() throws Exception {
        part5 = new Part5();
    }

    @Test
    public void testOutput() {
        try {
            System.setIn(new ByteArrayInputStream(
                    ("table ru"+s+"table en"+s+"apple ru"+s+"stop").getBytes(ENCODING)));
            part5.output();
            System.setIn(new ByteArrayInputStream("INCORRECT_INPUT".getBytes(ENCODING)));
            part5.output();
            System.setIn(new ByteArrayInputStream(
                    ("INCORRECT_KEY ru"+s+"table en"+s+"apple ru").getBytes(ENCODING)));
            part5.output();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding in test file");
        }
    }

    @Test
    public void main() throws Exception {
        try {
            System.setIn(new ByteArrayInputStream(
                    ("table ru"+s+"table en"+s+"apple ru"+s+"stop").getBytes(ENCODING)));
            Part5.main(new String[] {});
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding in test file");
        }

    }

}