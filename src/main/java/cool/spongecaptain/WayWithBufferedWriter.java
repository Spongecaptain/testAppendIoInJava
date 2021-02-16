package cool.spongecaptain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WayWithBufferedWriter {
    //run it multiple times
    public static final String FILE_PATH = "temp2.txt";

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

    public static void usingBufferedWritter() throws IOException
    {
        String textToAppend = "Hello World ! "+Thread.currentThread().getName()+ " "+ System.currentTimeMillis() + "\r\n";

        //boolean append is true which means using append-only write
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));

        writer.write(textToAppend);
        writer.close();
    }
}
