import human.*;

public class Create {
    public static void main(String[] args) {

//        Human human = new Human() {};
//        NonBinary sven = new NonBinary("sven");
        Human billie = Human.create("Billie", "xxxxxx-5600");
        Human anna = Human.create("Anna", "xxxxxx-6422");
        Human magnus = Human.create("Magnus","xxxxxx-0111");
        System.out.println(billie);
        System.out.println(anna);
        System.out.println(magnus);

    }
}
