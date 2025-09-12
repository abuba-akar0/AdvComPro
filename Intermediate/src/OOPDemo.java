class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(name + " makes a sound.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " barks.");
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        Animal generic = new Animal("GenericAnimal");
        Dog dog = new Dog("Buddy");

        generic.speak(); // Polymorphism
        dog.speak();     // Polymorphism

        // Encapsulation example
        Person person = new Person("Alice", 25);
        System.out.println(person.getName() + " is " + person.getAge() + " years old.");
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Encapsulation: getters and setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

