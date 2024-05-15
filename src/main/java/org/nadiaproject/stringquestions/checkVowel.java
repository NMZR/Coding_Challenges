package org.nadiaproject.stringquestions;

import java.util.Scanner;

public class checkVowel {
    public static void main (String[]args)
    {
        System.out.println("This is the vowel question");
        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter a character");
        char ch = sc.next ().charAt (0); ///It first reads a string input using sc.next(),
        // and then extracts the first character of the input string using the charAt(0) method.
        // The character is stored in the variable ch
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) /// check the if the char is with in the range of alphabet
        {
            if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i'
                    || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U')// check if the char is vowel or constant
                System.out.println ("Given Character " + ch + " is a vowel.\n");// if it is vowel print this

            else
                System.out.println ("Given Character " + ch + " is a consonant.\n");// if the char is not vowel print this

        }
        else
            System.out.println ("Given Character " + ch +" is neither a vowel nor a consonant.\n"); // it is neither vowel nor constant
    }
}
