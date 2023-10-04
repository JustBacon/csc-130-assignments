import java.util.Scanner;

class assignment2 {

    static int linearSearch(int key, int[] intArray){
        
        int comparisonCounter = 1;
        int sizeOfArray = intArray.length;

        for(int i = 0; i < sizeOfArray; i++){
            if(key == intArray[i]){
                System.out.println("Number of comparison: " + comparisonCounter);
                System.out.println("O(" + comparisonCounter + " sizeOfArray)");
                return i;
            }
            comparisonCounter++;
        }
        return -1;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int[] arrayNum = {
            3, 7, 8, 2, 13,
            5, 10, 26, 4, 6,
            1, 9, 55, 42, 33,
            11, 16, 0, 21, 87
        };

        int key = -1;
        int foundIndexNum = -1;

        System.out.println("Enter a number inside the array: 3, 7, 8, 2, 13, 5, 10, 26, 4, 6, 1, 9, 55, 42, 33, 11, 16, 0, 21, 87:");
        key = input.nextInt();

        foundIndexNum = linearSearch(key, arrayNum);
        if(foundIndexNum != -1){
            System.out.println("Found the key at index: " + foundIndexNum);
        }

    }
}
