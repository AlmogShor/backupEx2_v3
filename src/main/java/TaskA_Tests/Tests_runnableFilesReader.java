package TaskA_Tests;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import TaskA.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class Tests_runnableFilesReader {
//    private static String[] fileNames;


    @BeforeAll
    public static void setup() {
        System.out.println("Setup");
        Ex2_1 ex2_1 = new Ex2_1();
        String[] fileNames = ex2_1.createTextFiles(25, 100, 100);
    }

    @Test
    public void test1() {
        System.out.println("Test1");
        runnableFilesReader r = new runnableFilesReader("file1.txt");
        r.run();
        assertEquals(100, r.getNumOfLines());
    }

//    @Test
//    public void test2() {
//        System.out.println("Test2");
//        runnableFilesReader r = new runnableFilesReader("file2.txt");
//        r.run();
//        assertEquals(100, r.getNumOfLines());
//    }

    @Test
    public void test3() {
        System.out.println("Test3");
        runnableFilesReader r = new runnableFilesReader("file3.txt");
        runnableFilesReader r2 = new runnableFilesReader("file4.txt");
        runnableFilesReader r3 = new runnableFilesReader("file5.txt");
        r.run();
        r2.run();
        r3.run();
        assertEquals(100, r.getNumOfLines());
        assertEquals(100, r2.getNumOfLines());
        assertEquals(100, r3.getNumOfLines());
        assertEquals(300, r.getNumOfLines() + r2.getNumOfLines() + r3.getNumOfLines());

    }

    @Test
    public void test4() {
        System.out.println("Test4");
        runnableFilesReader r = new runnableFilesReader("file6.txt");
        runnableFilesReader r2 = new runnableFilesReader("file7.txt");
        runnableFilesReader r3 = new runnableFilesReader("file8.txt");
        r.run();
        r2.run();
        r3.run();
        assertEquals(100, r.getNumOfLines());
        assertEquals(100, r2.getNumOfLines());
        assertEquals(100, r3.getNumOfLines());
        assertEquals(300, r.getNumOfLines() + r2.getNumOfLines() + r3.getNumOfLines());

    }

    @AfterAll
    public static void teardown() {
        System.out.println("Teardown");
        //delete files
        for (int i = 0; i < 25; i++) {
            File file = new File("file" + i + ".txt");
            file.delete();
        }

    }
}
