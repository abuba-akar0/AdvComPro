package Basics.LibraryExample;

public class Book {
    //Data Members
    private int ID;
    private String Name;
    private String Author;
    private String Category;

    Book(){
        this(0,"","","");
    }
    Book(int ID, String Name, String Author, String Category){
        this.ID = ID;
        this.Name = Name;
        this.Author = Author;
        this.Category = Category;
    }
    //Setter
    void set_ID(int ID){
        this.ID = ID;
    }
    void set_Name(String Name){
        this.Name = Name;
    }
    void set_Author(String Author){
        this.Author = Author;
    }
    void set_Category(String Category){
        this.Category = Category;
    }
    //Getter
    int get_ID(){
        return this.ID;
    }
    String get_Name(){
        return this.Name;
    }
    String get_Author(){
        return this.Author;
    }
    String get_Category(){
        return this.Category;
    }
    //Member Methods
    void addBook(int id, String name, String author, String category){
        this.set_ID(id);
        this.set_Name(name);
        this.set_Author(author);
        this.set_Category(category);

        System.out.println("Insert Successfully...");
    }
    void display(){
        System.out.printf("%-10s %-20s %-20s %-15s\n", this.get_ID(), this.get_Name(), this.get_Author(), this.get_Category());
    }
}
