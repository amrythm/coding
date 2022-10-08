public class Amrit {
    int a;
    static int x = 10;

    Amrit(int x){
        this.a = x;
    }
    public static void main(String args[]){
        System.out.println(Amrit.x);
        Amrit a1 = new Amrit(10);
        System.out.println(a1.updateA());
        System.out.println(a1);

    }

    public static int findMin(){
        return 0;
    }
    public int updateA(){
        this.a = 100;
        return this.a;
    }
}
