package human;

public abstract class Human {

    public abstract String getName();
    public abstract String getGender();

    public static Human create (String humanName, String pnr) {
        int lastNum = Integer.parseInt(pnr.substring(pnr.length()-1));

        if (lastNum == 0){
            return new NonBinary(humanName);
        }
        else if ((lastNum & 1) == 0){
            return new Woman(humanName);
        }
        else{
            return new Man(humanName);
        }
    }

    @Override
    public String toString() {
        return "Jag är " + this.getGender() + " och heter " + this.getName();
    }
}

class NonBinary extends Human{
    private static String gender = "icke-binär";
    private String name;

    NonBinary(String humanName){
        name = humanName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }
}

class Woman extends Human{
    private static String gender = "kvinna";
    private String name;

    Woman(String humanName){
        name = humanName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }
}

class Man extends Human{
    private static String gender = "man";
    private String name;

    Man(String humanName){
        name = humanName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

}