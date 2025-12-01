import java.util.Scanner;

class DisplayMN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter m: ");
        int m = sc.nextInt();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int i = m;

        while (i <= n) {
            System.out.println(i);
            i++;
        }

        sc.close();
    }
}
