package TaskA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * @author Yulia and Almog
 * @version 1.0
 * @since 2022-01-01
 */
public class Ex2_1 {
    /**
     *
     * @param n - Natural number that represent the number of the text files in the array that we want to create
     * @param seed - The seed for the random number generator
     * @param bound - The upper bound (exclusive) for the random number generator
     * @return - The array of the text files
     * @catch IOException - If an input or output exception occurred
     */
    public static String[] createTextFiles(int n, int seed, int bound){
        String[] fileNames = new String[n];
        for (int i = 0; i < n; i++) {
            fileNames[i] = "file" + i + ".txt";
            try {
                PrintWriter writer = new PrintWriter(fileNames[i], StandardCharsets.UTF_8);
                Random random = new Random(seed);
                for (int j = 0; j < bound; j++) { // Should it be bound or n? did it with bound because it's the upper bound but not sure
                    writer.println(random.nextInt(bound));
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileNames;
    }

    public static int getNumOfLines(String[] fileNames){
        int numOfLines = 0;
        for (String fileName : fileNames) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                while (reader.readLine() != null) {
                    numOfLines++;
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return numOfLines;
    }
    public static int getNumOfLinesThreads(String[] fileNames){
        int numOfLines = 0;
        for (String fileName : fileNames) {
            try {
                runnableFilesReader runnableFilesRdr = new runnableFilesReader(fileName);
                Thread thread = new Thread(runnableFilesRdr);
                thread.start();
                thread.join();
                numOfLines += runnableFilesRdr.getNumOfLines();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return numOfLines;
    }

    public static int getNumOfLinesThreadPool(String[] fileNames){
        int numOfLines = 0;
        // Create a thread pool with available threads - 4 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() -4);
        List<Future<Integer>> futures = new ArrayList<>();

        // Submit a task for each file to the thread pool
        for (String fileName : fileNames) {
            Callable<Integer> task = () -> {
                int lines = 0;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    while (reader.readLine() != null) {
                        lines++;
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return lines;
            };
            futures.add(threadPool.submit(task));
        }

        // Wait for all tasks to complete and sum the number of lines
        for (Future<Integer> future : futures) {
            try {
                numOfLines += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shut down the thread pool
        threadPool.shutdown();

        return numOfLines;
    }

}
