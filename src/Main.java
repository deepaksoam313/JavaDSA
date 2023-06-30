import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
    {
        int[] arr = new int[]{2,3,4,5,2,3,4,5,5};
        Set<Integer> s = new HashSet<Integer>();
        int count = 0;

        for(int i=0; i<arr.length; i++){
            count =0;
            for(int j=0; j< arr.length; j++){
                if(arr[i] == arr[j]){
                    count ++;
                    if(count > 2)
                        System.out.println(arr[i]);
                        break;
                }


            }
        }
    }
}