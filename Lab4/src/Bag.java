import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Bag {
    public abstract double getWeight();
    public abstract String toString();
}

class Container extends Bag implements Iterable<Bag>{
    private String containerName;
    private double containerWeight;
    private double totalWeight = 0;
    private String itemNames = "";
    private List<Bag> items;

    Container(String name, double weight){
        containerName = name;
        containerWeight = weight;
        itemNames += name + ": {";
        totalWeight += containerWeight;
        items = new ArrayList<>();

    }
    @Override
    public double getWeight() {
        for (Bag item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

//    public String toString(){
//        for (Bag item : items){
//            itemNames += item.toString() + " ";
//        }
//        return itemNames + "}";
//    }

    public String toString(){return containerName;}

    public void addItem(Bag item){
        items.add(item);
    }

    public List<Bag> getChildren(){return items;}

    //Breath-First-search
//    @Override
//    public Iterator<Bag> iterator() {
//        return new Iterator<Bag>() {
//            List<Bag> queue = new ArrayList<>(items);
//            int i = 0;
//            @Override
//            public boolean hasNext() {
//                return queue.size()!= 0;
//            }
//
//            @Override
//            public Bag next() {
//                Bag item = queue.get(i);
//                if (item instanceof Container){
//                    List<Bag> children = ((Container) item).getChildren();
//                    queue.addAll(children);
//                }
//                queue.remove(i);
//                return item;
//            }
//        };
//    }
    //Depth - First - Search
    @Override
    public Iterator<Bag> iterator() {
        return new Iterator<Bag>() {
            List<Bag> stack = new ArrayList<>(items);
            int i = 0;
            @Override
            public boolean hasNext() {
                return stack.size()!= 0;
            }

            @Override
            public Bag next() {
                Bag item = stack.get(i);
                stack.remove(i);
                if (item instanceof Container){
                    List<Bag> children = ((Container) item).getChildren();
                    for (Bag child: children){
                        stack.add(0, child);
                    }
                }
                return item;
            }
        };
    }
}

class Component extends Bag{
    private String itemName;
    private double itemWeight;

    Component(String name, double weight){
        itemName = name;
        itemWeight = weight;
    }
    @Override
    public double getWeight() {
        return itemWeight;
    }
    public String toString(){
        return itemName;
    }
}
