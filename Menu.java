package projectbook;

public class Menu implements SystemBookStore {
    public void displayAskMoney() {
        System.out.println("========================================================================");
        System.out.println("Hello, welcome to our bookstore !!!");
        System.out.println("========================================================================");
    }

    public void displayMenu() {
        System.out.println("========================================================================");
        System.out.println();
        System.out.println("What type of books do you want to buy ?");
        System.out.println("(1) Manga   (199 Baht / book)");
        System.out.println("(2) Novel   (159 Baht / book)");
        System.out.println("(3) Comic   (219 Baht / book)");
        System.out.println("------------------------------------------------");
        System.out.println("(4) Pay");
        System.out.println("(5) Wallet");
        System.out.println("(0) Exit !!");
        System.out.println("------------------------------------------------");
        System.out.print("Select the number ==>  ");
    }

    public void displayMenuManga() {
        System.out.println();
        System.out.println("------------------------ Manga ------------------------");
        System.out.println("(1) Naruto");
        System.out.println("(2) One Piece");
        System.out.println("(3) Jujutsu Kaisen");
        System.out.println("(4) Sword Art Online");
        System.out.println("(5) Berserk");
        System.out.println("------------------------------------------------");
        System.out.println("(0) Back !!!");
        System.out.println("------------------------------------------------");
        System.out.print("Select the number ==>  ");
    }

    public void displayMenuNovel() {
        System.out.println();
        System.out.println("------------------------ Novel ------------------------");
        System.out.println("(1) Harry Potter");
        System.out.println("(2) The Great Gatsby");
        System.out.println("(3) Don Quixote");
        System.out.println("(4) 1987");
        System.out.println("(5) The Bible");
        System.out.println("------------------------------------------------");
        System.out.println("(0) Back !!!");
        System.out.println("------------------------------------------------");
        System.out.print("Select the number ==>  ");
    }

    public void displayMenuComic() {
        System.out.println();
        System.out.println("------------------------ Comic ------------------------");
        System.out.println("(1) X-Men (1991)");
        System.out.println("(2) X-Force (1992)");
        System.out.println("(3) The Walking Dead");
        System.out.println("(4) Batman (1986)");
        System.out.println("(5) Spider-Man (1990)");
        System.out.println("------------------------------------------------");
        System.out.println("(0) Back !!!");
        System.out.println("------------------------------------------------");
        System.out.print("Select the number ==>  ");
    }

    public void displayPayment() {
        System.out.println();
        System.out.println("(1) Comfirm purchase");
        System.out.println("(2) Remove some items");
        System.out.println("------------------------------------------------");
        System.out.println("(0) Back !!!");
        System.out.println("------------------------------------------------");
        System.out.print("Select the number ==>  ");
    }

    public void displayMenuWallet() {
        System.out.println("(1) Your balance");
        System.out.println("(2) Deposit");
        System.out.println("(3) Withdraw");
        System.out.println("------------------------------------------------");
        System.out.println("(0) Back !!!");
        System.out.println("------------------------------------------------");
        System.out.print("Select the number ==>  ");
    }
}
