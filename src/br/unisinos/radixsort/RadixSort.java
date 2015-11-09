package br.unisinos.radixsort;

/**
 ** Implementation of a Radix Sort algorithm.
 */
 
import java.util.Scanner;
import java.util.Random;
 
/** Class RadixSort **/
public class RadixSort 
{
    /** Radix Sort function **/
    public static void sort( int[] a)
    {
    	
    	/**
    	 * @param i = counter
    	 * @param m = biggest number in the array
    	 * @param exp = number of digits on the biggest array number.
    	 * @param n = number of records in the array.
    	 * @param b = index array. 
    	 */
        
    	int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[a.length];
        
        /** Identify biggest number in the array **/
        for (i = 1; i < n; i++) {
        	if (a[i] > m) {
        		m = a[i];
        	}
        }
        
        while ((m / exp) > 0)
        {
        	/** @param bucket = buckets used to sort the records **/
            int[] bucket = new int[10];
            
            /** Identify number of elements in each bucket **/
            for (i = 0; i < n; i++) {
            	bucket[a[i] / exp % 10]++;
            }
            
            /** Create index for the calculation **/
            for (i = 1; i < 10; i++) {
            	bucket[i] += bucket[i - 1];
            }
            
            /** Insert array values into its respective bucket **/
            for (i = n - 1; i >= 0; i--) {
            	b[--bucket[a[i] / exp % 10]] = a[i];
            }
            
            /** Order original array based on buckets order **/
            for (i = 0; i < n; i++) {
                a[i] = b[i];	
            }
            
            exp *= 10;        
        }
    }
    
    /** Main method **/
    public static void main(String[] args) 
    {
    	long startTime = System.currentTimeMillis();
    	
    	System.out.println("Radix Sort Test\n");
    	
        Random r = new Random();
        int n, i;

        int[] arr = new int[2000000];
        n = arr.length;
        for (i = 0; i < n; i++) {
          arr[i] = r.nextInt(99-0) + 0;
        }
        
        /** Call method sort **/
        sort(arr);
        
        /** Print sorted Array **/
        System.out.println("\nElements after sorting ");        
        for (i = 0; i < n; i++) {
        	System.out.print(arr[i]+" ");
        }
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("totalTime " + (endTime - startTime)/1000);                     
    }    
}