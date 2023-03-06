import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DrawingTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @org.junit.jupiter.api.Test
    void drawPyramid() {
        Drawing.drawPyramid(1, 3);

        String proper = """
                  XXX
                 XXXXX
                XXXXXXX
                """.replaceAll("\n", "\r\n");

        Assertions.assertEquals(proper, outputStreamCaptor.toString());
    }

    @org.junit.jupiter.api.Test
    void drawAFigure() {
        Drawing.drawAFigure(4);

        String proper = """
                   X
                  XXX
                 XXXXX
                XXXXXXX
                  XXX
                 XXXXX
                XXXXXXX
                 XXXXX
                XXXXXXX
                XXXXXXX
                """.replaceAll("\n", "\r\n");

        Assertions.assertEquals(proper, outputStreamCaptor.toString());
    }
}