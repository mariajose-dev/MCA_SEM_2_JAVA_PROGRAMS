import java.util.Scanner;

public class MaxOfThree {

    // Function to return maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 3 numbers
        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        System.out.print("Enter third number: ");
        int z = sc.nextInt();

        // Use the max() function twice
        int maxOfThree = max(max(x, y), z);

        System.out.println("Maximum of the three numbers is: " + maxOfThree);

        sc.close();
    }
}
