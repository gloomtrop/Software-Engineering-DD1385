import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        //Containers
        Container suitcase = new Container("Suitcase", 1.5);
        Container vanitycase = new Container("Vanity case", 0.05);
        //Add Vanity Case to Suitcase
        suitcase.addItem(vanitycase);
        //Items
        Component shirt = new Component("Shirt", 0.07);
        Component jeans = new Component("Jeans", 0.8);
        Component pairOfSocks = new Component("Pair_of_Socks", 0.008);
        //Add loose items
        suitcase.addItem(shirt);
        suitcase.addItem(jeans);
        suitcase.addItem(pairOfSocks);
        //For Vanity Case
        Component soup = new Component("Soap", 0.25);
        Component shampoo = new Component("Shampoo", 0.75);
        Component toothbrush = new Component("Toothbrush", 0.02);
        Container plasticBag = new Container("Plastic Bag", 0.001);

        //Add items to Vanity Case
        vanitycase.addItem(soup);
        vanitycase.addItem(shampoo);
        vanitycase.addItem(toothbrush);
        vanitycase.addItem(plasticBag);

        //Add items to Plastic Bag
        plasticBag.addItem(new Component("Glue", 0.02));
        plasticBag.addItem(new Component("Paper", 0.01));

        System.out.println("Weight: " + suitcase.getWeight());
        System.out.println(suitcase.toString());
        Iterator<Bag> suitcaseIt = suitcase.iterator();
        while (suitcaseIt.hasNext()){
            System.out.print(suitcaseIt.next() + " ");
        }
        System.out.println();

        for (Bag bag : suitcase) {
            System.out.print(bag + " ");
        }
    }
}
