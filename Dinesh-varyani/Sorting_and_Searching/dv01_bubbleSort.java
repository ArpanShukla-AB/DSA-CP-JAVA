public class dv01_bubbleSort {
   


        public void printArray(int[] arr) {
            int n = arr.length;
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

public void sort(int[] arr){
    int n = arr.length;
    boolean isswapped;
    for(int i = 0; i < n - 1; i++) {
        isswapped = false;
        for(int j = 0; j < n - i - 1; j++) {
            if(arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                isswapped = true;
            }
        }
        if(isswapped==false) {
            break;
        }
    }
    }

public static void main(String[] args) {
        int []arr = new int[] {5, 1, 4, 2, 8};
        dv01_bubbleSort bs = new dv01_bubbleSort();
        bs.sort(arr);
        bs.printArray(arr);

    }
}