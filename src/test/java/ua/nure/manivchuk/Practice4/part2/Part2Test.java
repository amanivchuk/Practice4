package ua.nure.manivchuk.Practice4.part2;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lenovo on 11/25/2017.
 */
public class Part2Test {

    Part2 part2 = null;
    String file1 = "src/main/resources/part2In.txt";
    String file2 = "src/main/resources/part2Out.txt";


    @Before
    public void setUp() throws Exception {
        part2 = new Part2(file1, file2);
    }

    @Test
    public void readWriteData() throws Exception {
        part2 = new Part2(file1, file2);
        part2.output();
    }

    @Test
    public void main() throws Exception {
        Part2.main(new String[]{});
    }

}