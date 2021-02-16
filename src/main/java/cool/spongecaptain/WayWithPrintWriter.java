package cool.spongecaptain;

import java.io.*;

public class WayWithPrintWriter {
    //run it multiple times
    public static final String FILE_PATH = "temp3.txt";

    public static void main(String[] args) throws IOException {
        //create file
        File file = new File(FILE_PATH);
        file.createNewFile();
        //Start Multiple threads
        Runnable task = () -> {
            try {
                usingBufferedWritter();
                usingBufferedWritter();
                usingBufferedWritter();
                usingBufferedWritter();
                usingBufferedWritter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(task,"thread1").start();//thread1
        new Thread(task,"thread2").start();//thread2
        new Thread(task,"thread3").start();//thread3
    }

    public static void usingBufferedWritter() throws IOException {
        String textToAppend = "Hello World ! " + Thread.currentThread().getName() +" "+System.currentTimeMillis();

        //boolean append is true which means using append-only mode
        FileWriter fileWriter = new FileWriter(FILE_PATH, true); //Set true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(textToAppend);  //New line
        printWriter.close();
    }
}
