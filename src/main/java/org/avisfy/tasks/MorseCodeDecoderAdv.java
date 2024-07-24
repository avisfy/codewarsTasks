package org.avisfy.tasks;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeDecoderAdv {
    public static String decodeBits(String bits) {
        //trim 0
        var end = bits.lastIndexOf("1");
        bits = bits.substring(0, end+1);
        if (bits.charAt(0) == '0')
            bits = bits.replaceFirst("0+", "");

        //calc unit
        var minOn = Arrays.stream(bits.split("0")).filter(e -> !e.isEmpty()).mapToInt(String::length).min().getAsInt();
        var minOff = Arrays.stream(bits.split("1")).filter(e -> !e.isEmpty()).mapToInt(String::length).min().orElse(minOn);
        var unit = Math.min(minOn, minOff);

        String regexDot = "1{" + unit + "}";
        String regexDash = "1{" + unit * 3 + "}";
        String regexDDSpace = "0{1,}";
        String regexLetterSpace = "0{" + unit * 3 + "}";
        String regexWordSpace = "0{" + unit * 7 + "}";

        String morseCode = bits
                .replaceAll(regexDash, "-")
                .replaceAll(regexDot, ".")
                .replaceAll(regexWordSpace, "   ")
                .replaceAll(regexLetterSpace, " ")
                .replaceAll(regexDDSpace, "");

        return morseCode;
    }

    public static String decodeMorse(String morseCode) {
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
