
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class sample_code {
    public static void main(String[] args) {
        // values passes using constructor
        User user = new User("John Doe", "2000-01-01");

        // System.out.printf("%s was born on %s and he is %d years old", user.getName(),
        // user.getBday(),
        // user.age());

        Book book = new Book("The Alchemist", "Paulo Coelho", 100);

        // user.Borrow(book);

        // System.out.printf("\n%s has borrowed these books: %s", user.getName(),
        // user.borrowedBooks());

        AudioBook audioBookDracula = new AudioBook(100, "Dracula", "Bram Stoker");
        Ebook jeeves = new Ebook("PDF", "Carry on Jeeves", "P.G. Wodehouse", 200);

        System.out.println(jeeves.toString());
    }
}
// above values are comming from User.java file of this folder/package

// classes defined for main class
class User {
    String name;
    LocalDate bday;

    // constructor defined to initalize the values and objects
    User(String name, String bday) {
        this.name = name;
        this.bday = LocalDate.parse(bday);
    }

    int age() {
        int age = Period.between(this.bday, LocalDate.now()).getYears();
        return age;
    }

    ArrayList<Book> books = new ArrayList<Book>();

    void Borrow(Book book) {
        this.books.add(book);
    }

    // get methods to get the values
    String getName() {
        return this.name;
    }

    // get methods to get the values
    String getBday() {
        return this.bday.toString();
    }

    public String borrowedBooks() {
        return this.books.toString();
    }
}

class Book {
    String title;
    String author;
    int pageCount;

    Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String toString() {
        return String.format("%s by %s", this.title, this.author);
    }
}

class AudioBook extends Book {
    int runTime;

    AudioBook(int runTime, String title, String author) {

        // call its immediate parent class constructor
        super(title, author, 0);
        this.runTime = runTime;
    }
}

class Ebook extends Book {
    String format;

    // constructor to initialize the values
    Ebook(String format, String title, String author, int pageCount) {

        // call its immediate parent class constructor
        super(title, author, pageCount);
        this.format = format;
    }
}