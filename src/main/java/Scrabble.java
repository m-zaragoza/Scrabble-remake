import java.util.HashMap;

public class Scrabble {
private String word;
private int total;
private boolean doubleWord;
private boolean tripleWord;
private Character[] doubleLetter;
private Character[] tripleLetter;
private static HashMap<Character, Integer> scoring = new HashMap<>();

public Scrabble(String word) {
    this.word = word;
};

public Scrabble(String word, Character[] doubleLetter, Character[] tripleLetter, boolean doubleWord, boolean tripleWord) {
    this.word = word;
    this.doubleLetter = doubleLetter;
    this.tripleLetter = tripleLetter;
    this.doubleWord = doubleWord;
    this.tripleWord = tripleWord;
};
    public int score() {
        if (word == null) {
            return total = 0;
        } else {
            String wordToScore = this.word.toUpperCase();
            for(int i = 0; i < wordToScore.length(); i++) {
                total += scoring.get(wordToScore.charAt(i));
            }
            wordMultiplier(total);
            letterMultiplier(total, this.doubleLetter, this.tripleLetter);
            return total;
        }
    }

    private int wordMultiplier (int score) {
        if (doubleWord == true) {
           total = score * 2;
        } else if (tripleWord == true) {
            total = score * 3;
        }
        return total;
    }

    private int letterMultiplier (int score, Character[] doubleChar, Character[] tripleChar) {
        if (doubleChar != null) {
            for (char a : doubleChar) {
                score += scoring.get(a);
            }
        } if (tripleChar != null) {
            for (char a : tripleChar) {
                score += scoring.get(a) * 2;
            }
        }
        return total = score;
    }

    static {
        scoring.put('A', 1);
        scoring.put('E', 1);
        scoring.put('I', 1);
        scoring.put('O', 1);
        scoring.put('U', 1);
        scoring.put('L', 1);
        scoring.put('N', 1);
        scoring.put('R', 1);
        scoring.put('S', 1);
        scoring.put('T', 1);
        scoring.put('D', 2);
        scoring.put('G', 2);
        scoring.put('B', 3);
        scoring.put('C', 3);
        scoring.put('M', 3);
        scoring.put('P', 3);
        scoring.put('F', 4);
        scoring.put('H', 4);
        scoring.put('V', 4);
        scoring.put('W', 4);
        scoring.put('Y', 4);
        scoring.put('K', 5);
        scoring.put('J', 8);
        scoring.put('X', 8);
        scoring.put('Q', 10);
        scoring.put('Z', 10);
    }
}
