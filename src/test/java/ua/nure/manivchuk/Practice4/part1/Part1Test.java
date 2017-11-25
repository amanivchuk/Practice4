package ua.nure.manivchuk.Practice4.part1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 11/25/2017.
 */
public class Part1Test {

    Part1 part1 = null;


    @Before
    public void ConstructorInit(){
        part1 = new Part1("src/main/resources/part1.txt");
    }

    @Test
    public void convertToUpperCase() throws Exception {
        part1.convertToUpperCase();
        part1.setFileName("testTest.txt");
        part1.convertToUpperCase();
    }

    @Test
    public void testMain(){
        Part1.main(new String[]{});
    }

}