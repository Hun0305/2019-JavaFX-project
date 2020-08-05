package org.dimigo.javaFX.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class UserSetIO {
    public static String[] userset = new String[3]; // 사용자가 설정한 단어 범위

    // 사용자 설정값을 불러옴
    public static void readUserSet() {
        try(BufferedReader br = new BufferedReader(new FileReader("data/etc/userset.txt"))) {
            for (int i = 0; i < 3; i++)
                userset[i] = br.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 사용자 설정값을 덮어 씀
    public static void writeUserSet(String[] temp) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/etc/userset.txt"))) {
            bw.write(temp[0]);
            bw.newLine();
            bw.write(temp[1]);
            bw.newLine();
            bw.write(temp[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
