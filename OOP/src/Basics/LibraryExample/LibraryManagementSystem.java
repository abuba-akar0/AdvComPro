package Basics.LibraryExample;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // TODO code application logic here
        char ch;
        ArrayList<Book> books = new ArrayList<>();
        //Book b;
        Scanner input = new Scanner(System.in);
        int ID;
        String Name, Author, Category;
        Book bb = new Book();

        do{
            System.out.println("*** Library Management System ***");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. View Book Category");
            System.out.println("4. Update Book");
            System.out.println("5. Sort Book Through ID");
            System.out.println("**********************************");
            System.out.print("Enter choice : ");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Book ID : ");
                    ID = input.nextInt();
                    System.out.print("Enter Book Name : ");
                    Name = input.next();
                    System.out.print("Enter Book Author : ");
                    Author = input.next();
                    System.out.print("Enter Book Category : ");
                    Category = input.next();

                    books.add(new Book(ID, Name, Author, Category));
                    System.out.println("Book Added Successfully...");
                    break;
                case 2:
                    for(Book b : books){
                        b.display();
                    }
                    break;
                case 3:
                    System.out.print("Enter Book Category : ");
                    String cat = input.next();

                    for(Book b : books){
                        if(b.get_Category().equals(cat))
                            b.display();
                        else
                            System.out.println("Book not exist");
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to Update : ");
                    int id = input.nextInt();
                    boolean found = false;
                    for(Book b : books){
                        if(b.get_ID() == id){
                            found = true;
                            System.out.print("Enter Book Name : ");
                            Name = input.next();
                            System.out.print("Enter Book Author : ");
                            Author = input.next();
                            System.out.print("Enter Book Category : ");
                            Category = input.next();

                            b.set_Name(Name);
                            b.set_Author(Author);
                            b.set_Category(Category);

                            System.out.println("Book Updated Successfully...");
                            break;
                        }
                    }
                    break;
                case 5:
                    // Bubble Sort
                    int n = books.size();
                    for(int i=0; i<n-1; i++){
                        for(int j=0; j<n-i-1; j++){
                            if(books.get(j).get_ID() > books.get(j+1).get_ID()){
                                // swap books[j] and books[j+1]
                                Book temp = books.get(j);
                                books.set(j, books.get(j+1));
                                books.set(j+1, temp);
                            }
                        }
                    }
                    System.out.println("Books Sorted Successfully...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.print("Do you want to run again (Y/N) : ");
            ch = input.next().charAt(0);
        }while(ch == 'Y' || ch == 'y');
    }
}