package org.nadiaproject.stringquestions;

import java.util.Scanner;

public class ChangetoLowerorUpperCase {
    public static void main(String[] args) {
        System.out.println("Java program to convert lowecase to uppercase");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a String");
        String str = sc.nextLine();
        String UpperCase = str.toUpperCase();
        System.out.println(UpperCase);
//        StringBuffer strBuffer = new StringBuffer(str);
//        for(int i = 0; i < str.length(); i++){
//            if(Character.isLowerCase(str.charAt(i))) {
//                strBuffer.setCharAt(i, Character.toUpperCase(str.charAt(i)));
//            }
//        }
//        System.out.println("After Conversion lowecase to uppercase");
//        System.out.println(strBuffer);

    }
}

