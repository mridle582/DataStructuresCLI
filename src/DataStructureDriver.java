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
                    W) Wipe All Nodes
                    P) Print NodeArray
                    C) Backup NodeArray
                    R) Restore NodeArray
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
        NodeArray nArray = new NodeArray(), bakArray = null;
        Node tmpNode;
        int index;
        while(true) {
            try {
                printMenu("NodeArray");
                switch (INPUT.nextLine().toLowerCase()) {
                    case "a" -> {
                        System.out.print("\nEnter New Node Data: ");
                        tmpNode = new Node(INPUT.nextLine());
                        nArray.append(tmpNode);
                    }
                    case "i" -> {
                        System.out.print("\nEnter New Node Data: ");
                        tmpNode = new Node(INPUT.nextLine());
                        System.out.print("\nWhich Index?[0, " + nArray.size() + "]: ");
                        index = Integer.parseInt(INPUT.nextLine());
                        nArray.insert(tmpNode, index);
                    }
                    case "d" -> {
                        System.out.print("\nWhich Index?[0, " + (nArray.size()-1) + "]: ");
                        index = Integer.parseInt(INPUT.nextLine());
                        tmpNode = nArray.delete(index);
                        System.out.println("\n\nNode with id: \"" + tmpNode.getNodeID() + "\" was removed");
                    }
                    case "p" -> System.out.println(nArray);
                    case "w" -> {
                        nArray = new NodeArray();
                        System.out.println("\n\nNodeArray was reset.");
                    }
                    case "c" -> {
                        bakArray = (NodeArray) nArray.clone();
                        System.out.println("\n\nBacked up NodeArray");
                    }
                    case "r" -> {
                        if (bakArray == null) throw new NullPointerException("NodeArrayLoop: No Available Backup");
                        nArray = (NodeArray) bakArray.clone();
                        System.out.println("\n\nBackup Restored");
                    }
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
