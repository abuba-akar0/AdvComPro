package Basics.InterfaceExample;

public class Hello implements Interface1, Interface2{

    public static void main(String[] args) {
        Interface1 obj = new Hello();
        obj.child1();
        Interface2 obj1 = new Hello();
        obj1.child2();
        obj.link();
        Interface2.ChildInterface obj2 = new Interface2.ChildInterface() {
            @Override
            public void childMethod() {
                System.out.println("Child Method");
            }
        };
        obj2.childMethod();
    }

    @Override
    public void child1() {
        System.out.println("Child One");
    }

    @Override
    public void link() {
        System.out.println("Link Method");
    }

    @Override
    public void child2() {
        System.out.println("Child Two");
    }
}
