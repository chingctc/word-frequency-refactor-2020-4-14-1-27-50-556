import java.util.*;

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";
    public static final String NEWLINE_DELIMITER = "\n";
    public static final String SPACE_DELIMITER = " ";

    public String getResult(String sentence) throws CalculationErrorException {
        List<WordInfo> wordInfoList = calculateWordFrequency(sentence);
        StringJoiner joiner = getWordFrequencyResult(wordInfoList);
        if(joiner == null){
            throw new CalculationErrorException();
        }
        return joiner.toString();
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<WordInfo> wordInfoList = new ArrayList<>();
        for (String word : new HashSet<>(words)) {
            int count = Collections.frequency(words, word);
            wordInfoList.add(new WordInfo(word, count));
        }
        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
        return wordInfoList;
    }

    private StringJoiner getWordFrequencyResult(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner(NEWLINE_DELIMITER);
        for (WordInfo word : wordInfoList) {
            String wordWithCount = word.getWord() + SPACE_DELIMITER + word.getWordCount();
            joiner.add(wordWithCount);
        }
        return joiner;
    }
}
