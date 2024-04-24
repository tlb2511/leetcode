package 排序算法.快速排序;

public class Solution {
    static void quickSort(int[] arr, int l, int r){
        if(l < r){
            int partition = partition(arr,l,r);
            quickSort(arr,l,partition-1);
            quickSort(arr,partition+1,r);
        }
    }
    static int partition(int[] arr, int l, int r){
        int pos = arr[l];
        int start = l;
        int end = r;
        while(start < end){
            while(start < end && arr[end] >= pos){
                end--;
            }
            arr[start] = arr[end];
            //mySwap(arr,start++,end);
            while(start < end && arr[start] <= pos){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = pos;
        return start;
    }

    public static void mySwap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,1,1,1,2};
        quickSort(arr,0,6);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
