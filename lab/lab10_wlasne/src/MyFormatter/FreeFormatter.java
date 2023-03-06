package MyFormatter;

import FileFormatter.*;

public class FreeFormatter extends CustomizableFormatterAbstract implements java.io.Serializable {
    public FreeFormatter(){
        this.fileFormatter = new CapsFormatter(); // default
    }

    public FreeFormatter(FileFormatter fileFormatter){
        this.fileFormatter = fileFormatter;
    }
}
