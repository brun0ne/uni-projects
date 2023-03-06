package MyFormatter;

import FileFormatter.*;

import java.io.*;

public abstract class CustomizableFormatterAbstract implements java.io.Serializable {
    protected FileFormatter fileFormatter;

    public void setFormatter(FileFormatter fileFormatter){
        this.fileFormatter = fileFormatter;
    }

    public void format(File file){
        this.fileFormatter.format(file);
        System.out.printf("Plik został sformatowany używając [%s]%n%n", this.fileFormatter.getClass().getName());
    }

    public FileFormatter getFileFormatter() {
        return this.fileFormatter;
    }

    public void saveState() {
        File file = new File("state.ser");
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            System.out.println("[!] Błąd w otwieraniu pliku stanu");
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null)
                    objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("[!] Błąd w zamykaniu pliku stanu");
                e.printStackTrace();
            }
        }
    }

    public CustomizableFormatterAbstract loadState(){
        File file = new File("state.ser");
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            CustomizableFormatterAbstract obj = (CustomizableFormatterAbstract) objectInputStream.readObject();

            return obj;
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null)
                    objectInputStream.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return this;
    }
}
