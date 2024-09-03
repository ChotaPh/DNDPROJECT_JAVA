import java.io.*;

class AbilityScores{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        //find size of 2 speparate L and R arry
        int n1 = m - l + 1;
        int n2 = r - m;

        //create L and R arry
        int L[] = new int[n1];
        int R[] = new int[n2];

        //put data to L and R array
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        //merge L and R array

        // Initial index of merged L and R array
        int i = 0, j = 0;

        //Initial index of merged array
        int k = 0;
        while (i < n1 && j < n2){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //copy remaining of L data back
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        //coppy remaning of R data back
        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //sort arry to smaller [left] and [right]
    //call merge funct 
    static void sort(int arr[], int l, int r)
    {
        if  (l < r){
            // find middle point
            int m = l + (r - l) / 2;

            //sort 1st and 2nd half
            //from left to middle
            sort(arr, l, m);
            //from middle to right
            sort(arr, m + 1, r);

            //merge and sort
            merge(arr, l, m, r);
        }
    }

    static void print_array(int arr[])
    {
        //lenght of the array
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        print_array(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        print_array(arr);
    }
}