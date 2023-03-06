package MyFormatter;

import FileFormatter.CapsFormatter;
import FileFormatter.FileFormatter;

public class BetterFormatter extends CustomizableFormatterAbstract implements java.io.Serializable {
    public BetterFormatter(){
        this.fileFormatter = new CapsFormatter(); // default
    }

    public BetterFormatter(FileFormatter fileFormatter){
        this.fileFormatter = fileFormatter;
    }

    public void doCashback(){
        System.out.println("Otrzymałeś cashback w wysokości $1!");
        System.out.println();
    }
}
