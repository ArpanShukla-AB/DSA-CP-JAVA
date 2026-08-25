public class multiplyElement {
    static int [] multiplyBy10(int[] arr){
        int size = arr.length;
        int newArray[] = new int[size];

        for (int i = 0 ; i < arr.length ;i++){
            int element = arr[i];
            int newElement = element * 10;
            newArray[i] = newElement;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] newArray = multiplyBy10(arr);
        for (int i = 0 ; i < newArray.length ; i++){
            System.out.print(newArray[i] + " ");
        }
    }
}