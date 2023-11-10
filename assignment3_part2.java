// Christian Buco
// Assignment 3
// CSC 130-05

// Part 2
// The program will read the file (assignment3_part2_test.txt), which consist of number of people, parent, children
// User will enter an X and Y. Figure out if Y is descendant of X.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class assignment3_part2 {

    // Hashmap to store key value data of parent(String) and children(Array)
    private static Map<String, String[]> genealogyData = new HashMap<>();

    // Read file and put the data into the HashMap
    public static void readGenealogy(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split("\\s+");
                // grabs the parent
                String name = line[0];
                int numChildren = Integer.parseInt(line[1]);
                String[] children = new String[numChildren];
                int childIndex = 0;
                // grabs the children
                for(int j = 2; j < line.length; j++){
                    children[childIndex++] = line[j];
                }
                // put into the HashMap
                genealogyData.put(name, children);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // checks if Y is a descendant of X
    public static boolean isYDescendantX (String x, String y){
        for(String s : genealogyData.get(x)){
            if(s.trim().equals(y)){
                return true;
            }
        }
        return false;
    }

    // List names of descendant
    public static void listNamesOfDescendant(String x){
        System.out.println("Descendants of " + x);
        System.out.print("List: ");
        for(String s : genealogyData.get(x)){
            System.out.print(s + " ");
        }
        System.out.print("\n");
    }
    // The main (The driver)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "assignment3_part2_test.java";
        readGenealogy(filePath);

        System.out.print("Enter the name of the ancestor (X): ");
        String X = scanner.nextLine();
        System.out.print("Enter the name of the potential descendant (Y): ");
        String Y = scanner.nextLine();

        if(isYDescendantX(X, Y)){
            listNamesOfDescendant(X);
        }else{
            System.out.println("Y is not a descendant of X");
        }
        scanner.close();

    }
}