package org.avisfy.tasks;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeDecoder2 {
    public static String decode(String morseCode) {
        //MorseCode.get()
        morseCode = morseCode.trim();
        return Arrays.stream(morseCode.split("   "))
                .map(w->getWord(w))
                .collect(Collectors.joining(" "));
    }

    private static String getWord(String code) {
        return Arrays.stream(code.split(" "))
                .map(l->MorseCode.get(l))
                .collect(Collectors.joining());
    }
}
