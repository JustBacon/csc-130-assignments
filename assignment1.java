import java.util.Scanner;

class assignment1 {

    static int fib(int n) {

        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Enter positive integer: ");

        n = input.nextInt();

        // input.close();
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34

        for (int i = 0; i < 6; i++) {
            long startTime = System.currentTimeMillis();
            System.out.println(n + "th Fibonacci Number: " + fib(n++));
            long endTime = System.currentTimeMillis();
            long runtime = endTime - startTime;
            System.out.println("Run time: " + runtime + "ms");
        }

    }
}