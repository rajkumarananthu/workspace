using System;

class sortArray {
    /** here if static is must and should, why? I think the reason is that as Main is
     *  a static method, it doesn't allow a non static method all in it */
    static void bubbleSort(int []a) {
        for (int i = 0; i < a.Length; ++i) {
            for (int j = 0; j < a.Length; ++j) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp; 
                }
            }
        }
    }
    
    static void Main(string []args) {
        int []arr = {40,10,3,67,13,25,1002,204,367,122};
        bubbleSort(arr);
        Console.WriteLine("Sorted Array:");
        for (int i =0; i < arr.Length; ++i) {
            Console.Write(arr[i]);
            Console.Write(" ");
        }
    }
}