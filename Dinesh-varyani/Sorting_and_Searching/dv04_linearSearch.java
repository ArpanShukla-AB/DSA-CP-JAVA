public class dv04_linearSearch {
    public int search (int[] arr, int n , int x ){
        for (int i = 0; i < n ; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,9,2,10,15,20};
        dv04_linearSearch ls = new dv04_linearSearch();
        System.out.println(ls.search(arr, arr.length, 100));
    }
}