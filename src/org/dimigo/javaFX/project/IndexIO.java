package org.dimigo.javaFX.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class IndexIO {
    public static int firstIndex;
    public static int secondIndex;
    public static int thirdIndex; // 하루 3개 단어 인덱스 값

    // 사용자의 설정값에 따라 무작위로 하루 3개 단어 인덱스를 뽑음.
    public static void chooseRandom() {
        do {
            switch (UserSetIO.userset[0]) {
                case "무작위 어휘" :
                    firstIndex = new Random().nextInt(WordIO.words.size());
                    break;

                case "고전 어휘" :
                    firstIndex = new Random().nextInt(WordIO.classicalIndex);
                    break;

                case "선택지 어휘" :
                    System.out.println(WordIO.questionIndex);
                    System.out.println(WordIO.classicalIndex);
                    firstIndex = new Random().nextInt(WordIO.questionIndex - WordIO.classicalIndex) + WordIO.classicalIndex;
                    break;

                default :
                    firstIndex = new Random().nextInt(WordIO.words.size());
                    break;
            }

            switch (UserSetIO.userset[1]) {
                case "무작위 어휘" :
                    secondIndex = new Random().nextInt(WordIO.words.size());
                    break;

                case "고전 어휘" :
                    secondIndex = new Random().nextInt(WordIO.classicalIndex);
                    break;

                case "선택지 어휘" :
                    secondIndex = new Random().nextInt(WordIO.questionIndex - WordIO.classicalIndex) + WordIO.classicalIndex;
                    break;

                default :
                    secondIndex = new Random().nextInt(WordIO.words.size());
                    break;
            }

            switch (UserSetIO.userset[2]) {
                case "무작위 어휘" :
                    thirdIndex = new Random().nextInt(WordIO.words.size());
                    break;

                case "고전 어휘" :
                    thirdIndex = new Random().nextInt(WordIO.classicalIndex);
                    break;

                case "선택지 어휘" :
                    thirdIndex = new Random().nextInt(WordIO.questionIndex - WordIO.classicalIndex) + WordIO.classicalIndex;
                    break;

                default :
                    thirdIndex = new Random().nextInt(WordIO.words.size());
                    break;
            }
        } while (firstIndex == secondIndex || secondIndex == thirdIndex || thirdIndex == firstIndex);
        writeIndex();
    }

    // 파일에 저장된 현재 인덱스를 읽어오는 메소드
    public static void readIndex() {
        try(BufferedReader br = new BufferedReader(new FileReader("data/etc/index.txt"))) {
            firstIndex = Integer.parseInt(br.readLine());
            secondIndex = Integer.parseInt(br.readLine());
            thirdIndex = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 인덱스가 변경되었을 때 파일에 인덱스를 덮어쓰는 메소드
    public static void writeIndex() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/etc/index.txt"))) {
            bw.write(Integer.toString(firstIndex));
            bw.newLine();
            bw.write(Integer.toString(secondIndex));
            bw.newLine();
            bw.write(Integer.toString(thirdIndex));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
