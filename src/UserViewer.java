import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * User Viewer
 * @author Fanchao
 */
public class UserViewer {
    UsrController usrController = new UsrController();
    Scanner scanner = new Scanner(System.in);

    /**
     * display login information
     * @return The user id
     */
    public int displayLogin() {
        while (true) {
            System.out.println("Please input you email");
            String email = scanner.nextLine();
            if (Pattern.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", email.trim())) {
                System.out.println("please input you password");
                String password = scanner.nextLine();
                String[] inputInfo = {email, password};
                int tempUsrType = usrController.login(inputInfo);
                if (tempUsrType != -1) {
                    System.out.println("Successful login");
                    return tempUsrType;
                } else {
                    System.out.println("Wrong Info");
                    return -1;
                }
            }
        }
    }

    /**
     * display register information
     */
    public void displayRegister() {
        System.out.println("please input your email");
        String email = scanner.nextLine();
        System.out.println("please input you phone");
        String phone = scanner.nextLine();
        System.out.println("please input you name");
        String name = scanner.nextLine();
        System.out.println("please input your password");
        String pass1 = scanner.nextLine();
        System.out.println("please input you password again");
        String pass2 = scanner.nextLine();
        String[] info = {email, phone, name, pass1, pass2};
        if (usrController.registerUsr(info))
            System.out.println("success");
        else
            System.out.println("Register Failed");
    }

    /**
     * Show all user information
     */
    public void showAllUsr() {
        usrController.showAll();
    }

    /**
     * Show the information of edit user
     */
    public void displayEditUsr() {
        System.out.println("Now we are going to modify your personal details");
        System.out.println("Please input you email:");
        String email = scanner.nextLine();
        System.out.println("Please input you phone:");
        String phone = scanner.nextLine();
        System.out.println("Please input you name:");
        String name = scanner.nextLine();
        String[] info = {email, phone, name};
        if (usrController.editInfo(info))
            System.out.println("Success");
        else
            System.out.println("unSuccess");
    }

    public void checkOut() {
        System.out.println("Please input your address");

    }

    /**
     * Display logout
     */
    public void displayLogout() {
        usrController.logout();
        System.out.println("Successful logout");
    }

    public void displayUnregister() {
        System.out.println("please input which unregister user id:");
        String id = scanner.nextLine();
        System.out.println("please input your password");
        String password = scanner.nextLine();
        usrController.unRegisterUsr(Integer.parseInt(id), password);
    }
}