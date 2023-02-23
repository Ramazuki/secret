import java.util.Scanner;
public class Task1296 {

    private static int antiNegative(int number){
        return Math.max(number, 0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = scan.nextInt();
        int maxSum = 0;
        int curSum = 0;
        for (int i = 0; i < inputs; i++) {
            curSum = antiNegative(curSum + scan.nextInt());
            maxSum = Math.max(maxSum, curSum);
        }
        scan.close();
        System.out.println(maxSum);
    }
}
