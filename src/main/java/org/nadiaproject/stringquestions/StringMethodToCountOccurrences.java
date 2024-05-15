package org.nadiaproject.stringquestions;

import java.util.Scanner;

public class StringMethodToCountOccurrences {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Please give a String : ");
        String str= sc.nextLine();
        Scanner sc1= new Scanner(System.in);
        System.out.print("Please give a char to count occurence: ");
        char ch= sc1.next().charAt(0);/// next() = retrieves the next token as a string .why we use the charAt(0),to accesses the first character of this string.
        System.out.print("Total Number of occurence of '"+ch+"' is: ");
        System.out.println(countOccurence(str, ch));
    }
    /// create a method to count the occurance. This method takes a String and a char as parameters and returns an int.
    //Array Creation: An array arr of characters is created with the same length as the input string.
    //Loop Through String: The for-loop iterates over each character in the string:
    //Store Characters in Array: Each character of the string is stored in the array arr.
    //Check for Match: If the current character matches the character ch, the count is incremented.
    //Return Count: After the loop, the total count of occurrences is returned.
    public static int countOccurence(String str, char ch){

        int count=0;
        // The for-loop iterates over each character in the string
        for(int i=0; i<str.length();i++ ){
            if(str.charAt(i) == ch){
                count++;
            }

        }
        return count;
    }
}
