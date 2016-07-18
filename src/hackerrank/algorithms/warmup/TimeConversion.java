package hackerrank.algorithms.warmup;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by jeremy on 7/3/16.
 */
public class TimeConversion {

    public static void main(String[] args) {

        String date = new Scanner(System.in).next();


        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa"); //h is 0-12
        LocalTime time = LocalTime.parse(date, customFormatter);
        System.out.println(time.format(DateTimeFormatter.ofPattern("HH:mm:ss"))); //H is 0-23
    }
}
