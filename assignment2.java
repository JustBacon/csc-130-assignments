// Christian Buco
// Assignment 2
// CSC 130-05

// Linear search find BigO(n)
// Selection sort find BigO(n)
// Binary search find BigO(n)

import java.util.Scanner;

class assignment2 {

    static int linearSearch(int key, int intArray[]){
        
        int comparisonCounter = 0;
        int sizeOfArray = intArray.length;

        for(int i = 0; i < sizeOfArray; i++){
            if(key == intArray[i]){
                System.out.println("Number of comparison: " + comparisonCounter);
                System.out.println("O(" + comparisonCounter + ")");
                return i;
            }
            comparisonCounter++;
        }
        return -1;
    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int arr[]){
        int comparisonCounter = 0;
        int n = arr.length;

        for (int i = 0; i < n-1; i++){
            int minNumIndex = i;
            for(int j = i+1; j<n;j++){
                if(arr[j] < arr[minNumIndex])
                    minNumIndex = j;

                comparisonCounter++;
            }
                swap(minNumIndex, i, arr);
        }

        System.out.println("O(" + comparisonCounter + ")");
    }

    static int binarySearch(int key, int arr[]){
        int comparisonCounter = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - 1) / 2;

            if (arr[middle] == key){
                comparisonCounter++;
                System.out.println("Number of comparison: " + comparisonCounter);
                System.out.println("O(" + comparisonCounter + ")");
                return middle;
            }
            
            if(arr[middle] < key){
                left = middle + 1;
                comparisonCounter++;
            }

            if(arr[middle] > key){
                right = middle - 1;
                comparisonCounter++;
            }
        }

       return -1;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int arrayNum[] = {
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
        System.out.println();

        input.nextLine();
        selectionSort(arrayNum);

        for(int i = 0; i<arrayNum.length; i++){
            System.out.print(arrayNum[i] + " ");
        }
        System.out.println();

        System.out.println("Enter a number inside the array: ");
        key = input.nextInt();

        foundIndexNum = binarySearch(key, arrayNum);
        if(foundIndexNum != -1){
            System.out.println("Found the key at index: " + foundIndexNum);
        }else{
            System.out.println("cant find");
        }
        System.out.println();
    }
}
