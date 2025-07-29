import java.util.Scanner;

public class Marks {
    static final int MAX_STUDENTS = 100;
    static final int SUBJECTS = 3;
    static int[][] marks = new int[MAX_STUDENTS + 1][SUBJECTS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Student Marks Management - Commands:");
        System.out.println("add [studentID]");
        System.out.println("update [studentID] [subjectID]");
        System.out.println("average [studentID]");
        System.out.println("average_s [subjectID]");
        System.out.println("total [studentID]");
        System.out.println("exit");

        while (running) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine().trim();
            String[] cmd = input.split(" ");

            if (cmd[0].equalsIgnoreCase("add") && cmd.length == 2) {
                int id = Integer.parseInt(cmd[1]);
                System.out.print("Math: ");
                marks[id][0] = scanner.nextInt();
                System.out.print("Chemistry: ");
                marks[id][1] = scanner.nextInt();
                System.out.print("Physics: ");
                marks[id][2] = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                System.out.println("Marks added for student " + id);

            } else if (cmd[0].equalsIgnoreCase("update") && cmd.length == 3) {
                int id = Integer.parseInt(cmd[1]);
                int subject = Integer.parseInt(cmd[2]);
                if (subject < 1 || subject > 3) {
                    System.out.println("SubjectID must be 1(Math), 2(Chemistry), or 3(Physics).");
                    continue;
                }
                System.out.print("Enter new mark: ");
                marks[id][subject - 1] = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Mark updated for student " + id);

            } else if (cmd[0].equalsIgnoreCase("average") && cmd.length == 2) {
                int id = Integer.parseInt(cmd[1]);
                int total = marks[id][0] + marks[id][1] + marks[id][2];
                System.out.printf("Average marks for student %d: %.2f\n", id, total / 3.0);

            } else if (cmd[0].equalsIgnoreCase("average_s") && cmd.length == 2) {
                int subject = Integer.parseInt(cmd[1]);
                if (subject < 1 || subject > 3) {
                    System.out.println("Invalid subject ID.");
                    continue;
                }
                int sum = 0, count = 0;
                for (int i = 1; i <= MAX_STUDENTS; i++) {
                    if (marks[i][0] + marks[i][1] + marks[i][2] > 0) {
                        sum += marks[i][subject - 1];
                        count++;
                    }
                }
                if (count == 0) System.out.println("No marks entered yet.");
                else System.out.printf("Average for subject %d: %.2f\n", subject, sum / (double) count);

            } else if (cmd[0].equalsIgnoreCase("total") && cmd.length == 2) {
                int id = Integer.parseInt(cmd[1]);
                int total = marks[id][0] + marks[id][1] + marks[id][2];
                System.out.println("Total marks for student " + id + ": " + total);

            } else if (cmd[0].equalsIgnoreCase("exit")) {
                running = false;
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}
