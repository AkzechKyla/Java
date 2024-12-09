/**
 * Write a program that will input two String values.
 * 
 * If the third (3rd) character of the first (1st) string 
 * was found on the second (2nd) string,
 * output the uppercase letters of the 1st string 
 * replacing all the occurrences of vowels to asterisk (*);
 * 
 * Otherwise (if not found),
 * output the lowercase letters of the 2nd string
 * replacing all the occurences of vowels to @ sign.
 */

import java.util.Scanner;

public class Morcillos {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nInput String 1: ");
        String string1 = scanner.nextLine();

        System.out.print("Input String 2: ");
        String string2 = scanner.nextLine();

        char thirdChar = string1.charAt(2); // Get the 3rd character of the first string

        if (string2.indexOf(thirdChar) != -1) { // Check if the character is found in the second string
            String upperCaseString = string1.toUpperCase();
            String convertedString = replaceVowelsWithSigns(upperCaseString, '*');
            System.out.println("OUTPUT: " + convertedString);
        } else {
            String lowerCaseString = string2.toLowerCase();
            String convertedString = replaceVowelsWithSigns(lowerCaseString, '@');
            System.out.println("OUTPUT: " + convertedString);
        }
    }

    public static String replaceVowelsWithSigns(String input, char sign) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels) {
            input = input.replace(vowel, sign);
        }
        return input;
    }
}
