public class TowerOfHanoi {

    // Counter to keep track of the number of steps
    static int stepCount = 0;

    // Recursive method to solve the Tower of Hanoi puzzle
    public static void solve(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            stepCount++;
            return;
        }
        solve(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        stepCount++;
        solve(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int n = 4; // Number of disks
        solve(n, 'A', 'B', 'C'); // A, B and C are names of rods
        System.out.println("Total number of steps required: " + stepCount);
    }
}
