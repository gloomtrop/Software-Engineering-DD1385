import java.util.*;
public interface SparseVec<E extends Comparable<E>> {
    public void add(E elem);           // add at lowest index >= 0 and not already occupied
    public void add(int pos, E elem);  // add elem at pos, if pos is occupied replace with elem, if pos<0 use index = 0
    public int indexOf(E elem);        // find first (lowest index) occurence of elem, return its index,
    // if not found, return -1
    public void removeAt(int pos);     // if index pos is not used, nothing happens
    public void removeElem(E elem);    // remove first occurence (lowest index) of elem
    public int size();
    public int minIndex();             // lowest index in use, if vector is empty return -1
    public int maxIndex();             // highest index in use, if vector is empty return -1
    public String toString();          // one line per element with index and value, sorted by index
    public E get(int pos);             // return null if not available
    public Object[] toArray();         // return the SparseVector as a regular array with value null at unused indexes
    public List<E> sortedValues();     // return a List of the values of the Vector in sorted order
}

class GlesVector <E extends Comparable<E>> implements SparseVec<E> {
    TreeMap<Integer,E> vector = new TreeMap<>();

    @Override
    public void add(E elem) {
        for (int i = 0; i< vector.size()+1; i++){
            if (!(vector.containsKey(i))){
                vector.put(i, elem);
                break;
            }
        }
    }

    @Override
    public void add(int pos, E elem) {
        vector.put(pos, elem);
    }

    @Override
    public int indexOf(E elem) {
        Set<Integer> keys = vector.keySet();

        for (Integer key: keys){
            if (vector.get(key).equals(elem)){
                return key;
            }
        }
        return -1;
    }

    @Override
    public void removeAt(int pos) {
        vector.remove(pos);
    }

    @Override
    public void removeElem(E elem) {
        Set<Integer> keys = vector.keySet();

        for (Integer key: keys) {
            if (vector.get(key).equals(elem)) {
                vector.remove(key);
            }
        }
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public int minIndex() {
        if (!(vector.isEmpty())){
            return vector.firstKey();
        }
        return 0;
    }

    @Override
    public int maxIndex() {
        if (!(vector.isEmpty())){
            return vector.lastKey();
        }
        return 0;
    }

    @Override
    public E get(int pos) {
        if (vector.containsKey(pos)) {
            return vector.get(pos);
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        if (vector.isEmpty()){
            return null;
        }
        Integer lastIndex = vector.lastKey();
        Object[] array = new Object[lastIndex+1];
        Arrays.fill(array, null);
        Set<Integer> keys = vector.keySet();


        for (Integer key: keys){
            array[key] = vector.get(key);
        }

        return array;
    }

    @Override
    public List<E> sortedValues() {
        List<E> list = new ArrayList<>();

        TreeMap<Integer, E> sortVec = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sortVec.putAll(vector);
        if (sortVec.size() ==0){
            return null;
        }

        // Display the TreeMap which is naturally sorted
        for (Map.Entry<Integer, E> entry : sortVec.entrySet())
            list.add(entry.getValue());

        return list;
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        Object[] list = toArray();

        for (int i = 0; i<list.length; i++){
            if (!(list[i] == null)){
                output.append("Index: ").append(i).append(" Value: ").append(vector.get(i)).append("\n");
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        GlesVector<String> vec = new GlesVector<>();
        vec.add(1,"hej");
        vec.add(10,"oh");
        vec.add(2,"då");
        vec.add(3,"hi");
        vec.add(4,"bye");
        System.out.println(vec.sortedValues());
        System.out.println(Arrays.toString(vec.toArray()));
        System.out.println(vec);
    }
}