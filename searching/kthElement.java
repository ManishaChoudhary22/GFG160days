
package searching;
public class kthElement {
       static int kElement(int[] a, int[] b, int k){
        int n = a.length, m = b.length;
      
        // last element added to the merged 
        // sorted array
        int last = 0;
      	int i = 0, j = 0;

        for (int d = 0; d < k; ++d) {
            if (i < n) {
              
              	// if a[i] > b[j] then increment j
                if (j < m && a[i] > b[j]) {
                    last = b[j];
                    j++;
                } 
              	
              	// otherwise increment i
              	else {
                    last = a[i];
                    i++;
                }
            } 
          	
          	// if reached end of first array then 
          	// increment j
          	else if (j < m) {
                last = b[j];
                j++;
            }
        }
	
      	// return the last (kth) element
        return last;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kElement(a, b, k));
    }
}
