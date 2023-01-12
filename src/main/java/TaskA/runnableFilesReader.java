package TaskA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class runnableFilesReader implements Runnable{
    private String fileName;
    private int numOfLines;

    public runnableFilesReader(String fileName)  {
        this.fileName = fileName;
        this.numOfLines = 0;
    }

    private void countNumOfLines(){
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
    @Override
    public void run() {
        countNumOfLines();
    }
    public int getNumOfLines(){
        return numOfLines;
    }

}
