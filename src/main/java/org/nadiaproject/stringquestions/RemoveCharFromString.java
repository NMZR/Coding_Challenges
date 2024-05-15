package org.nadiaproject.stringquestions;

import java.util.Scanner;

public class RemoveCharFromString {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Scanner sc= new Scanner(System.in);
        System.out.print("Please give a String : ");
        String str= sc.nextLine();
        Scanner sc1= new Scanner(System.in);
        System.out.print("Please give a Char : ");
        String ch= sc1.nextLine();
        System.out.println(charToRemove(str, ch));
    }
    public static String charToRemove(String str, String ch){
        return str.replace(ch," ");
    }
}