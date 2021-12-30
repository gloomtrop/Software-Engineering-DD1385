import java.util.*;

class GlesVector1<E extends Comparable<E>> extends TreeMap<Integer, E> implements SparseVec<E> {

    @Override
    public void add(E elem) {
        for (int i = 0; i< size()+1; i++){
            if (!(containsKey(i))){
                put(i, elem);
                break;
            }
        }
    }

    @Override
    public void add(int pos, E elem) {
        put(pos, elem);
    }

    @Override
    public int indexOf(E elem) {
        Set<Integer> keys = keySet();

        for (Integer key: keys){
            if (get(key).equals(elem)){
                return key;
            }
        }
        return -1;
    }

    @Override
    public void removeAt(int pos) {
        remove(pos);
    }

    @Override
    public void removeElem(E elem) {
        Set<Integer> keys = keySet();

        for (Integer key: keys) {
            if (get(key).equals(elem)) {
                remove(key);
            }
        }
    }


    public int size() {
        Set<Integer> keys = keySet();
        int i = 0;
        for (Integer key: keys){
            i++;
        }
        return i;
    }

    @Override
    public int minIndex() {
        if (!(isEmpty())){
            return firstKey();
        }
        return 0;
    }

    @Override
    public int maxIndex() {
        if (!(isEmpty())){
            return lastKey();
        }
        return 0;
    }

    public E get(int pos) {
        Set<Integer> keys = keySet();

        for (Integer key: keys){
            if (key == pos){
                return get(key);
            }
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        if (isEmpty()){
            return null;
        }
        Integer lastIndex = lastKey();
        Object[] array = new Object[lastIndex+1];
        Arrays.fill(array, null);
        Set<Integer> keys = keySet();


        for (Integer key: keys){
            array[key] = get(key);
        }

        return array;
    }

    @Override
    public List<E> sortedValues() {
        List<E> list = new ArrayList<>();

        TreeMap<Integer, E> sortVec = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sortVec.putAll(this);
        if (sortVec.size() ==0){
            return null;
        }

        // Display the TreeMap which is naturally sorted
        for (Map.Entry<Integer, E> entry : sortVec.entrySet())
            list.add(entry.getValue());

        return list;
    }

    public String toString(){
        String output = "";
        Object[] list = toArray();

        for (int i = 0; i<list.length; i++){
            if (!(list[i] == null)){
                output += "Index: " + i + " Value: " + get(i) + "\n";
            }
        }
        return output;
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