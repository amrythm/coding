package DynamicProgramming;

public class NthFibonacci {

    public static void main(String[] args) {

        System.out.println(nthFibonacci(9));
    }

    public static int nthFibonacci(int N) {

        int[] fibo_series = new int[N+1];

        fibo_series[0] = 0;
        fibo_series[1] = 1;

        for (int i = 2; i <= N ; i++) {
            fibo_series[i] = fibo_series[i-1] + fibo_series[i-2];
        }
        return fibo_series[N];
    }
}
