import java.util.*;

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";
    public static final String NEWLINE_DELIMITER = "\n";
    public static final String CALCULATE_ERROR = "Calculate Error";
    public static final String SPACE_DELIMITER = " ";

    public String getResult(String inputStr) {
        try {
            //split the input string with 1 to n pieces of spaces
            String[] arr = inputStr.split(SPACE_PATTERN);

            List<WordInfo> wordInfoList = new ArrayList<>();
            for (String s : arr) {
                WordInfo wordInfo = new WordInfo(s, 1);
                wordInfoList.add(wordInfo);
            }

            //get the map for the next step of sizing the same word
            Map<String, List<WordInfo>> map = getListMap(wordInfoList);

            List<WordInfo> list = new ArrayList<>();
            for (Map.Entry<String, List<WordInfo>> entry : map.entrySet()) {
                WordInfo wordInfo = new WordInfo(entry.getKey(), entry.getValue().size());
                list.add(wordInfo);
            }
            wordInfoList = list;

            wordInfoList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            StringJoiner joiner = new StringJoiner(NEWLINE_DELIMITER);
            for (WordInfo w : wordInfoList) {
                String s = w.getValue() + SPACE_DELIMITER + w.getWordCount();
                joiner.add(s);
            }
            return joiner.toString();
        } catch (Exception e) {
            return CALCULATE_ERROR;
        }
    }

    private Map<String, List<WordInfo>> getListMap(List<WordInfo> wordInfoList) {
        Map<String, List<WordInfo>> map = new HashMap<>();
        for (WordInfo wordInfo : wordInfoList) {
            if (!map.containsKey(wordInfo.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(wordInfo);
                map.put(wordInfo.getValue(), arr);
            } else {
                map.get(wordInfo.getValue()).add(wordInfo);
            }
        }
        return map;
    }
}
