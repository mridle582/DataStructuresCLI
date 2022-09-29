import java.util.Scanner;

public class DataStructureDriver {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        mainLoop();
    }

    private static void printMenu(String option) {
        switch (option) {
            case "Main" -> System.out.print("""
                    --- Main Menu ---

                    A) NodeArrays
                    Q) Quit Program""");
            case "NodeArray" -> System.out.print("""


                    Loading NodeArray Menu...


                    --- NodeArray Menu ---

                    A) Append Node
                    I) Insert Node
                    D) Delete Node
                    P) Print NodeArray
                    R) Reset NodeArray
                    C) Backup NodeArray
                    Q) Return to Main Menu
                    """);
        }
        System.out.print("\n\nEnter Menu Option: ");
    }

    private static void mainLoop() {
        while(true) {
            printMenu("Main");
            switch (INPUT.nextLine().toLowerCase()) {
                case "a" -> nodeArrayLoop();
                case "q" -> {
                    System.out.println("\n\nExiting...\n");
                    return;
                }
                default -> System.out.println("\n\nPlease Review Menu Options.\n\n");
            }
        }
    }

    private static void nodeArrayLoop() {
        NodeArray nArray = new NodeArray(), bakArray;
        Node tmpNode;
        while(true) {
            try {
                printMenu("NodeArray");
                switch (INPUT.nextLine().toLowerCase()) {
                    case "a" -> {
                        System.out.print("\nEnter New Node Data: ");
                        tmpNode = new Node(INPUT.nextLine());
                        nArray.append(tmpNode);
                    }
                    case "p" -> System.out.println(nArray.toString());
                    case "q" -> {
                        System.out.println("\n\nReturning To The Main Menu...\n\n");
                        return;
                    }
                    default -> System.out.println("\n\nPlease Review Menu Options.\n\n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
