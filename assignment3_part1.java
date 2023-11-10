// Christian Buco
// Assignment 3
// CSC 130-05

// Part 1
// The program will check if the file is properly nested of delimiters (), {}, []
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

class assignment3_part1 {

    // function that check if a file is properly nested
    // Assume these delimiters do not appear inside of comments and string literals,
    // and that they do not appear in the program as character literals.
    public static boolean isProperlyNested(String filename) {
        // Uses stack to check if everything is properly nested
        Stack<Character> stack = new Stack<>();
        // because I am modifying the string many times, I am using StringBuilder
        StringBuilder codeBuilder = new StringBuilder();
        boolean errorDetected = false;

        // try catch block in case file is not found
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // store the line inside a string
            // check if at the end of the file
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (errorDetected) {
                        break; // Stop processing if an error is detected
                    }

                    codeBuilder.append(c);

                    // push into stack if its left delimiter
                    if (c == '(' || c == '{' || c == '[') {
                        stack.push(c);
                    } else if (c == ')' || c == '}' || c == ']') {
                        // this if statement checks if theres an extra right delimiter (which is an error)
                        if (stack.isEmpty()) {
                            errorDetected = true;
                            break; // Stop processing if an error is detected
                        }
                        // pop stack if its right delimiter
                        char top = stack.pop();
                        // if statement to check if the delimiter is matching
                        if ((top == '(' && c != ')') ||
                            (top == '{' && c != '}') ||
                            (top == '[' && c != ']')) {
                            errorDetected = true;
                            break; // Stop processing if an error is detected
                        }
                    }
                }
                codeBuilder.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (errorDetected) {
            System.out.println("File has errors. Improper nesting detected.");
        } else {
            System.out.println("File is properly nested. Here's the code:");
            System.out.println(codeBuilder.toString());
        }

        return !errorDetected;
    }

    // The main (The driver)
    public static void main(String[] args) {
        String filename = "assignment3_part1_test.java";

        isProperlyNested(filename);
    }
}
