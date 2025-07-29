import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your Last Name: ");
        String lastName = input.nextLine();

        System.out.println("Welcome to the Second Year " + firstName + " " + lastName);

        input.close();
    }
}
