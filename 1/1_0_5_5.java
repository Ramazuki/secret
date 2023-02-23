import java.util.Scanner;

public class Task1005 {
    
    
    private static void arrayFill(int[] arr, Scanner scan){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int minDiff = Integer.MAX_VALUE;
        int[] numbers = new int[len];
        arrayFill(numbers, scan);
        scan.close();
        int last = (int)Math.pow(2, len) - 1;
        for (int i = 0; i < last; i++) {
            int firstHeapSum = 0;
            int secondHeapSum = 0;
            int dec = i;
            for (int j = 0; j < len; j++) {
                if(dec % 2 == 0){
                    firstHeapSum += numbers[j];
                }
                else {
                    secondHeapSum += numbers[j];
                }
                dec /= 2;
            }
            int minus = Math.abs(firstHeapSum - secondHeapSum);
            if(minDiff > minus) minDiff = minus;
        }
        System.out.println(minDiff);
    }
}
