package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {65,25,12,22,11};

        insertionSort(arr, arr.length);
    }

    private static void insertionSort(int[] arr, int n) {
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > key){
                    arr[j+1] = arr[j];
                    j--;
            }
            arr[j+1] = key;
        }

        //print sorted array
        for(int k=0; k<n; k++)
            System.out.print(arr[k]+ " ");

        System.out.println();
    }
}
