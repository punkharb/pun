package projectbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class login {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int choose = 0;
        boolean exit = false;
        boolean back = true, check = true;
        HashMap<String, String> user = new HashMap<>();

        File file = new File("projectbook/user.txt");
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String username = input.next();
            String password = input.next();
            user.put(username, password);
        }
        input.close();
        FileWriter fileWriter = new FileWriter("projectbook/user.txt", true);
        PrintWriter mada = new PrintWriter(fileWriter);

        while (!exit) {
            System.out.println("=================================");
            System.out.println("1. login");
            System.out.println("2. register");
            System.out.println("3. let me out");
            System.out.println("=================================");
            System.out.print("Chose one ==> ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Enter your username: ");
                    String loginUsername = sc.next();
                    System.out.print("Enter your password: ");
                    String loginPassword = sc.next();
                    if (user.containsKey(loginUsername) && user.get(loginUsername).equals(loginPassword)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 2:
                    back = true;
                    while (back) {
                        check = true;
                        System.out.println("============ Registers =================");
                        System.out.print("Enter your username: ");
                        String username = sc.next();
                        System.out.println();
                        System.out.print("Enter your password: ");
                        String password = sc.next();
                        System.out.println();
                        System.out.print("Enter your password again: ");
                        String password2 = sc.next();
                        System.out.println();
                        if (username.length() < 3) {
                            System.out.println("Username must be at least 3 characters");
                        } else if (password.length() < 3) {
                            System.out.println("Password must be at least 3 characters");
                        } else if (!password.equals(password2)) {
                            System.out.println("Password not match");
                        } else if (user.containsKey(username)) {
                            System.out.println("Username already exists");
                        } else {
                            user.put(username, password);
                            mada.println(username + " " + password);
                            mada.flush();
                            System.out.println("Register successful");
                            back = false;
                            check = false;
                        }
                        if (check) {
                            boolean retry = true;
                            while (retry) {
                                System.out.println("Do you want to retry?");
                                System.out.println("1. yes");
                                System.out.println("2. no");
                                System.out.print("Chose one ==> ");
                                choose = sc.nextInt();
                                switch (choose) {
                                    case 1:
                                        retry = false;
                                        break;
                                    case 2:
                                        back = false;
                                        retry = false;
                                        break;
                                    default:
                                        System.out.println("Please choose 1 or 2");
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        mada.close();
    }
}
