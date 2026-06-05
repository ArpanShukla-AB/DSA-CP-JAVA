public class average_ofArray {
    static double getAverage(int[] arr){
        double sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];

        }

        double size = arr.length;
        double average = sum / size;
        return average;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,3};
        // double average = getAverage(arr);   
        System.out.println("Average of the array is: " + getAverage(arr));
    }
}

//Time complexity : O(n) where n is the number of elements in the array. This is because we need to iterate through the entire array once to calculate the sum of its elements.
//Space complexity : O(1) because we are using only a constant amount of extra space to store the sum and average variables, regardless of the size of the input array.