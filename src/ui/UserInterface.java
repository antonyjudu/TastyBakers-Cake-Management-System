package ui;

import java.util.Scanner;
import service.cakeService;

public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        cakeService service = new cakeService();

        int choice;

        do {

            System.out.println("\n========== TASTYBAKERS ==========");
            System.out.println("1. Add Cake");
            System.out.println("2. View All Cakes");
            System.out.println("3. Update Cake Name");
            System.out.println("4. Update Cake Flavor");
            System.out.println("5. Update Cake Price");
            System.out.println("6. Deactivate Cake");
            System.out.println("7. Exit");
            System.out.println("=================================");

            System.out.print("Enter Your Choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // ADD CAKE
                case 1:
                    System.out.print("Enter Cake Name : ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Cake Flavor : ");
                    String flavor = scanner.nextLine();

                    System.out.print("Enter Cake Price : ");
                    double price = scanner.nextDouble();

                    boolean addResult = service.addCake(name, flavor, price);

                    if (addResult) {
                        System.out.println("Cake Added Successfully");
                    } else {
                        System.out.println("Cake Add Failed");
                    }
                    break;

                // VIEW ALL CAKES
                case 2:
                    System.out.println("\nALL CAKES");
                    service.displayAllCakes();
                    break;

                // UPDATE CAKE NAME
                case 3:
                    System.out.print("Enter Cake ID : ");
                    int updateNameId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Cake Name : ");
                    String newName = scanner.nextLine();

                    boolean updateName = service.updateCakeName(updateNameId, newName);

                    if (updateName) {
                        System.out.println("Cake Name Updated Successfully");
                    } else {
                        System.out.println("Cake Name Update Failed");
                    }
                    break;

                // UPDATE CAKE FLAVOR
                case 4:
                    System.out.print("Enter Cake ID : ");
                    int updateFlavorId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Flavor : ");
                    String newFlavor = scanner.nextLine();

                    boolean updateFlavor = service.updateCakeFlavor(updateFlavorId, newFlavor);

                    if (updateFlavor) {
                        System.out.println("Cake Flavor Updated Successfully");
                    } else {
                        System.out.println("Cake Flavor Update Failed");
                    }
                    break;

                // UPDATE CAKE PRICE
                case 5:
                    System.out.print("Enter Cake ID : ");
                    int updatePriceId = scanner.nextInt();

                    System.out.print("Enter New Price : ");
                    double newPrice = scanner.nextDouble();

                    boolean updatePrice = service.updateCakePrice(updatePriceId, newPrice);

                    if (updatePrice) {
                        System.out.println("Cake Price Updated Successfully");
                    } else {
                        System.out.println("Cake Price Update Failed");
                    }
                    break;

                // DEACTIVATE CAKE
                case 6:
                    System.out.print("Enter Cake ID : ");
                    int deactivateId = scanner.nextInt();

                    boolean deactivate = service.deactivateCake(deactivateId);

                    if (deactivate) {
                        System.out.println("Cake Deactivated Successfully");

                    } else {
                        System.out.println("Cake Deactivation Failed");
                    }
                    break;

                // EXIT
                case 7:
                    System.out.println("Thank You For Using TastyBakers");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 7);

        scanner.close();
    }
}