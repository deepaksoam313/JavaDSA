package Sorting;

public class SelectionSortAlgo {
    public static void main(String[] args) {

        int[] arr = {64,25,12,22,11};

        selectionSort(arr, arr.length);
    }

    private static void selectionSort(int[] arr, int n) {

        for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            //swaping with min value to current value hold by i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        for(int k=0; k<n; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();

    }
}
