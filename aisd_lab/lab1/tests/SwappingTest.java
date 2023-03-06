import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwappingTest {

    @Test
    void pairSwapStr_1() {
        String test_string = "Litw0=0jczyzno moja, Ty jestes jak zdr0w13, ile C13=c3n1c, t3n ty1k0 si3 d0wie=_kt0 C13 stracil.";
        String correct = "Litw0=0jczyzno moja, Ty jestes jak zdr0w13, ile c3n1c=C13, t3n ty1k0 si3 _kt0=d0wie C13 stracil.";

        Assertions.assertEquals(Swapping.pairSwapStr(test_string), correct);
    }

    @Test
    void pairSwapStr_2() {
        String test_string = "To się powinno zamienić: _jeden=dwa. A to nie powinno: t_a_k=n_i_e";
        String correct = "To się powinno zamienić: dwa=_jeden. A to nie powinno: t_a_k=n_i_e";

        Assertions.assertEquals(Swapping.pairSwapStr(test_string), correct);
    }
}