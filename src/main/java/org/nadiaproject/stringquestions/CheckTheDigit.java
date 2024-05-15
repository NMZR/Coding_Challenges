package org.nadiaproject.stringquestions;

import java.util.Scanner;
// this question is same as the vowel question, just the if condition is different and we have one if else statment.
///
public class CheckTheDigit {
    public static void main (String[]args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println ("enter a character");
        char ch = sc.next ().charAt (0);
        if(ch>='0' && ch<='9')
        {
            System.out.println("Character is Digit.");
        }
        else
        {
            System.out.println("Character is Not Digit.");
        }

    }
}
