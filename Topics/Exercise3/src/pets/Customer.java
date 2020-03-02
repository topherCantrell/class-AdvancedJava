package pets;


public class Customer {
    
    private int id;
    private String name;
    private int numDogs;
    private int numCats;
    
    public Customer(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "id="+id+", name='"+name+"', numDogs="+numDogs+", numCats="+numCats;
    }
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumDogs() {
        return numDogs;
    }
    public void setNumDogs(int numDogs) {
        this.numDogs = numDogs;
    }
    public int getNumCats() {
        return numCats;
    }
    public void setNumCats(int numCats) {
        this.numCats = numCats;
    }

}
