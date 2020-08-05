package org.dimigo.javaFX.project;

import java.io.*;
import java.util.Calendar;

public class DateIO {
    public static Date nowDate = new Date(); // 현재 날짜
    public static Date fileDate = new Date(); // 파일에 저장된, 마지막 접속 날짜

    // 파일에 작성된 날짜를 가져오고 현재 시간을 기록하는 메소드
    public static void loadDate() {
        Calendar calendar = Calendar.getInstance();

        nowDate.setYear(calendar.get(Calendar.YEAR));
        nowDate.setMonth(calendar.get(Calendar.MONTH) + 1);
        nowDate.setDay(calendar.get(Calendar.DAY_OF_MONTH));

        try(BufferedReader br = new BufferedReader(new FileReader("data/etc/Date.txt"))) {
            fileDate.setYear(Integer.parseInt(br.readLine()));
            fileDate.setMonth(Integer.parseInt(br.readLine()));
            fileDate.setDay(Integer.parseInt(br.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/etc/Date.txt"))) {
            bw.write(Integer.toString(nowDate.getYear()));
            bw.newLine();
            bw.write(Integer.toString(nowDate.getMonth()));
            bw.newLine();
            bw.write(Integer.toString(nowDate.getDay()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 마지막으로 접속한 날짜와 현재 날짜를 비교함. (하루마다 단어를 갱신하기 위해서) 오늘 날짜가 더 크면 true, 이외 false
    public static boolean checkDate() {
        // 오늘의 연도가 클때
        if (nowDate.getYear() > fileDate.getYear())
            return true;

        // 연도가 같을 때, 월을 확인.
        else if (nowDate.getYear() == fileDate.getYear()) {

            // 월이 크면
            if (nowDate.getMonth() > fileDate.getMonth())
                return true;

            // 월이 같으면
            else if (nowDate.getMonth() == fileDate.getMonth()) {

                // 날짜를 체크한다. 날짜가 크면
                if (nowDate.getDay() > fileDate.getDay())
                    return true;

                // 그 이외(같거나 작으면)
                else
                    return false;

            }

            // 월이 작으면
            else
                return false;
        }

        // 연도가 작으면
        else
            return false;
    }
}
