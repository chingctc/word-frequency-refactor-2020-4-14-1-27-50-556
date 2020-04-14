public class WordInfo {
    private String word;
    private int count;

    public WordInfo(String word, int wordCount) {
        this.word = word;
        this.count = wordCount;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordCount() {
        return this.count;
    }
}
