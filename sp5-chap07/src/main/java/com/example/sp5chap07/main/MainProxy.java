package com.example.sp5chap07.main;

import com.example.sp5chap07.ExeTimeCalculator;
import com.example.sp5chap07.ImpeCalculator;
import com.example.sp5chap07.RecCalculator;

public class MainProxy {
    public static void main(String[] args) {
        ExeTimeCalculator ttCal = new ExeTimeCalculator(new ImpeCalculator());
        System.out.println(ttCal.factorial(20));

        ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(ttCal2.factorial(20));
    }
}
