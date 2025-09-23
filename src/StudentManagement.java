import java.util.*;

interface DatabaseActions {
    void admit(Student s);
    void changeDetails(int roll, String whoAmI, String subject, int score);
    void kickOut(int roll);
    void showAll();
}

class Person {
    private String whoAmI;

    Person(String whoAmI) {
        this.whoAmI = whoAmI;
    }

    String getWhoAmI() {
        return whoAmI;
    }

    void setWhoAmI(String whoAmI) {
        this.whoAmI = whoAmI;
    }

    void introduce() {
        System.out.println("I am " + whoAmI);
    }
}

class Student extends Person {
    private int roll;
    private String subject;
    private int score;

    Student(int roll, String whoAmI, String subject, int score) {
        super(whoAmI);
        this.roll = roll;
        this.subject = subject;
        this.score = score;
    }

    int getRoll() {
        return roll;
    }

    String getSubject() {
        return subject;
    }

    void setSubject(String subject) {
        this.subject = subject;
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
    }

    @Override
    void introduce() {
        System.out.println("Roll: " + roll + " | Name: " + getWhoAmI() +
                " | Subject: " + subject + " | Score: " + score);
    }

    void introduce(boolean withGrade) {
        introduce();
        if (withGrade) {
            if (score >= 90) System.out.println("Result: Topper (Grade A)");
            else if (score >= 75) System.out.println("Result: Good (Grade B)");
            else if (score >= 50) System.out.println("Result: Average (Grade C)");
            else System.out.println("Result: Needs help (Grade F)");
        }
    }
}

class Teacher extends Person {
    private String teaches;

    Teacher(String whoAmI, String teaches) {
        super(whoAmI);
        this.teaches = teaches;
    }

    @Override
    void introduce() {
        System.out.println("Teacher: " + getWhoAmI() + " | Teaches: " + teaches);
    }
}

class StudentDiary implements DatabaseActions {
    private List<Student> myGang = new ArrayList<>();

    public void admit(Student s) {
        myGang.add(s);
        System.out.println("New student walked in.");
    }

    public void changeDetails(int roll, String whoAmI, String subject, int score) {
        for (Student s : myGang) {
            if (s.getRoll() == roll) {
                s.setWhoAmI(whoAmI);
                s.setSubject(subject);
                s.setScore(score);
                System.out.println("Details updated for roll " + roll);
                return;
            }
        }
        System.out.println("No student found with that roll.");
    }

    public void kickOut(int roll) {
        Iterator<Student> it = myGang.iterator();
        while (it.hasNext()) {
            if (it.next().getRoll() == roll) {
                it.remove();
                System.out.println("Student removed from diary.");
                return;
            }
        }
        System.out.println("That roll does not exist.");
    }

    public void showAll() {
        if (myGang.isEmpty()) {
            System.out.println("Diary is empty. No students yet.");
        } else {
            for (Student s : myGang) {
                s.introduce(true);
                System.out.println("------");
            }
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDiary diary = new StudentDiary();

        while (true) {
            System.out.println("Choose your action:");
            System.out.println("1 Admit  2 ShowAll  3 Change  4 KickOut  5 Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Roll: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Subject: ");
                String subject = sc.nextLine();
                System.out.print("Score: ");
                int score = sc.nextInt();
                diary.admit(new Student(roll, name, subject, score));
            }

            else if (choice == 2) {
                diary.showAll();
            }

            else if (choice == 3) {
                System.out.print("Roll to change: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("New Name: ");
                String name = sc.nextLine();
                System.out.print("New Subject: ");
                String subject = sc.nextLine();
                System.out.print("New Score: ");
                int score = sc.nextInt();
                diary.changeDetails(roll, name, subject, score);
            }

            else if (choice == 4) {
                System.out.print("Roll to kick out: ");
                int roll = sc.nextInt();
                diary.kickOut(roll);
            }

            else if (choice == 5) {
                System.out.println("Class dismissed.");
                break;
            }
        }
    }
}
