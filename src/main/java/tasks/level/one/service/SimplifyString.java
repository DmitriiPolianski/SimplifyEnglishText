package tasks.level.one.service;


public class SimplifyString {

    public String simplifyString(String sourceString) {

        StringBuilder result = new StringBuilder(1000);
        StringBuilder currentWord = new StringBuilder();
        boolean wordArticl;

        for (String word : sourceString.split("\\s+")) {
            if (word.equals("a") | word.equals("an") | word.equals("the")) {
                wordArticl = true;
            } else {
                wordArticl = false;
            }
            currentWord.append(word);

            replaceC(currentWord);
            if (currentWord.length() > 1) {
                removeDoubleLetter(currentWord);
            }
            removeEndE(currentWord);

            if (!wordArticl) {
                result.append(currentWord);
                result.append(" ");
            }

            currentWord.setLength(0);

        }

        return result.toString();
    }

    private void replaceC(StringBuilder sourceString) {

        for (int i = 0; i < sourceString.length() - 1; i++) {
            if (sourceString.charAt(i) == 'c' & (sourceString.charAt(i + 1) == 'i' | sourceString.charAt(i + 1) == 'e')) {
                sourceString.setCharAt(i, 's');
                i++;
            } else if (sourceString.charAt(i) == 'c' & sourceString.charAt(i + 1) == 'k') {
                sourceString.replace(i, i + 2, "k");
                i++;
            } else if (sourceString.charAt(i) == 'c') {
                sourceString.setCharAt(i, 's');
            }
        }
        if (sourceString.charAt(sourceString.length() - 1) == 'c') {
            sourceString.setCharAt(sourceString.length() - 1, 's');
        }
    }

    public void removeDoubleLetter(StringBuilder sourceString) {
        int firtstIndex, len;

        do {
            len = sourceString.length();
            firtstIndex = sourceString.indexOf("ee");

            if (firtstIndex >= 0) {
                sourceString.replace(firtstIndex, firtstIndex + 2, "i");
            }
            firtstIndex = sourceString.indexOf("oo");
            if (firtstIndex >= 0) {
                sourceString.replace(firtstIndex, firtstIndex + 1, "u");
            }
            for (int i = 0; i < sourceString.length() - 1; i++)
                if (sourceString.charAt(i) == sourceString.charAt(i + 1) & sourceString.charAt(i) != 'e' & sourceString.charAt(i) != 'o') {
                    sourceString.deleteCharAt(i);
                }

        } while (len != sourceString.length());
    }

    public void removeEndE(StringBuilder sourceString) {

        if (sourceString.charAt(sourceString.length() - 1) == 'e' & sourceString.length() > 1) {
            sourceString.deleteCharAt(sourceString.length() - 1);
        }
    }

}
