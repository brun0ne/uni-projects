package FileFormatter;

import java.io.File;
import java.util.ArrayList;

import java.util.Random;

public class WeirdFormatter implements FileFormatter, java.io.Serializable {
    @Override
    public void format(File file) {
        ArrayList<String> lines = FileFormatter.readLinesFromFile(file);

        // format (CUSTOM)
        lines.replaceAll(WeirdFormatter::toWeirdCase);

        FileFormatter.writeLinesToFile(lines, file);
    }

    private static String toWeirdCase(String s) {
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (char c : s.toCharArray()){
            boolean upperOrLower = random.nextBoolean();

            c = upperOrLower ? Character.toUpperCase(c) : Character.toLowerCase(c);

            result.append(c);
        }

        return result.toString();
    }
}
