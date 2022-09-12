import java.util.Scanner;

public class StudApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int payment = 0;
        int startBalance;

        System.out.println("Enter number of students");
        int numberOfStud = scanner.nextInt();
        Student[] students = new Student[numberOfStud];
        int i = 0;
        while(i < numberOfStud){
            students[i] = new Student();
            System.out.println("Enter student name");
            scanner.nextLine();
            students[i].setName(scanner.nextLine());
            System.out.println("Enter student lastname");
            students[i].setSurname(scanner.nextLine());
            System.out.println("Enter student year of study");
            students[i].setYearOfStudy(scanner.nextInt());
            System.out.println("Enter student balance");
            students[i].setBalance(scanner.nextInt());
            startBalance = students[i].getBalance();
            System.out.println("Student class levels:");
            System.out.println("""
                    1 - Freshmen
                    2 - Sophmore
                    3 - Junior
                    4 - Middle""");
            System.out.println("Enter student class level (number)");
            int studLvl;
            while (true) {
                studLvl = scanner.nextInt();
                if(studLvl < 1 || studLvl > 4) {
                    System.out.println("Such student class not exist");
                } else {
                    break;
                }

            }
            students[i].setIndicator(studLvl * 1000 + i);
            System.out.println(students[i].getName() + " " + students[i].getSurname() + " "
                    + studLvl + " " + students[i].getIndicator());
            if(students[i].getBalance() > 600) {
                System.out.println("Enter the desired subject or q to to quit");
                System.out.println("""
                        1) History
                        2) Mathematics
                        3) Chemistry
                        4) Informatics""");
                scanner.nextLine();
                String desiredSubject = scanner.nextLine();
                while(true) {
                    if(students[i].getBalance() > 600) {
                        if(desiredSubject.equals("History") || desiredSubject.equals("Mathematics")
                                || desiredSubject.equals("Chemistry") || desiredSubject.equals("Informatics")) {
                            students[i].setBalance(students[i].getBalance() - 600); ;
                            payment += 600;
                            desiredSubject = scanner.nextLine();
                        } else {
                            System.out.println("Such an subject does not exist");
                            desiredSubject = scanner.nextLine();
                        }
                    } else {
                        System.out.println("You don't have money on any course"
                                + "\nEnter q to quit");
                        desiredSubject = scanner.nextLine();
                    }
                    if(desiredSubject.equals("q") || desiredSubject.equals("Q")) {
                        break;
                    }
                }
                System.out.println("Your balance: " + startBalance);
                System.out.println("You pay: " + payment);
                System.out.println("Remained on the account: " + students[i].getBalance()
                        + "\nThank you for payment");
                System.out.println();
            }

            i++;
        }
    }
}
