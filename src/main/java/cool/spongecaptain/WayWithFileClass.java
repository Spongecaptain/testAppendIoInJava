package cool.spongecaptain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WayWithFileClass {
    public static final String FILE_PATH = "temp1.txt";
    //run it multiple times
    public static void main(String[] args) throws IOException {
        //create file
        File file = new File(FILE_PATH);
        file.createNewFile();
        //Start Multiple threads
        Runnable task = () -> {
            try {
                usingPath();
                usingPath();
                usingPath();
                usingPath();
                usingPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(task,"thread1").start();//thread1
        new Thread(task,"thread2").start();//thread2
        new Thread(task,"thread3").start();//thread3
    }

    public static void usingPath() throws IOException
    {
        String textToAppend = "Hello World ! "+Thread.currentThread().getName() +" "+System.currentTimeMillis() + "\r\n"; //new line in content
        Path path = Paths.get(FILE_PATH);
        //OpenOption includes StandardOpenOption.APPEND means using append-only mode
        Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND);
    }
}
