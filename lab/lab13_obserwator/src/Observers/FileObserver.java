package Observers;

import java.io.FileWriter;
import java.io.IOException;

public class FileObserver implements Observer{
    private final String filename;

    public FileObserver(){
        this.filename = "out.txt";
    }

    public FileObserver(String filename){
        this.filename = filename;
    }

    @Override
    public void update(String text) {
        System.out.printf("!! Zaobserwowano zmianę, zapisuję do pliku %s%n", this.filename);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.filename);

            fileWriter.write(text);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
