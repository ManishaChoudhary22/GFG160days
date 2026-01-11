package Array;

public class reverseArray {

    // approch 1 
    // function to reverse an array
    static void reverseArray1(int[] arr) {
        
        // Initialize left to the beginning
        // and right to the end
        int left = 0, right = arr.length - 1;

        // Iterate till left is less than right
        while (left < right) {
            
            // Swap the elements at left
            // and right position
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Increment the left pointer
            left++;

            // Decrement the right pointer
            right--;
        }
    }
    // approch 2 using while loop 
    static  void reverseArray2(int[] arr){
        int n=arr.length;
       for(int i=0;i<n/2;i++){
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
       }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2, 6, 5 };

    //    reverseArray1(arr);
       reverseArray2(arr);


        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");
    }
}