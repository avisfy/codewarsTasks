
import org.avisfy.tasks.MorseCodeDecoderAdv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCodeDecoderAdvTest {

    @Test
    public void testDecodeBits() {
        assertEquals(".... . -.--   .--- ..- -.. .",
                MorseCodeDecoderAdv.decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"));
    }

    @Test
    public void testDecodeBitsI() {
        assertEquals("..",
                MorseCodeDecoderAdv.decodeBits("101"));
    }

    @Test
    public void testDecodeBitsD() {
        assertEquals("--",
                MorseCodeDecoderAdv.decodeBits("1110111"));
    }

    @Test
    public void testDecodeBitsDot() {
        assertEquals(".",
                MorseCodeDecoderAdv.decodeBits("01110"));
    }
}
