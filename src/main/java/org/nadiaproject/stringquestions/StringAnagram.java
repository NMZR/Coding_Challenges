package org.nadiaproject.stringquestions;
import java.util.*;

public class StringAnagram {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Please give First String : ");
        String str1= sc.nextLine();
        Scanner sc1= new Scanner(System.in);
        System.out.print("Please give Second String : ");
        String str2= sc.nextLine();
        if(anagramCheck(str1,str2)){
            System.out.print("String are anagram");
        }else{
            System.out.print("String are not anagram");
        }
    }
    public static boolean anagramCheck(String str1, String str2){ ///This method takes two strings, returns a boolean value
        boolean status = false; // serve as the return type of the method, set to false by default
        if (str1.length() != str2.length()) { ///lengths of the two strings should be equal
            status = false;
        } else {
            //why changing to character, to manipulate and compare individual characters of the strings more easily.
            char[] arr1 = str1.toLowerCase().toCharArray(); // if equal change to lowercase and then change it to charachter array
            char[] arr2 = str2.toLowerCase().toCharArray();
            // why we sort, we ensure that the characters within each string are in a consistent order, regardless of the original order in which they were entered by the user
            //This is impo for determ whether the strings contain the same set of char.
            Arrays.sort(arr1);///sorts both character arrays
            Arrays.sort(arr2);
            status = Arrays.equals(arr1, arr2); ///if the sorted arrays are equal. If they are, it returns true, if not it returns false.
            }
        return status;
        }
}

