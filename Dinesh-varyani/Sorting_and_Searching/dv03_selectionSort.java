public class dv03_selectionSort {
        public void printArray(int[] arr) {
            int n = arr.length;
            for(int i = 0 ; i < n ; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }


        public void sort(int[] arr) {
            int n = arr.length;

            for(int i = 0 ; i < n-1 ; i++) {
                int min = 1;

                for(int j = 1 ; j < n ; j++) {
                    if(arr[j] < arr[min]) {
                        min = j;
                    }
                }
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        public static void main(String[] args) {
            int[] arr = new int[] {5,1,2,9,10};
            dv03_selectionSort ss = new dv03_selectionSort();
            ss.sort(arr);
            ss.printArray(arr);
        }
}
