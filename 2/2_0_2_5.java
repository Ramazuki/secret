import java.util.Scanner;
public class Task2025 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test, fighters, teams, teamsSize, teamless, fights;
        test = scan.nextInt();
        for (int i = 0; i < test; i++) {
            fighters = scan.nextInt();
            teams = scan.nextInt();
            teamsSize = fighters / teams;
            teamless = fighters % teams;
            fights = 0;
            for (int j = 0; j < teamless; j++) {
                fighters -= (teamsSize + 1);
                fights += fighters*(teamsSize + 1);
            }
            for (int j = 0; j < (teams - teamless); j++) {
                fighters -= teamsSize;
                fights += fighters * teamsSize;
            }
            System.out.println(fights);
        }
        scan.close();
    }
}
