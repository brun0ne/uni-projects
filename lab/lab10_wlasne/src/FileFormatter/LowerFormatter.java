package FileFormatter;

import java.io.File;

import java.util.ArrayList;

public class LowerFormatter implements FileFormatter, java.io.Serializable{
    @Override
    public void format(File file) {
        ArrayList<String> lines = FileFormatter.readLinesFromFile(file);

        // format (all lower)
        lines.replaceAll(String::toLowerCase);

        FileFormatter.writeLinesToFile(lines, file);
    }
}
