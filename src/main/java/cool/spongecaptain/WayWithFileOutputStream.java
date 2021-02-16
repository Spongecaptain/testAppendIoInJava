package cool.spongecaptain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WayWithFileOutputStream {
    public static final String FILE_PATH = "temp4.txt";
    //run it multiple times
    public static void main(String[] args) throws IOException {
        //create file
        File file = new File(FILE_PATH);
        file.createNewFile();
        //Start Multiple threads
        Runnable task = () -> {
            try {
                usingFileOutputStream();
                usingFileOutputStream();
                usingFileOutputStream();
                usingFileOutputStream();
                usingFileOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(task,"thread1").start();//thread1
        new Thread(task,"thread2").start();//thread2
        new Thread(task,"thread3").start();//thread3
    };


    public static void usingFileOutputStream() throws IOException
    {
        String textToAppend = "Hello World ! "+Thread.currentThread().getName() +" "+System.currentTimeMillis() + "\r\n"; //new line in content
        //boolean append is true which means using append-only mode
        FileOutputStream outputStream = new FileOutputStream(FILE_PATH, true);
        byte[] strToBytes = textToAppend.getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }
}

