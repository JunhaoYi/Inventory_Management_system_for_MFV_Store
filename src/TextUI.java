import java.util.Scanner;

public class TextUI {
    Scanner scanner = new Scanner(System.in);
    UserViewer userViewer = new UserViewer();
    ItemViewer itemViewer = new ItemViewer();
    PurchaseViewer purchaseViewer = new PurchaseViewer();

    public void desplayHomrPage() {
        System.out.println("Welcome to MFV system");
        // itemViewer.displayItembatch()
        boolean flag = true;
        while (flag) {
            System.out.println("You are visitor now.Please login or sign in");
            System.out.println("Input L to login or R to register");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("L")) {
                int tempUsrType = userViewer.displayLogin();
                if (tempUsrType == 0) {
                    customerPage();
                } else if (tempUsrType == 1) {
                    administratorPage();
                }

            } else if (input.equalsIgnoreCase("R")) {
                userViewer.displayRegister();
                customerPage();
            } else
                System.out.println("Wrong Input");

        }
    }

    // check out 在shopping car这个选项里面
    public void customerPage() {
        boolean flag = true;
        while (flag) {
            System.out.println("A ,Show all item \nB ,Search item \nC, Shopping car\nD, Edit your details\nE, Look shopping history\nF, Logout\nG, Unregister ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "A": {
                    itemViewer.displayAllItem();
                    break;
                }

                case "B": {
                    System.out.println("Please enter item name");
                    String userInput = scanner.nextLine();
                    itemViewer.displaySearchItemByName(userInput);
                    break;
                }

                case "C": {
                    itemViewer.displayShoppingCar();
                    break;
                }

                case "D": {
                    userViewer.displayEditUsr();
                    break;
                }

                case "E": {
                    purchaseViewer.displayOrderByUid();
                    break;
                }

                case "F": {
                    userViewer.displayLogout();
                    flag = false;
                    break;
                }

                case "G": {
                    userViewer.displayUnregister();
                    flag = false;
                }

            }
        }

    }

    public void administratorPage() {
        boolean flag = true;
        while (flag) {
            System.out.println("A, look purchase history\nB, look purchase history by item name\nC, look purchase history by user id\nD, edit user information\nE, delete user\n" +
                    "F, add item batch\nG, modify item detail\nH, delete item\nI, search item\nJ, logout");
            String choose = scanner.nextLine();
            switch (choose) {
                case "A": {
                    purchaseViewer.show();
                    break;
                }

                case "B": {
                    System.out.println("Please enter the item name.");
                    String input = scanner.nextLine();
                    purchaseViewer.showByName(input);
                    break;
                }

                case "C": {
                    System.out.println("Please enter the uid to show order history.");
                    String input = scanner.nextLine();
                    purchaseViewer.showByUid(Integer.parseInt(input));
                    break;
                }
                case "D": {
                    userViewer.displayEditUsr();
                    break;
                }
                case "E": {
                    userViewer.displayUnregister();
                    break;
                }
                case "F": {
                    itemViewer.displayAddItem();
                    break;
                }
                case "G": {
                    itemViewer.displayModify();
                    break;
                }
                case "H": {
                    itemViewer.displayDeleteItem();
                    break;
                }
                case "I": {
                    System.out.println("Please enter item name");
                    String userInput = scanner.nextLine();
                    itemViewer.displaySearchItemByName(userInput);
                    break;
                }
                case "J": {
                    userViewer.displayLogout();
                    flag = false;
                    break;
                }
            }
        }
    }
}