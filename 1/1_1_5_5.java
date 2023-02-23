import java.util.Arrays;
import java.util.Scanner;

public class Task1155 {
  
    private static void removeDuo( int a, int b){
        a--;
        b--;
    }
    //Вот эти методы могут быть просто в main скопированы и убраны (я выпендриваюсь)
    private static boolean isPossible(int[] arr){
        return (arr[0] + arr[2] + arr[4] + arr[6]) == (arr[1] + arr[3] + arr[5] + arr[7]);
    }

    private static boolean isEmpty(int[] arr){
        return Arrays.stream(arr).sum() == 0;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] n = new int[8];
        for (int i = 0; i < 8; i++) {
            n[i] = scan.nextInt();
        }
        scan.close();
        //A B C D E F G H
        //1 2 3 4 5 6 7 8
        //A - H - C - F
        //1 - 8 - 3 - 6
        if(!isPossible(n)){
            System.out.println("IMPOSSIBLE");
            return;
        }

        while(!isEmpty(n)){
            if(n[1] > 0){
                if(n[2] > 0){removeDuo(n[1], n[2]);System.out.println("AB-");}
                if(n[4] > 0){removeDuo(n[1], n[4]);System.out.println("AD-");}
                if(n[5] > 0){removeDuo(n[1], n[5]);System.out.println("AE-");}
                if(n[7] > 0){removeDuo(n[1], n[7]);System.out.println("FB+\nFG-\nAB-");}
            }
            if(n[3] > 0){
                if(n[2] > 0){removeDuo(n[3], n[2]);System.out.println("BC-");}
                if(n[4] > 0){removeDuo(n[3], n[4]);System.out.println("CD-");}
                if(n[6] > 0){removeDuo(n[3], n[6]);System.out.println("CF-");}
                if(n[5] > 0){removeDuo(n[3], n[5]);System.out.println("HG+\nEH-\nCG-");}
            }
            if(n[6] > 0) {
                if (n[5] > 0) {removeDuo(n[6], n[5]);System.out.println("EF-");}
                if (n[7] > 0) {removeDuo(n[6], n[7]);System.out.println("FG-");}
                if (n[2] > 0) {removeDuo(n[6], n[7]);System.out.println("BF-");}
                if (n[4] > 0) {removeDuo(n[6], n[4]);System.out.println("HG+\nDH-\nFG-");}
            }
            if(n[8] > 0){
                if (n[5] > 0) {removeDuo(n[8], n[5]);System.out.println("EH-");}
                if (n[7] > 0) {removeDuo(n[8], n[7]);System.out.println("GH-");}
                if (n[4] > 0) {removeDuo(n[8], n[4]);System.out.println("DH-");}
                if (n[2] > 0) {removeDuo(n[8], n[2]);System.out.println("CD+\nBC-\nDH-");}
            }
        }
    }
}
