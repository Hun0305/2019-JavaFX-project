package org.dimigo.javaFX.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WordIO {
    public static List<Word> words = new ArrayList<>();

    public static int classicalIndex; // 고전 어휘
    public static int questionIndex; // 선택지 어휘 | 국어 문제에 나오는 '통시적'과 같은 단어들을 정리함.

    public static String temp; // 대체

    // 고전어휘를 가져오는 메소드
    public static void loadClassicalWords() {
//        단어
        try(BufferedReader br = new BufferedReader(new FileReader("data/Word/classical_Word.txt"))) {
            for (classicalIndex = 0; (temp = br.readLine()) != null; classicalIndex++) {
                words.add(new Word());
                words.get(classicalIndex).setClassification("고전 어휘");
                words.get(classicalIndex).setIndex(classicalIndex + 1);
                words.get(classicalIndex).setWord(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 뜻
        try(BufferedReader br = new BufferedReader(new FileReader("data/Meaning/classical_Meaning.txt"))) {
            for (classicalIndex = 0; (temp = br.readLine()) != null; classicalIndex++) {
                words.get(classicalIndex).setMeaning(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 예문
        try(BufferedReader br = new BufferedReader(new FileReader("data/Sentence/classical_Sentence.txt"))) {
            for (classicalIndex = 0; (temp = br.readLine()) != null; classicalIndex++) {
                words.get(classicalIndex).setSentence(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 선택지 어휘를 가져오는 메소드
    public static void loadQuestionWords() {
        try(BufferedReader br = new BufferedReader(new FileReader("data/Word/question_Word.txt"))) {
            for (questionIndex = classicalIndex; (temp = br.readLine()) != null; questionIndex++) {
                words.add(new Word());
                words.get(questionIndex).setClassification("선택지 어휘");
                words.get(questionIndex).setIndex(questionIndex + 1);
                words.get(questionIndex).setWord(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 뜻
        try(BufferedReader br = new BufferedReader(new FileReader("data/Meaning/question_Meaning.txt"))) {
            for (questionIndex = classicalIndex; (temp = br.readLine()) != null; questionIndex++) {
                words.get(questionIndex).setMeaning(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 예문
        try(BufferedReader br = new BufferedReader(new FileReader("data/Sentence/question_Sentence.txt"))) {
            for (questionIndex = classicalIndex; questionIndex < words.size(); questionIndex++) {
                words.get(questionIndex).setSentence("'예문이 없습니다.'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
