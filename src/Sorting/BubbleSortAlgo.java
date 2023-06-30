package Sorting;

public class BubbleSortAlgo {
    public static void main(String[] args) {

        int[] arr = {64,25,12,22,11};

        bubbleSorting(arr, arr.length);
    }

    public static void bubbleSorting(int[] arr, int n){

        for(int i=0; i<n-1; i++){ //no of pass
            for(int j=0; j< n -i -1; j++){

                if(arr[j] > arr[j+1]){
                    //swap them
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        //print the sorted array
        for(int k=0; k<n; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

}
