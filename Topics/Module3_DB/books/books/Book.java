package books;
import java.util.List;

public class Book {
    
    private int id;
    private String isbn;
    private String name;
    private Publisher publisher;
    private double price;
    private List<Author> authors;
    
    public Book(int id) {
        this.id = id;
    }
    
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    public int getId() {
        return id;
    }
}
