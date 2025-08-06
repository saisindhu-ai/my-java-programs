import java.util.Scanner;

/**
 * PalindromeChecker - A comprehensive Java program to check palindromes
 * Supports both string and number palindrome checking with various methods
 */
public class PalindromeChecker {
    
    /**
     * Check if a string is a palindrome (case-insensitive, ignores spaces and punctuation)
     * @param str The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeString(String str) {
        if (str == null || str.length() == 0) {
            return true; // Empty string is considered a palindrome
        }
        
        // Clean the string: remove non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Check if a string is a palindrome using StringBuilder reverse method
     * @param str The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeStringReverse(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        
        // Clean the string
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Create reversed string
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        return cleaned.equals(reversed);
    }
    
    /**
     * Check if a number is a palindrome
     * @param num The number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public static boolean isPalindromeNumber(int num) {
        // Handle negative numbers
        if (num < 0) {
            return false;
        }
        
        int original = num;
        int reversed = 0;
        
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        
        return original == reversed;
    }
    
    /**
     * Check if a number is a palindrome using string conversion
     * @param num The number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public static boolean isPalindromeNumberString(int num) {
        if (num < 0) {
            return false;
        }
        
        String numStr = String.valueOf(num);
        return isPalindromeString(numStr);
    }
    
    /**
     * Generate palindromes up to a given limit
     * @param limit The upper limit to check for palindromes
     */
    public static void findPalindromes(int limit) {
        System.out.println("Palindromic numbers up to " + limit + ":");
        for (int i = 1; i <= limit; i++) {
            if (isPalindromeNumber(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    /**
     * Interactive method to test palindromes with user input
     */
    public static void interactiveTest() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Palindrome Checker ===");
            System.out.println("1. Check string palindrome");
            System.out.println("2. Check number palindrome");
            System.out.println("3. Find palindromic numbers up to limit");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String inputString = scanner.nextLine();
                    boolean isStringPalindrome = isPalindromeString(inputString);
                    System.out.println("\"" + inputString + "\" is " + 
                                     (isStringPalindrome ? "" : "not ") + "a palindrome");
                    break;
                    
                case 2:
                    System.out.print("Enter a number: ");
                    int inputNumber = scanner.nextInt();
                    boolean isNumberPalindrome = isPalindromeNumber(inputNumber);
                    System.out.println(inputNumber + " is " + 
                                     (isNumberPalindrome ? "" : "not ") + "a palindrome");
                    break;
                    
                case 3:
                    System.out.print("Enter upper limit: ");
                    int limit = scanner.nextInt();
                    findPalindromes(limit);
                    break;
                    
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    /**
     * Main method - demonstrates various palindrome checking functionality
     */
    public static void main(String[] args) {
        System.out.println("=== Java Palindrome Checker ===\n");
        
        // Test string palindromes
        String[] testStrings = {
            "racecar",
            "A man a plan a canal Panama",
            "race a car",
            "hello",
            "Madam",
            "Was it a car or a cat I saw?",
            ""
        };
        
        System.out.println("String Palindrome Tests:");
        System.out.println("------------------------");
        for (String test : testStrings) {
            boolean result1 = isPalindromeString(test);
            boolean result2 = isPalindromeStringReverse(test);
            System.out.printf("%-30s -> %s (method1: %s, method2: %s)%n", 
                            "\"" + test + "\"", 
                            result1 ? "Palindrome" : "Not Palindrome",
                            result1, result2);
        }
        
        // Test number palindromes
        int[] testNumbers = {121, 12321, 123, -121, 0, 1, 1001, 12345};
        
        System.out.println("\nNumber Palindrome Tests:");
        System.out.println("------------------------");
        for (int test : testNumbers) {
            boolean result1 = isPalindromeNumber(test);
            boolean result2 = isPalindromeNumberString(test);
            System.out.printf("%-10d -> %s (method1: %s, method2: %s)%n", 
                            test, 
                            result1 ? "Palindrome" : "Not Palindrome",
                            result1, result2);
        }
        
        // Find palindromes up to 1000
        System.out.println();
        findPalindromes(100);
        
        // Start interactive mode
        System.out.println("\nStarting interactive mode...");
        interactiveTest();
    }
}