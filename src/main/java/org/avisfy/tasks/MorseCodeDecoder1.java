package org.avisfy.tasks;

public class MorseCodeDecoder1 {
    public static String decode(String morseCode) {
        //Remove left and right spaces and add only one right space
        //so we don't need to decode last letter with additional condition
        morseCode = morseCode.trim() + ' ';

        StringBuilder letter = new StringBuilder();
        StringBuilder message = new StringBuilder();
        int spaces = 0;
        var codeLength = morseCode.length();
        for (int i = 0; i < codeLength; i++) {
            char c = morseCode.charAt(i);
            if (c == ' ') {
                if (++spaces == 1) {
                    var decodedLetter = MorseCode.get(letter.toString());
                    message.append(decodedLetter);
                    letter.setLength(0);
                } else if (spaces == 3) {
                    message.append(" ");
                    spaces = 0;
                }
            } else {
                letter.append(c);
                spaces = 0;
            }
        }
        return message.toString();
    }
}
