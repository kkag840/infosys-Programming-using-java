class Tester {

    public static int[] reverseArray(int numbers[], int startIndex, int endIndex) {
        //Implement your code here and change the return value accordingly
        if (start >= end) {
            return; // Base case: if start index is greater than or equal to end index, stop recursion
        }
        
        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        
        // Recur with updated start and end indices
        reverseArray(arr, start + 1, end - 1);
    }
    
    public static void main(String args[]) {
        int numbers[] = new int[] { 1, 2, 3, 4, 5, 6 };

        int reversedNumbers[] = reverseArray(numbers, 0, numbers.length - 1);
        System.out.println("Reversed array");
        for (int number : reversedNumbers) {
            System.out.println(number);
        }
    }
}
