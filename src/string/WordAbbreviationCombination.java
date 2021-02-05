package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO https://ideone.com/6ZfX1W
public class WordAbbreviationCombination {
    public static void main(String[] args) {
        WordAbbreviationCombination ssc = new WordAbbreviationCombination();
        List<String> result = ssc.generateAbbreviations("word");
        result.forEach(r -> System.out.println(r));
    }

    private List<String> generateAbbreviations(String word) {
        Set<String> list = new HashSet<>();
        String input = word;
        return new ArrayList<>();
    }

    private void generateAbbreviationsRecur(Character word[], Integer currIndex) {
        if (currIndex < word.length) {

        } else {
            System.out.println();
        }
    }
}
