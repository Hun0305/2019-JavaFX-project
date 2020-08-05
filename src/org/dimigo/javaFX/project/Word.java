package org.dimigo.javaFX.project;

public class Word {
    private int index; // 단어 인덱스
    private String classification; // 분류 : 고전시가 어휘 등등
    private String word; // 단어
    private String meaning; // 뜻
    private String sentence; // 예문

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return index + ". " + word + " | " + classification + " | " + meaning + " | " + sentence;
    }
}
