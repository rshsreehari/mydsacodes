import java.util.Scanner;
// Just a different way to get sum of n natural numbers!

public class a_SumOfNnum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(funAdd(k));
    }
    public static int funAdd(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                sum++;
            }
        }
        return sum;
    }
}
