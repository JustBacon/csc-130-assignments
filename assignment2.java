// Christian Buco
// Assignment 2
// CSC 130-05

// Linear search find BigO(n)
// Selection sort find BigO(n)
// Binary search find BigO(n)

import java.util.Scanner;
// import Scanner to get user input

class assignment2 {

    // swap function to swap numbers within an array
    // java has no pointers, so we have to pass the array in function
    public static void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // function to use linear search
    // checks the whole array and compares with the key you are searching for
    static int linearSearch(int key, int intArray[]){
        int comparisonCounter = 0;
        int sizeOfArray = intArray.length;

        // for loop to search through entire array
        for(int i = 0; i < sizeOfArray; i++){
            // if the key is found return the index
            if(key == intArray[i]){
                System.out.println("Number of comparison: " + comparisonCounter);
                System.out.println("O(" + comparisonCounter + ")");
                return i;
            }
            comparisonCounter++;
        }
        // return -1 if key is not found in the array
        return -1;
    }

    // function to use selection sort
    // start at 1st element
    // compare with the whole array find the lowest value and swap
    // go to next element and repeat
    public static void selectionSort(int arr[]){
        int comparisonCounter = 0;
        int n = arr.length;

        for (int i = 0; i < n-1; i++){
            int minNumIndex = i;
            for(int j = i+1; j<n;j++){
                // check which element is the lowest value
                // set the index to the lowest value to swap
                if(arr[j] < arr[minNumIndex])
                    minNumIndex = j;

                comparisonCounter++;
            }
            // swap the 2 elements
            swap(minNumIndex, i, arr);
        }

        System.out.println("O(" + comparisonCounter + ")");
    }

    // function to use binary search
    // start in the middle of the array
    // if the key is less than the middle value discard the right side
    // if the key is greater than the middle value discard the left side
    static int binarySearch(int key, int arr[]){
        int comparisonCounter = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            // if key is found return the index
            if (arr[middle] == key){
                comparisonCounter++;
                System.out.println("Number of comparison: " + comparisonCounter);
                System.out.println("O(" + comparisonCounter + ")");
                return middle;
            }
            
            // if key is greater than the middle of the array discard left side
            if(arr[middle] < key){
                left = middle + 1;
                comparisonCounter++;
            }

            // if key is less than the middle of the array discard the right side
            else{
                right = middle - 1;
                comparisonCounter++;
            }
        }

        // return -1 if key is not found in the array
        return -1;
    }

    // The main (The driver)
    public static void main(String[] args){

        // initialize a scanner
        Scanner input = new Scanner(System.in);

        // array of integers
        int arrayNum[] = {
            3, 7, 8, 2, 13,
            5, 10, 26, 4, 6,
            1, 9, 55, 42, 33,
            11, 16, 0, 21, 87
        };

        int key = -1;
        int foundIndexNum = -1;

        // ask for user input
        System.out.println("Linear Search");
        System.out.println("------------------------------");
        for (int i = 0; i < arrayNum.length;i++)
            System.out.print(arrayNum[i] + " ");
        System.out.println();
        System.out.println("Enter a number to search using linear search: ");
        key = input.nextInt();

        // use linear search function
        // it will return an index or -1
        foundIndexNum = linearSearch(key, arrayNum);
        if(foundIndexNum != -1){
            System.out.println("Found the key at index: " + foundIndexNum);
        }else{
            System.out.println("cant find");
        }
        System.out.println();

        // clear scanner for next input
        input.nextLine();

        System.out.println("Selection Sort");
        System.out.println("------------------------------");
        // sorting the array using selection sort
        selectionSort(arrayNum);

        // shows the array is now sorted
        for(int i = 0; i<arrayNum.length; i++){
            System.out.print(arrayNum[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Binary Search");
        System.out.println("------------------------------");
        for(int i = 0; i<arrayNum.length; i++){
            System.out.print(arrayNum[i] + " ");
        }
        System.out.println();

        // ask for user input
        System.out.println("Enter a number to search using binary search: ");
        key = input.nextInt();

        // use binary search function
        // it will return an index or -1
        foundIndexNum = binarySearch(key, arrayNum);
        if(foundIndexNum != -1){
            System.out.println("Found the key at index: " + foundIndexNum);
        }else{
            System.out.println("cant find");
        }
        System.out.println();

        // close Scanner
        input.close();
    }
}
