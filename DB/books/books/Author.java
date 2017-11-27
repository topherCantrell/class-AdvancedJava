package books;

public class Author {
    
    private String phone;
    private int id;    
    private String address;
    private String name;
    
    public Author(int id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }   
    
    @Override
    public String toString() {
        return "id="+id+", name='"+name+"', address='"+address+"', phone='"+phone+"'";
    }
   
}
