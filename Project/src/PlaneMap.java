import java.util.HashMap;

public class PlaneMap extends HashMap<Coords, Integer> {
    @Override
    public boolean containsKey(Object key) {
        key = (Coords) key;
        return super.containsKey(key);
    }
}
