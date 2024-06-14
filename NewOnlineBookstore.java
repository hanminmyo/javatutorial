import java.util.*;

class Book 
{
    private String title;
    private String author;
    private String genre;
    private double price;

    public Book(String title, String author, String genre, double price) 
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String getGenre()
    {
        return genre;
    }

    public double getPrice() 
    {
        return price;
    }

    public String toString() 
    {
        return "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nPrice: $" + price;
    }
}

class User 
{
    private String username;
    private String password;
    private int balance; 

    public User(String username, String password, int balance) 
    {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public boolean authenticate(String username, String password) 
    {
        return this.username.equals(username) && this.password.equals(password);
    }

    public int getBalance() 
    {
        return balance;
    }

    public void deductBalance(double amount) 
    {
        balance -= amount;
    }
}

class Bookstore 
{
    private List<Book> books;
    private List<Book> cart;
    private User user;

    public Bookstore() 
    {
        books = new ArrayList<>();
        cart = new ArrayList<>();
        // Books in the book store
        books.add(new Book("The Alchemist", "Paulo Coelho", "Fiction", 10.99));
        books.add(new Book("Animal Farm", "George Orwell", "Fiction", 12.99));
        books.add(new Book("Life of Pi", "Yann Martel", "Fiction", 14.99));

        books.add(new Book("A Game of Thrones", "George Martin", "Fantasy", 12.50));
        books.add(new Book("The Changeling", "Victor LaValle", "Fantasy", 16.55));
        books.add(new Book("The Eye of the World", "Robert Jordan", "Fantasy", 10.99));

        books.add(new Book("The Silence of the Lambs", "Thomas Harris", "Mystery", 15.75));
        books.add(new Book("Shutter Island", "Dennis Lehane", "Mystery", 19.00));

        books.add(new Book("David Copperfield", "Charles Dickens", "Autobiography", 13.99));
        books.add(new Book("Wuthering Heights", "Emily Bronte", "Autobiography", 19.99));

        books.add(new Book("War and Peace", "Leo Tolstoy", "Historical Fiction", 39.99));

        user = new User("admin123", "12345", 1000); // user name-(admin123)/ password-(12345)/
    }

    public boolean login(String username, String password) 
    {
        return user.authenticate(username, password);
    }

    public void displayBooksByGenre(String genre) 
{
    boolean found = false;
    System.out.println("Books in " + genre + " genre:");
    for (Book book : books) 
    {
        if (book.getGenre().equalsIgnoreCase(genre)) 
        {
            found = true;
            System.out.println(book);
            System.out.println("------------------");
            System.out.print("Add this book to cart? (Yes/No): ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Yes")) 
            {
                addToCart(book);
            }
        }
    }
    if (!found) 
    {
        System.out.println("Books in " + genre + " genre not found in the bookstore."); // Display message for books not found
        System.out.println("Do you want to continue? (Yes/No): ");
        Scanner scanner = new Scanner(System.in);
        String continueChoice = scanner.nextLine();
        if (continueChoice.equalsIgnoreCase("Yes")) 
        {
            System.out.print("Enter genre: ");
            String newGenre = scanner.nextLine();
            displayBooksByGenre(newGenre);
        }
    }
}

public void displayBooksByAuthor(String author) 
{
    boolean found = false;
    System.out.println("Books by " + author + ":");
    for (Book book : books) 
    {
        if (book.getAuthor().equalsIgnoreCase(author)) 
        {
            found = true;
            System.out.println(book);
            System.out.println("-------------------");
            System.out.print("Add this book to cart? (Yes/No): ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Yes")) 
            {
                addToCart(book);
            }
        }
    }
    if (!found) 
    {
        System.out.println("Books by " + author + " not found in the bookstore.");
        System.out.println("Do you want to continue? (Yes/No): ");
        Scanner scanner = new Scanner(System.in);
        String continueChoice = scanner.nextLine();
        if (continueChoice.equalsIgnoreCase("Yes")) 
        {
            System.out.print("Enter author: ");
            String newAuthor = scanner.nextLine();
            displayBooksByAuthor(newAuthor);
        }
    }
}

public void displayBooksByTitle(String title) 
{
    boolean found = false;
    System.out.println("Books by " + title + ":");
    for (Book book : books) 
    {
        if (book.getTitle().equalsIgnoreCase(title)) 
        {
            found = true;
            System.out.println(book);
            System.out.println("-------------------");
            System.out.print("Add this book to cart? (Yes/No): ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Yes")) 
            {
                addToCart(book);
            }
        }
    }
    if (!found) 
    {
        System.out.println("Book not found in the bookstore."); 
        System.out.println("Do you want to continue? (Yes/No): ");
        Scanner scanner = new Scanner(System.in);
        String continueChoice = scanner.nextLine();
        if (continueChoice.equalsIgnoreCase("Yes")) 
        {
            // Allow the user to continue searching
            System.out.println("Enter title: ");
            String newTitle = scanner.nextLine();
            displayBooksByTitle(newTitle);
        }
    }
}
    public void addToCart(Book book) 
    {
        if (books.contains(book)) {
            cart.add(book);
            System.out.println("Book added to cart: " + book.getTitle());
            System.out.println("Do you want to continue shopping or view your cart? (Continue/View)");
            Scanner scanner = new Scanner(System.in);
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("View")) {
                viewCart();
            } else {
                // Continue shopping
                System.out.println("Select an option:");
                System.out.println("1. Display books by genre");
                System.out.println("2. Display books by author");
                System.out.println("3. Display books by title");
                System.out.println("4. View cart");
                System.out.println("5. Buy books");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        displayBooksByGenre(genre);
                        break;
                    case 2:
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        displayBooksByAuthor(author);
                        break;
                    case 3:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        displayBooksByTitle(title);
                        break;
                    case 4:
                        viewCart();
                        break;
                    case 5:
                        buyBooks();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } 
        else 
        {
            System.out.println("Book not found in the bookstore."); 
            System.out.println("Do you want to continue? (Yes/No): ");
            Scanner scanner = new Scanner(System.in);
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("Yes")) 
            {
                System.out.println("Select an option:");
                System.out.println("1. Display books by genre");
                System.out.println("2. Display books by author");
                System.out.println("3. Display books by title");
                System.out.println("4. View cart");
                System.out.println("5. Buy books");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    case 1:
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        displayBooksByGenre(genre);
                        break;
                    case 2:
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        displayBooksByAuthor(author);
                        break;
                    case 3:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        displayBooksByTitle(title);
                        break;
                    case 4:
                        viewCart();
                        break;
                    case 5:
                        buyBooks();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
    
    public void viewCart() 
    {
        if (cart.isEmpty()) 
        {
            System.out.println("YOUR CART IS EMPTY.");
        } 
        else 
        {
            System.out.println("BOOKS IN YOUR CART:");
            double totalAmount = 0;
            for (Book book : cart) 
            {
                System.out.println(book);
                System.out.println("-------------------");
                totalAmount += book.getPrice();
            }
            System.out.println("Total Amount: $" + totalAmount);
            System.out.println("Do you want to buy these books? (Yes/No)");
            Scanner scanner = new Scanner(System.in);
            String buyChoice = scanner.nextLine();
            if (buyChoice.equalsIgnoreCase("Yes")) {
                buyBooks();
            } else {
                System.out.println("Purchase cancelled.");
            }
        }
    }

    public void buyBooks() 
    {
        if (cart.isEmpty()) 
        {
            System.out.println("Your cart is empty.");
        } else {
            double totalAmount = 0;
            System.out.println("Books purchased:");
            for (Book book : cart) 
            {
                totalAmount += book.getPrice();
                System.out.println(book);
                System.out.println("-------------------");
            }
            
            if (totalAmount > user.getBalance()) 
            {
                System.out.println("Insufficient balance. Cannot complete purchase.");
            } 
            else 
            {
                user.deductBalance(totalAmount);
                System.out.println("Total Amount: $" + totalAmount);
                System.out.println("Remaining Balance: $" + user.getBalance());
                System.out.println("Thank you for shopping with us!");
                cart.clear(); 
            }
        }
    }
    
}

public class NewOnlineBookstore 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Bookstore bookstore = new Bookstore();

        System.out.println("Welcome to the Alex Online Bookstore!");

        // Authentication
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (bookstore.login(username, password)) 
        {
            System.out.println("Login successful!");
        } 
        else 
        {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        // Display book options
        System.out.println("Select an option:");
        System.out.println("1. Display books by Genre");
        System.out.println("2. Display books by Author");
        System.out.println("3. Display books by Title");
        System.out.println("4. View cart");
        System.out.println("5. Buy books");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) 
        {
            case 1:
                System.out.print("Enter genre: ");
                String genre = scanner.nextLine();
                bookstore.displayBooksByGenre(genre);
                break;
            case 2:
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                bookstore.displayBooksByAuthor(author);
                break;
            case 3:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                bookstore.displayBooksByTitle(title);
                break;
            case 4:
                bookstore.viewCart();
                break;
            case 5:
                bookstore.buyBooks();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
