import java.util.Scanner;
class prac1{
    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            if (arr[m] == x) // check if target is in middle position
                return m;
 
            if (arr[m] < x) // check if target is in left side of array
                l = m + 1;
 
            else
                r = m - 1; // check if target is in right side of array
        }
 
        return -1;
    }
 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        prac1 ob = new prac1();
        System.out.println("Enter the number of elements in array:");
        int n = sc.nextInt();  // size of array
        int arr[] = new int[n]; //define array of given size
        System.out.println("Enter elements of array in ascending order: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt(); // storing elements in array
        }

        System.out.println("Enter the element to be searched: ");
        int x = sc.nextInt();

        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println(
                "Element is not present in array");
        else
            System.out.println("Element is present at "
                               + "index " + result);

        sc.close();
    }
}

