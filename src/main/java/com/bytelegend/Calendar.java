package com.bytelegend;

import java.util.Scanner;

class Calendar {
    public static void main(String[] args) {
        inputYearAndMonth();
    }

    public static void inputYearAndMonth() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full year :");
        int year = sc.nextInt();
        System.out.println("Enter month as number between 1 and 12 :");
        int month = sc.nextInt();

        printCalendar(year, month);

    }

    public static void printCalendar(int year, int month) {
        //一周七天，定义一个计数器，打印一天加1（包括空白）如果%7等于0的话就需要换行
        int count = 0;
        System.out.println("\t\t" + month +"\t\t"+ year);
        System.out.println("----------------------------");
        System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");
        for (int i = 1; i <= getSpace(year, month); i++) {
            System.out.print("\t");
            count += 1;
        }
        for (int i = 1; i <= getDaysOfMonth(year, month); i++) {
            System.out.print(i + "\t");
            count += 1;
            if (count % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static boolean isLoopYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysOfMonth(int year, int month) {
        int days = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = isLoopYear(year) ? 29 : 28;
                break;
        }
        return days;
    }

//      获得自1900年至当前年、月经过的总天数
//      实现：1900年到year - 1 年的总天数
//      当年至month - 1 的总在数
//      两个天数之和相加

    public static int getTotalDays(int year, int month) {
        int daysofyear = 0;
        int daysofmonth = 0;
        for (int i = 1900; i < year; i++) {

            daysofyear += isLoopYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {

            daysofmonth += getDaysOfMonth(year, i);
        }
        return daysofyear + daysofmonth;
    }

    public static int getSpace(int year, int month) {
        int allSpace = getTotalDays(year, month) % 7;
        return allSpace;
    }
}