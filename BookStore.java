package projectbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookStore {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> mangaList = new ArrayList<String>();
        ArrayList<String> novelList = new ArrayList<String>();
        ArrayList<String> comicList = new ArrayList<String>();
        mangaList.add("Naruto");
        mangaList.add("One Piece");
        mangaList.add("Jujutsu Kaisen");
        mangaList.add("Sword Art Online");
        mangaList.add("Berserk");
        novelList.add("Harry Potter");
        novelList.add("The Great Gatsby");
        novelList.add("Don Quixote");
        novelList.add("1987");
        novelList.add("The Bible");
        comicList.add("X-Men (1991)");
        comicList.add("X-Force (1992)");
        comicList.add("The Walking Dead");
        comicList.add("Batman (1986)");
        comicList.add("Spider-Man (1990)");
        // --------------------------------------------------------------------------
        int choose = 0;
        boolean exit = false;
        boolean back = true, check = true;
        HashMap<String, String> user = new HashMap<>();
        HashMap<String, Integer> userbalance = new HashMap<>();
        String keys = "";

        File file = new File("projectbook/user.txt");
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String username = input.next();
            String password = input.next();
            user.put(username, password);
        }
        File file2 = new File("projectbook/userbalance.txt");
        Scanner input2 = new Scanner(file2);
        while (input2.hasNext()) {
            String username = input2.next();
            int balance = input2.nextInt();
            userbalance.put(username, balance);
        }
        FileWriter fileWriter = new FileWriter("projectbook/user.txt", true);
        PrintWriter mada = new PrintWriter(fileWriter);
        FileWriter fileWriterbalance = new FileWriter("projectbook/userbalance.txt", true);
        PrintWriter balan = new PrintWriter(fileWriterbalance);
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
                        keys = loginUsername;
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
                            userbalance.put(username, 0);
                            balan.println(username + " " + 0);
                            mada.println(username + " " + password);
                            balan.flush();
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
        // --------------------------------------------------------------------------

        // ===----------------------- Menu AskMoney ---------------------------===

        Menu menu = new Menu();
        menu.displayAskMoney();
        Thread.sleep(1000);

        // ===------------------------------------------------------------------------===

        // ===----------------------- Menu Type Of Books ---------------------------===

        HashMap<String, Integer> basketeer = new HashMap<>();
        int monk = 0, nov = 0, com = 0;
        exit = false;
        back = true;
        while (!exit) {
            menu.displayMenu();
            int choice = sc.nextInt();
            System.out.println("========================================================================");

            Thread.sleep(1000);

            switch (choice) {
                case 0:
                    System.out.println("Thank you for come our bookstore. See you next time Bye Bye.");
                    exit = true;
                    break;
                case 1:
                    back = true;
                    while (back) {
                        menu.displayMenuManga();
                        int mangaChoice = sc.nextInt();
                        System.out.println("========================================================================");

                        Thread.sleep(500);

                        switch (mangaChoice) {
                            case 0:
                                back = false;
                                break;
                            case 1:
                                basketeer.put("Naruto", basketeer.getOrDefault("Naruto", 0) + 1);
                                monk++;
                                break;
                            case 2:
                                basketeer.put("One Piece", basketeer.getOrDefault("One Piece", 0) + 1);
                                monk++;
                                break;
                            case 3:
                                basketeer.put("Jujutsu Kaisen", basketeer.getOrDefault("Jujutsu Kaisen", 0) + 1);
                                monk++;
                                break;
                            case 4:
                                basketeer.put("Sword Art Online", basketeer.getOrDefault("Sword Art Online", 0) + 1);
                                monk++;
                                break;
                            case 5:
                                basketeer.put("Berserk", basketeer.getOrDefault("Berserk", 0) + 1);
                                monk++;
                                break;
                            default:
                                System.out
                                        .println("Choose only the number that display is showing !!! (Wait 3 seconds)");
                                Thread.sleep(3000);
                                break;
                        }
                    }
                    break;
                case 2:
                    back = true;
                    while (back) {
                        menu.displayMenuNovel();
                        int novelChoice = sc.nextInt();
                        System.out.println("========================================================================");

                        Thread.sleep(500);

                        switch (novelChoice) {
                            case 0:
                                back = false;
                                break;
                            case 1:
                                basketeer.put("Harry Potter", basketeer.getOrDefault("Harry Potter", 0) + 1);
                                nov++;
                                break;
                            case 2:
                                basketeer.put("The Great Gatsby", basketeer.getOrDefault("The Great Gatsby", 0) + 1);
                                nov++;
                                break;
                            case 3:
                                basketeer.put("Don Quixote", basketeer.getOrDefault("Don Quixote", 0) + 1);
                                nov++;
                                break;
                            case 4:
                                basketeer.put("1987", basketeer.getOrDefault("1987", 0) + 1);
                                nov++;
                                break;
                            case 5:
                                basketeer.put("The Bible", basketeer.getOrDefault("The Bible", 0) + 1);
                                nov++;
                                break;
                            default:
                                System.out
                                        .println("Choose only the number that display is showing !!! (Wait 3 seconds)");
                                Thread.sleep(3000);
                                break;
                        }
                    }
                    break;
                case 3:
                    back = true;
                    while (back) {
                        menu.displayMenuComic();
                        int comicChoice = sc.nextInt();
                        System.out.println("========================================================================");

                        Thread.sleep(500);

                        switch (comicChoice) {
                            case 0:
                                back = false;
                                break;
                            case 1:
                                basketeer.put("X-Men (1991)", basketeer.getOrDefault("X-Men (1991)", 0) + 1);
                                com++;
                                break;
                            case 2:
                                basketeer.put("X-Force (1992)", basketeer.getOrDefault("X-Force (1992)", 0) + 1);
                                com++;
                                break;
                            case 3:
                                basketeer.put("The Walking Dead", basketeer.getOrDefault("The Walking Dead", 0) + 1);
                                com++;
                                break;
                            case 4:
                                basketeer.put("Batman (1986)", basketeer.getOrDefault("Batman (1986)", 0) + 1);
                                com++;
                                break;
                            case 5:
                                basketeer.put("Spider-Man (1990)", basketeer.getOrDefault("Spider-Man (1990)", 0) + 1);
                                com++;
                                break;
                            default:
                                System.out
                                        .println("Choose only the number that display is showing !!! (Wait 3 seconds)");
                                Thread.sleep(3000);
                                break;
                        }
                    }
                    break;

                // ===------------------------------------------------------------------------===

                // ===----------------------- Payment ---------------------------===

                case 4:
                    back = true;
                    while (back) {
                        exit = true;
                        int allprice = 0;
                        System.out.println();
                        System.out.println("------------------------ All books in basket ------------------------");
                        int p = 1;
                        String type = "";
                        int mangacount = 1, novelcount = 1, comiccount = 1;
                        boolean mang = false, nove = false, comi = false;
                        for (int j = 0; j < 3; j++) {
                            switch (j) {
                                case 0 -> type = "Manga";
                                case 1 -> type = "Novel";
                                case 2 -> type = "Comic";
                            }
                            if (monk != 0)
                                mang = true;
                            if (nov != 0)
                                nove = true;
                            if (com != 0)
                                comi = true;
                            if (type == "Manga" && mang || type == "Novel" && nove
                                    || type == "Comic" && comi) {
                                System.out.println("------------------------ " + type + " ------------------------");
                                for (String key : basketeer.keySet()) {
                                    if (mangaList.contains(key) && type == "Manga") {
                                        System.out.println(mangacount + ". " + key + " x " + basketeer.get(key));
                                        mangacount++;
                                    } else if (novelList.contains(key) && type == "Novel") {
                                        System.out.println(novelcount + ". " + key + " x " + basketeer.get(key));
                                        novelcount++;
                                    } else if (comicList.contains(key) && type == "Comic") {
                                        System.out.println(comiccount + ". " + key + " x " + basketeer.get(key));
                                        comiccount++;
                                    }
                                }
                            }
                        }
                        System.out.println();
                        allprice += (monk * 199) + (nov * 159) + (com * 219);
                        System.out.println("Total price " + allprice + " Baht");
                        System.out.println("Now you have " + userbalance.get(keys) + " Baht");

                        menu.displayPayment();

                        boolean tmploop = true;
                        while (tmploop) {
                            choice = sc.nextInt();
                            switch (choice) {
                                case 0:
                                    back = false;
                                    tmploop = false;
                                    exit = false;
                                    break;
                                case 1:
                                    if (userbalance.get(keys) >= allprice) {
                                        userbalance.put(keys, userbalance.get(keys) - allprice);
                                        System.out.println(
                                                "========================================================================");
                                        System.out.println();
                                        System.out.println("Thank you for your support");
                                        System.out.println("You have " + userbalance.get(keys) + " Baht left");
                                        System.out.println("------------------------------------------------");

                                        monk = 0;
                                        nov = 0;
                                        com = 0;
                                        tmploop = false;
                                        back = false;
                                        System.out.println("Do you want to buy more ?");
                                        System.out.println("(1) Yes");
                                        System.out.println("(2) No");
                                        System.out.print("Select the number ==>  ");
                                        choice = sc.nextInt();
                                        if (choice == 1) {
                                            basketeer.clear();
                                            exit = false;
                                        } else if (choice == 2) {
                                            exit = true;
                                        } else {
                                            System.out.println(
                                                    "Choose only the number that display is showing !!! (Wait 3 seconds)");
                                            Thread.sleep(3000);
                                        }
                                        break;
                                    } else {
                                        System.out.println(
                                                "Not enough money go to remove some items or deposit your balance");
                                    }
                                case 2:
                                    tmploop = false;
                                    boolean wait = true;
                                    while (wait) {
                                        System.out.println(
                                                "========================================================================");
                                        System.out.println();
                                        System.out.println(
                                                "------------------------ Select books that you want to remove or (0) Back !!! ------------------------");
                                        p = 1;
                                        for (String keyss : basketeer.keySet()) {
                                            System.out.println("(" + p + ") " + keyss + " x " + basketeer.get(keyss));
                                            p++;
                                        }
                                        System.out.println("------------------------------------------------");
                                        System.out.println("(0) Back !!!");
                                        System.out.println("------------------------------------------------");
                                        System.out.print("Select the number ==>  ");
                                        choice = sc.nextInt();
                                        if (choice == 0) {
                                            wait = false;
                                            System.out.println(
                                                    "========================================================================");
                                        } else if (choice <= basketeer.size() && choice >= 0) {
                                            System.out.println(
                                                    "------------------------ How many books do you want to remove ? ------------------------");
                                            System.out.print("==>  ");
                                            int malti = sc.nextInt();
                                            if (malti <= 0) {
                                                System.out.println("Can't remove");
                                            } else {
                                                p = 1;
                                                for (String keyss : basketeer.keySet()) {
                                                    if (choice == p) {
                                                        malti = Math.min(malti, basketeer.get(keyss));
                                                        basketeer.put(keyss, basketeer.get(keyss) - malti);
                                                        if (basketeer.get(keyss) <= 0) {
                                                            basketeer.remove(keyss);
                                                        }
                                                        System.out.println(
                                                                "Already remove " + keyss + " " + malti
                                                                        + (malti > 1 ? " books" : " book"));
                                                        Thread.sleep(1500);
                                                        if (mangaList.contains(keyss))
                                                            monk -= malti;
                                                        else if (novelList.contains(keyss))
                                                            nov -= malti;
                                                        else if (comicList.contains(keyss))
                                                            com -= malti;
                                                        break;
                                                    }
                                                    p++;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println(
                                            "Choose only the number that display is showing!!! (Wait 3 seconds)");
                                    Thread.sleep(3000);
                                    break;
                            }
                        }
                    }
                    break;

                // ===------------------------------------------------------------------------===

                // ===----------------------- Wallet ---------------------------===

                case 5:
                    back = true;
                    while (back) {
                        System.out.println(
                                "========================================================================");
                        System.out.println();
                        System.out.println(
                                "------------------------ Wallet -------------------------");

                        menu.displayMenuWallet();

                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Your balance is " + userbalance.get(keys) + " Baht");
                                Thread.sleep(1500);
                                break;
                            case 2:
                                System.out.println("How much money do you want to deposit ?");
                                System.out.print("==>  ");
                                int deposit = sc.nextInt();
                                userbalance.put(keys, userbalance.get(keys) + deposit);
                                System.out.println("Deposit " + deposit + " Baht is done");
                                Thread.sleep(1500);
                                break;
                            case 3:
                                System.out.println("How much money do you want to withdraw ?");
                                System.out.print("==>  ");
                                int withdraw = sc.nextInt();
                                if (withdraw <= userbalance.get(keys)) {
                                    userbalance.put(keys, userbalance.get(keys) - withdraw);
                                    System.out.println("Withdraw " + withdraw + " Baht is done");
                                    Thread.sleep(1500);
                                } else {
                                    System.out.println("You don't have enough money");
                                    Thread.sleep(1500);
                                }
                                break;
                            case 0:
                                back = false;
                                break;
                            default:
                                System.out
                                        .println("Choose only the number that display is showing !!! (Wait 3 seconds)");
                                Thread.sleep(3000);
                                break;
                        }
                    }
                    break;
                // ===------------------------------------------------------------------------===

                default:
                    System.out.println("Choose only the number that display is showing !!! (Wait 3 seconds)");
                    Thread.sleep(3000);
                    break;

                // ===------------------------------------------------------------------------===

            }
        }
    }
}