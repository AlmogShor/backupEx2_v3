package TaskA_Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import TaskA.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class Tests_Ex2_1 {
    private static String[] fileNames;

    @BeforeAll
    public static void setup() {
        System.out.println("Setup");
        Ex2_1 ex2_1 = new Ex2_1();
        fileNames = ex2_1.createTextFiles(45, 100, 100);
    }

    @Test
    public void testCreateTextFiles(){
        Ex2_1 test = new Ex2_1();
        String[] tstfiles = test.createTextFiles(1000, 10, 100);
        //first test
        for (String value : tstfiles) {
            File file = new File(value);
            assertTrue(file.exists());
        }
        //second test
        assertEquals(1000, tstfiles.length);
        //third test
        for (String s : tstfiles) {
            File file = new File(s);
            assertTrue(file.length() > 0);
        }
        //fourth test
        for (String tstfile : tstfiles) {
            File file = new File(tstfile);
            assertTrue(file.length() > 10);
        }
        //delete files
        for (int i = 0; i < 1000; i++) {
            File file = new File(tstfiles[i]);
            file.delete();
        }
        tstfiles=test.createTextFiles(45, 10, 100);
    }

    @Test
    public void testCountNumOfLines(){
        Ex2_1 test = new Ex2_1();
//        long start = System.currentTimeMillis();
        int tstlines = test.getNumOfLines(fileNames);
//        long end = System.currentTimeMillis();
//        long ans = end - start;
//        System.out.println("Time: " + ans);
        //first test
        assertEquals(4500, tstlines);
    }

    @Test
    public void testGetNumOfLinesThreads(){
        Ex2_1 test = new Ex2_1();
        //measure time
//        long start = System.currentTimeMillis();
        int tstlines = test.getNumOfLinesThreads(fileNames);
        //end of measure time
//        long end = System.currentTimeMillis();
//        long ans = end - start;
//        System.out.println("Time: " + ans);
        //first test
        assertEquals(4500, tstlines);
    }

    @Test
    public void testGetNumOfLinesThreads2(){
        Ex2_1 test = new Ex2_1();
        //measure time
//        long start = System.currentTimeMillis();
        int tstlines = test.getNumOfLinesThreads(fileNames);
        //end of measure time
//        long end = System.currentTimeMillis();
//        long ans = end - start;
//        System.out.println("Time: " + ans);
        //first test
        assertEquals(4500, tstlines);
    }
    @Test
    public void testGetNumOfLinesThreadPool(){
        Ex2_1 test = new Ex2_1();
        //measure time
//        long start = System.currentTimeMillis();
        int tstlines = test.getNumOfLinesThreadPool(fileNames);
        //end of measure time
//        long end = System.currentTimeMillis();
//        long ans = end - start;
//        System.out.println("Time: " + ans);
        //first test
        assertEquals(4500, tstlines);
    }

    @Test
    public void testGetNumOfLinesThreadPool2(){
        Ex2_1 test = new Ex2_1();
        //measure time
//        long start = System.currentTimeMillis();
        int tstlines = test.getNumOfLinesThreadPool(fileNames);
        //end of measure time
//        long end = System.currentTimeMillis();
//        long ans = end - start;
//        System.out.println("Time: " + ans);
        //first test
        assertEquals(4500, tstlines);
    }

    @Test
    public void TestMeasurmentOfTimes(){
        Ex2_1 test = new Ex2_1();
        double start = System.currentTimeMillis();
        System.out.print("Regular counting: ");
        System.out.print(test.getNumOfLines(this.fileNames));
        System.out.print("\nTime took: " + (System.currentTimeMillis() - start) + " ms\n");
        start = System.currentTimeMillis();
        System.out.print("Counting with threads: ");
        System.out.print(test.getNumOfLinesThreads(this.fileNames));
        System.out.print("\nTime took: " + (System.currentTimeMillis() - start) + " ms\n");
        start = System.currentTimeMillis();
        System.out.print("Counting with threadsPool: ");
        System.out.print(test.getNumOfLinesThreadPool(this.fileNames));
        System.out.print("\nTime took: " + (System.currentTimeMillis() - start) + " ms\n");
    }



    @AfterAll
    public static void teardown(){
        System.out.println("Teardown");
        for (int i = 0; i < 45; i++) {
            File f = new File("file" + i + ".txt");
            f.delete();
 }
}
}