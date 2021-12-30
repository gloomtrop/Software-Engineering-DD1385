public class NumberedItem <T>{
        int i;
        T generic;

        NumberedItem(int index, T genericVal){
            if (index < 0 ){
                i = 0;
            }
            else{
                i = index;
            }
            generic = genericVal;
        }

        public int compareTo(NumberedItem other){
            return this.i - other.i;
        }

        public String toString(){
            return "Index: " + i + " Value: " + generic;
        }
}
