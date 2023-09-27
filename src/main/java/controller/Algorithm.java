/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controller;

/**
 *
 * @author Tran HaF
 */
public class Algorithm {

    public String formatOneSpaceSpecial(String line, String character) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s*\\" + character + "\\s*");
        for (String oneWord : strings) {
            stringBuffer.append(oneWord + " " + character);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim().substring(0, stringBuffer.length() - 3);
    }

    public String formatOneSpace(String line) {
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(line, ".");
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, ";");
        line = formatOneSpaceSpecial(line, "-");
        return line.trim();
    }

    public String formatSpecialCharacters(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);

        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            if (stringBuffer.charAt(i) == ' '
                    && stringBuffer.charAt(i + 1) == '.'
                    || stringBuffer.charAt(i + 1) == ','
                    || stringBuffer.charAt(i + 1) == ';'
                    || stringBuffer.charAt(i + 1) == ':') {
                stringBuffer.deleteCharAt(i);
            }
        }
        return stringBuffer.toString().trim();
    }

    public String afterDotUpperCase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);

        for (int i = 0; i < stringBuffer.length() - 2; i++) {
            if (stringBuffer.charAt(i) == '.') {
                char afterDot = stringBuffer.charAt(i + 2);
                stringBuffer.setCharAt(i + 2, Character.toUpperCase(afterDot));
            }
        }
        return stringBuffer.toString().trim();
    }

    public String noSpaceQuotes(String line) {
        int countQuetes = 0;
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"') {
                if (countQuetes % 2 == 0) {
                    if (stringBuffer.charAt(i + 1) == ' ') {
                        stringBuffer.deleteCharAt(i + 1);
                    }
                    if (Character.isLetter(stringBuffer.charAt(i + 1))) {
                        stringBuffer.insert(i, ' ');
                    }
                    countQuetes++;
                } else {
                    if (stringBuffer.charAt(i - 1) == ' ') {
                        stringBuffer.deleteCharAt(i - 1);
                    }
                    if (Character.isLetter(stringBuffer.charAt(i - 1))) {
                        stringBuffer.insert(i, ' ');
                    }
                    countQuetes++;
                }
            }
        }
        return stringBuffer.toString().trim();
    }

    public String firstUpercase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        boolean found = false;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuffer.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                found = true;
                break;
            }
        }
        if (!found) {
            return line;
        }
        return stringBuffer.toString().trim();
    }

    public String lastAddDot(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }
}
