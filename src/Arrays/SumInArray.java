package Arrays;

public class SumInArray {

    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int arr2[] = new int[]{7,8,9, 1,2,3,4,5,6};
        int m = arr2.length;

        System.out.println("The Sum occurs " + pairsInSortedRotated(arr2,n,15) + " times");
    }
    public static int pairsInSortedRotated(int a[], int n, int x){
        int i;
         for(i=0; i<(n-1);i++)
             if(a[i]>a[i+1])
                 break;

         int l = i;
         int u = i+ 1;
         int counter = 0;
         while (l!= u){
             if((a[l]+a[u]) == x) {
                 counter++;
                 l = (l +n-1)%n;
                 u = (u+n+1)%n;
                 if (a[l]< a[u])
                     break;
             }

             else if ((a[l]+a[u]) < x)
                 u = (u+n+1)%n;
             else l = (l +n-1)%n;
         }
         return counter;
    }
}
