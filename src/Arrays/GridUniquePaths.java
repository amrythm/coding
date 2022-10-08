package Arrays;

public class GridUniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {

        if(m == 0 || n == 0)
            return 1;

        return paths(m-1, n-1);

    }

    public static int paths(int m, int n) {
        if(n<0 || m<0)
            return 0;
        if(n== 0 && m==0)
            return 1;

        int up =  uniquePaths(m-1, n);
        int left =  uniquePaths(m,n-1);

        return up + left;
    }
}
