import java.util.Scanner;

// Abstract class
abstract class AbstractClass {
    abstract void displayWorkoutSchedule(); // Abstract method
}

// Base class
class Person {
    protected String name;
    protected int age;

    public Person(String n, int a) {
        name = n;
        age = a;
    }

    void displayInfo() {
        System.out.println("\t\tName: " + name);
        System.out.println("\t\tAge: " + age);
    }
}

// Derived class inheriting from Person class
class Member extends Person {
    protected int memberId;

    public Member(int id, String n, int a) {
        super(n, a);
        memberId = id;
    }

    void displayMemberInfo() {
        System.out.println("\t---------------------------------------");
        System.out.println("\t\t Member Information: ");
        displayInfo();
        System.out.println("\t\tMember ID: " + memberId);
    }
}

// Derived class inheriting from Person class
class Trainer extends Person {
    protected int trainerId;
    protected String specialization;

    public Trainer(int id, String n, String spec, int a) {
        super(n, a);
        trainerId = id;
        specialization = spec;
    }

    void displayTrainerInfo() {
        System.out.println("\t---------------------------------------");
        System.out.println("\t\t Your Trainer Information: ");
        displayInfo();
        System.out.println("\t\tTrainer ID: " + trainerId);
        System.out.println("\t\tSpecialization: " + specialization);
    }
}

// Equipment Child class
class Equipment extends Trainer {
    private String equipName;
    private String maintenance;

    public Equipment(String e, String maint, int id, String n, String spec, int a) {
        super(id, n, spec, a);
        equipName = e;
        maintenance = maint;
    }

    void displayEquipmentInfo() {
        System.out.println("\t---------------------------------------");
        System.out.println("\t\t Your Equipment Information ");
        System.out.println("\t\tEquipment: " + equipName);
        System.out.println("\t\tMaintenance: " + maintenance);
        System.out.println("\t\t|...........................................|");
    }
}

class MonthlyFee {
    final double proteinFee = 500; // Static variable

    MonthlyFee() {
    }

    void overloading() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t Do you want to know Your Monthly Fee? Enter: YES, else: NO ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("YES")) {
            double userFee = 2000;
            System.out.println("\t\t Your Monthly Gym Fee is $ " + userFee);
            System.out.println("\t\t|...........................................|");
        } else {
            System.out.println("\n\tFor Next User Input\n");
        }
    }
}

// GymMember class inherits from the Member class.... (multilevel inheritance)
class GymMember extends Member {
    private String membershipType;

    public GymMember(int id, String n, int a, String type) {
        super(id, n, a);
        membershipType = type;
    }

    void displayMemberInfo() {
        super.displayInfo();
        System.out.println("\t\tMembership Type: " + membershipType);
    }
}

class Workout extends AbstractClass {
    private String description;
    private int duration;

    public Workout(String desc, int dur) {
        description = desc;
        duration = dur;
    }

    void displayWorkoutSchedule() {
        System.out.println("\t---------------------------------------");
        System.out.println("\t\t Your Workout Information ");
        System.out.println("\t\tWorkout Schedule: " + description);
        System.out.println("\t\tDuration: " + duration + " hours");
    }
}

class AdminLogin {
    private String admin;

    int adLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\tEnter the ID code: (Given code = ID)");
        admin = scanner.nextLine();

        if (admin.equals("ID")) {
            int p = getAdPassword();
            if (p == 1) {
                return 1; // Successful login
            }
        } else {
            System.out.println("\t\tLogin failed");
            System.out.println("\t\tTry Again  ");
            return adLogin();
        }
        return 0; // Unsuccessful login
    }

    private int getAdPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\tEnter the password :(Given Password = p123)");
        String pw = scanner.nextLine();

        if (pw.equals("p123")) {
            return 1; // Correct password
        } else {
            System.out.println("\t\tPassword is incorrect");
            System.out.println("\t\tTry Again  ");
            return getAdPassword();
        }
    }
}

public class GymManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminLogin adminLogin = new AdminLogin();
        int i, k;

        do {
            System.out.println("\n\n\n\n\t\t---------------------------------------");
            System.out.println("\t\t|                                      |");
            System.out.println("\t\t| Welcome to our Gym Management System |");
            System.out.println("\t\t----------------------------------------\n");
            System.out.println("\t\t** Select User Profile **\n");
            System.out.println("\t\t1. Gym Admin.");
            System.out.println("\t\t2. Gym Member.");
            System.out.println("\t\t3. Exit Program.\n");
            System.out.print("\t\tChoice: ");
            i = scanner.nextInt();

            if (i == 1) {
                System.out.println("\t\t ------------------------");
                System.out.println("\t\t|                         |");
                System.out.println("\t\t| You're in Admin Profile |");
                System.out.println("\t\t|                         |");
                System.out.println("\t\t -------------------------\n");
                k = adminLogin.adLogin();
                if (k == 1) {
                    fnAdmin();
                } else {
                    System.out.println("\t\tInvalid Input. Try Again.");
                    System.out.println("\t\t You cannot access Admin details!");
                }
            } else if (i == 2) {
                System.out.println("\t\t -------------------------");
                System.out.println("\t\t|                         |");
                System.out.println("\t\t| You're in Member Profile|");
                System.out.println("\t\t|                         |");
                System.out.println("\t\t -------------------------\n");
                k = adminLogin.adLogin();
                if (k == 1) {
                    fnUser();
                } else {
                    System.out.println("\t\tInvalid Input. Try Again.");
                    System.out.println("\t\tYou cannot access Member details!");
                }
            } else if (i != 3) {
                System.out.println("\t\tInvalid Input. Try Again.");
                System.out.println("\t\tYou cannot access Member details!");
            }
        } while (i != 3);
        System.out.println("\n\t\tExiting the Whole Program.");
    }

    // Admin functions
    static void fnAdmin() {
        Scanner scanner = new Scanner(System.in);
        int adminChoice;

        do {
            System.out.println("\n\n\n\n\t\t---------------------------------------");
            System.out.println("\t\t|                                      |");
            System.out.println("\t\t| Welcome !!!  You are Admin of the Gym |");
            System.out.println("\t\t----------------------------------------\n");
            System.out.println("\t\tAdmin peruse the details below :\n");
            System.out.println("\t\t1. Show Gym Members");
            System.out.println("\t\t2. Show Maintenance of Equipments");
            System.out.println("\t\t3. Exit Admin Mode\n");
            System.out.print("\t\tChoice: ");
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    System.out.println("\n\t---------------------------------------");
                    System.out.println("\n\t\tList of Gym Members  : \n");
                    System.out.println("\t\t1. Muhammad Ahmed ");
                    System.out.println("\t\t2. Muhammad Hassan ");
                    System.out.println("\t\t3. Muhammad Inaam ");
                    System.out.println("\t\t4. Asim khan ");
                    System.out.println("\t\t5. Rohail Aziz ");
                    System.out.println("\n\t---------------------------------------\n");
                    break;
                case 2:
                    System.out.println("\n\t---------------------------------------");
                    System.out.println("\n\t\tFollowing Equipments need Replacement : \n");
                    System.out.println("\n\t\t1. Dumbbells");
                    System.out.println("\n\t\t2. Treadmill");
                    System.out.println("\n\t\t3. Barbells");
                    System.out.println("\n\t\t4. Elliptical Machine");
                    System.out.println("\n\t---------------------------------------\n");
                    break;
                case 3:
                    System.out.println("\t\tExiting Admin Mode.");
                    break;
                default:
                    System.out.println("\t\tInvalid Input. Try Again.");
            }
        } while (adminChoice != 3);
    }

    // Member mode
    static void fnUser() {
        Scanner scanner = new Scanner(System.in);
        MonthlyFee f1 = new MonthlyFee();
        int choice;
        final int numWorkouts = 3;
        final int numMembers = 5;
        final int numEquipments = 8;

        do {
            System.out.println("\n\n\n\n\t\t---------------------------------------");
            System.out.println("\t\t|                                      |");
            System.out.println("\t\t| Welcome !!!  You are Our Gym Member  |");
            System.out.println("\t\t----------------------------------------\n");
            System.out.println("\t\tFind your schedule according to your Name below: \n");
            System.out.println("\t\t1. Muhammad Arham ");
            System.out.println("\t\t2. Abdullah ");
            System.out.println("\t\t3. Sohail ");
            System.out.println("\t\t4. Obaid ");
            System.out.println("\t\t5. Umer ");
            System.out.println("\t\t6. Exit from Member Mode\n");
            System.out.print("\t\tChoice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    GymMember[] gymMembers = new GymMember[numMembers];
                    gymMembers[0] = new GymMember(122, "Arham", 33, "Basic");
                    gymMembers[0].displayMemberInfo();
                    Workout[] workouts = new Workout[numWorkouts];
                    workouts[0] = new Workout("Cardio and Aerobic exercises for stamina", 3);
                    workouts[0].displayWorkoutSchedule();
                    Equipment[] equipments = new Equipment[numEquipments];
                    equipments[0] = new Equipment("Treadmill", "Regular maintenance needed", 101, "Muhammad Hassan", "Weightlifting", 30);
                    equipments[0].displayTrainerInfo();
                    equipments[0].displayEquipmentInfo();
                    f1.overloading();
                    break;
                case 2:
                    GymMember[] gymMembers2 = new GymMember[numMembers];
                    gymMembers2[1] = new GymMember(167, "Abdullah", 53, "premium");
                    gymMembers2[1].displayMemberInfo();
                    Workout[] workouts2 = new Workout[numWorkouts];
                    workouts2[1] = new Workout("Strength Training and Build muscle strength", 4);
                    workouts2[1].displayWorkoutSchedule();
                    Equipment[] equipments2 = new Equipment[numEquipments];
                    equipments2[1] = new Equipment("Dumbbells", "Check weights for wear and tear", 102, "Rohail Aziz", "Yoga", 45);
                    equipments2[1].displayTrainerInfo();
                    equipments2[1].displayEquipmentInfo();
                    f1.overloading();
                    break;
                case 3:
                    GymMember[] gymMembers3 = new GymMember[numMembers];
                    gymMembers3[2] = new GymMember(155, "Sohail", 23, "Gold");
                    gymMembers3[2].displayMemberInfo();
                    Workout[] workouts3 = new Workout[numWorkouts];
                    workouts3[0] = new Workout("Cardio and Aerobic exercises for stamina", 3);
                    workouts3[0].displayWorkoutSchedule();
                    Equipment[] equipments3 = new Equipment[numEquipments];
                    equipments3[2] = new Equipment("Pilates Reformer", "Regular maintenance needed", 103, "Asim Khan", "Pilates", 37);
                    equipments3[2].displayTrainerInfo();
                    equipments3[2].displayEquipmentInfo();
                    f1.overloading();
                    break;
                case 4:
                    GymMember[] gymMembers4 = new GymMember[numMembers];
                    gymMembers4[3] = new GymMember(154, "obaid", 43, "premium");
                    gymMembers4[3].displayMemberInfo();
                    Workout[] workouts4 = new Workout[numWorkouts];
                    workouts4[1] = new Workout("Strength Training and Build muscle strength", 4);
                    workouts4[1].displayWorkoutSchedule();
                    Equipment[] equipments4 = new Equipment[numEquipments];
                    equipments4[3] = new Equipment("Treadmill", "Regular maintenance needed", 1, "Muhammad Ahmed", "Weightlifting", 20);
                    equipments4[3].displayTrainerInfo();
                    equipments4[3].displayEquipmentInfo();
                    f1.overloading();
                    break;
                case 5:
                    GymMember[] gymMembers5 = new GymMember[numMembers];
                    gymMembers5[4] = new GymMember(121, "umer", 34, "Basic");
                    gymMembers5[4].displayMemberInfo();
                    Workout[] workouts5 = new Workout[numWorkouts];
                    workouts5[2] = new Workout("Mind-Body Exercises and Strengthen core, improve flexibility and enhance body alignment", 2);
                    workouts5[2].displayWorkoutSchedule();
                    Equipment[] equipments5 = new Equipment[numEquipments];
                    equipments5[4] = new Equipment("Dumbbells", "Check weights for wear and tear", 2, "Muhammad Inam", "Yoga", 19);
                    equipments5[4].displayTrainerInfo();
                    equipments5[4].displayEquipmentInfo();
                    f1.overloading();
                    break;
                case 6:
                    System.out.println("\tExiting the Member Mode.");
                    break;
                default:
                    System.out.println("Invalid Input. You are not our Gym Member.");
            }
        } while (choice != 6);
    }
}
