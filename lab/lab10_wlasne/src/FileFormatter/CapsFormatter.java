package FileFormatter;

import java.io.File;

import java.util.ArrayList;

public class CapsFormatter implements FileFormatter, java.io.Serializable{
    @Override
    public void format(File file) {
        ArrayList<String> lines = FileFormatter.readLinesFromFile(file);

        // format (all CAPS)
        lines.replaceAll(String::toUpperCase);

        FileFormatter.writeLinesToFile(lines, file);
    }
}
