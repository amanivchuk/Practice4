package ua.nure.manivchuk.Practice4.part4;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 11/25/2017.
 */
public class Part4Test {

    Part4 part4;
    String file = "src/main/resources/part4.txt";

    @Before
    public void setUp() throws Exception {
        part4 = new Part4(file);
    }

    @Test
    public void output() throws Exception {
        part4.output();
    }

    @Test
    public void main() throws Exception {
        Part4.main(new String[] {});
    }

}