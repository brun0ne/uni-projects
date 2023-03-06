import java.io.*;

public class Pies implements Serializable {
    private final int wiek;
    private final String imie;

    Pies(){
        this.wiek = 0;
        this.imie = "";
    }

    Pies(int wiek, String imie){
        this.wiek = wiek;
        this.imie = imie;
    }

    Pies load(String filename){
        File file = new File(String.format("%s.obj", filename));
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            Pies obj = (Pies) objectInputStream.readObject();

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

    void save(String filename){
        File file = new File(String.format("%s.obj", filename));
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
}
