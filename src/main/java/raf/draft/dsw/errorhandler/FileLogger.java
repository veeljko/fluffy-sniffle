package raf.draft.dsw.errorhandler;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger{
    @Override
    public void log(String message) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Korisnik\\IdeaProjects\\DraftRoom\\src\\main\\resources\\log.txt"); // file will be created if it doesn't exist
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void update(String message) {
        log(message);
    }
}
