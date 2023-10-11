// Christian Buco
// Assignment 1
// CSC 130-05
// This program assumes that Fibonacci Sequence start at 1 (Classical definition)
// The other variation is fib(0) = 1 (Combinatorial definition)
// They can still get 0 if they enter 0
// If user enters 0 then the number is 0
// Position 1 is 1 in this program
// Fibonacci sequence: 0, 1, 1, 2, 3, 5, ...

import java.util.Scanner;
// import Scanner to get user input

class assignment1 {

    // function used for recursion
    static int fib(int n) {
        // if statement prevents infinite recursion (exit case)
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        
        // Create instance of scanner to get user input
        Scanner input = new Scanner(System.in);

        int n_position;

        // ask for user input
        System.out.println("Enter positive integer: ");
        
        n_position = input.nextInt();

        // get the fibonacci sequence based on user input.
        // get the next 6 position of the fibonacci number
        for (int i = 0; i < 6; i++) {
            // record time before the method (startTime)
            long startTime = System.currentTimeMillis();
            // execute fibonacci method (recursion)
            System.out.println(n_position + "th Fibonacci Number: " + fib(n_position++));
            // record time after the method (endTime)
            long endTime = System.currentTimeMillis();
            // calculate the runtime of the method and display
            long runtime = endTime - startTime;
            System.out.println("Run time: " + runtime + "ms");
        }

        input.close();
    }
}