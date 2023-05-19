/* You are given two integer arrays nums1 and nums2 of equal length n and an integer k. You can perform the 
following operation on nums1:
? hoose two indexes i and j and increment nums1[i] by k and decrement nums1[j] by k. In other words, nums1[i] = 
? nums1[i] + k and nums1[j] = nums1[j] - k. nums1 is said to be equal to nums2 if for all indices i such that 0 <= i 
? < n, nums1[i] == nums2[i].
Return the minimum number of operations required to make nums1 equal to nums2. If it is impossible to make them 
equal, return -1.
* Eg 1 : nums1 = [4,3,1,4]        nums2 = [1,3,7,1]      k = 3         Output = 2
* Eg 2 : nums1 = [3,8,5,2]        nums2 = [2,4,1,6]      k = 1         Output = -1   
*/
import java.util.*;
public class EqualArrays
{
      public int MinimumOperations(int nums1[], int nums2[], int k)
      {
            int DP[] = new int[nums1.length];           //*  DP Array -> O(N)
            for(int i = 0; i < nums1.length; i++)     //! Evaluation -> O(N)
            {
                  if((nums1[i] - nums2[i]) % k == 0)
                        DP[i] = (nums1[i] - nums2[i]) / k;
                  else
                        return -1;     // If the difference is not divisible by k, then they cannot be reduced...
            }
            int sumPositive = 0, sum = 0;        //*   Variable -> O(1)
            for(int i = 0; i < DP.length; i++)     //! Evaluation -> O(N)
            {
                  if(DP[i] > 0)    // if both the nums have same sign at given index...
                        sumPositive = sumPositive + DP[i];
                  sum = sum + DP[i];
            }
            if(sum == 0)    // if the sum is 0, then the arrays can be reduced to same...
                  return sumPositive;
            return -1;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter length of the Array : ");
            x = sc.nextInt();
            int arr[] = new int[x];
            for(int i = 0; i < arr.length; i++)
            {
                  System.out.print("Enter number (1st array) : ");
                  arr[i] = sc.nextInt();
            }
            int arr1[] = new int[x];
            for(int i = 0; i < arr1.length; i++)
            {
                  System.out.print("Enter number (2nd array) : ");
                  arr1[i] = sc.nextInt();
            }
            System.out.print("Enter the value of k : ");
            x = sc.nextInt();
            EqualArrays equalarrays = new EqualArrays();
            System.out.println("The Minimum Steps : "+equalarrays.MinimumOperations(arr, arr1, x));
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(N)