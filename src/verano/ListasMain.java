/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package verano;

import java.util.Locale;
import java.util.Objects;

/**
 * Small demo/utility class for recursion exercises.
 *
 * <p>
 * Includes a palindrome check implemented recursively.
 */
public class ListasMain {


    /**
     * Program entry point (demo).
     *
     * @param args command-line arguments (optional)
     */
    public static void main(String[] args) {
        String input = (args.length > 0) ? String.join(" ", args) : 
                "Anita lava la tina";
        System.out.println("Input: " + input);
        System.out.println("Is palindrome (normalized): " + 
                isPalindromeNormalized(input));
    }

    /**
     * Checks if a text is a palindrome after normalization. Normalization
     * removes spaces and punctuation and compares case-insensitively.
     *
     * @param text the input text (non-null)
     * @return true if the normalized text is a palindrome; false otherwise
     * @throws NullPointerException if text is null
     */
    public static boolean isPalindromeNormalized(String text) {
        Objects.requireNonNull(text, "text must not be null");

        String normalized = normalize(text);
        return isPalindrome(normalized, 0, normalized.length() - 1);
    }

    /**
     * Recursive palindrome checker using two pointers.
     *
     * @param text the text to evaluate (non-null)
     * @param left left index (inclusive)
     * @param right right index (inclusive)
     * @return true if palindrome in the given range; false otherwise
     */
    public static boolean isPalindrome(String text, int left, int right) {
        
        Objects.requireNonNull(text, "text must not be null");

        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindrome(text, left + 1, right - 1);
    }

    /**
     * Normalizes a text by:
     * <ul>
     * <li>Lowercasing</li>
     * <li>Keeping only letters and digits</li>
     * </ul>
     *
     * @param text original text
     * @return normalized text
     */
    private static String normalize(String text) {
        String lower = text.toLowerCase(Locale.ROOT);

        StringBuilder sb = new StringBuilder(lower.length());
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
