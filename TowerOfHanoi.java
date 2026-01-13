import java.util.Scanner;

public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        towerOfHanoi(n - 1, source, target, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        towerOfHanoi(n - 1, auxiliary, source, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int disks = sc.nextInt();
        System.out.println("Tower of Hanoi Moves:");
        towerOfHanoi(disks, 'A', 'B', 'C');
        sc.close();
    }
}
