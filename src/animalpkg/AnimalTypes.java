package animalpkg;

public class AnimalTypes {
    public static final int ZLA = 1, BLFA = 2;
    public static final int BFA = 3, FLA = 4;
    private int type;
    private String desc;
    private int numLegs;
    private int numSwings;
    private String moving;
    static boolean canFly;
    static boolean canSing;
    static boolean canGrowl;
    private String food;
    private double maxWeight;

    public AnimalTypes() {
        type = 0;
        desc = "";
        numLegs = 0;
        numSwings = 0;
        canFly = true;
        canSing = true;
        canGrowl = true;
        food = "";
        maxWeight = 0;
    }

    public AnimalTypes(int type, String desc, int numLegs, int numSwings, String moving, boolean canFly, boolean canSing, boolean canGrowl, String food, double maxWeight) {
        this.type = type;
        this.desc = desc;
        this.numLegs = numLegs;
        this.numSwings = numSwings;
        this.moving = moving;
        this.canFly = canFly;
        this.canSing = canSing;
        this.canGrowl = canGrowl;
        this.food = food;
        this.maxWeight = maxWeight;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public int getNumSwings() {
        return numSwings;
    }

    public void setNumSwings(int numSwings) {
        this.numSwings = numSwings;
    }

    public static boolean isCanFly() {
        return canFly;
    }

    public static void setCanFly(boolean canFly) {
        AnimalTypes.canFly = canFly;
    }

    public static boolean isCanSing() {
        return canSing;
    }

    public static void setCanSing(boolean canSing) {
        AnimalTypes.canSing = canSing;
    }

    public static boolean isCanGrowl() {
        return canGrowl;
    }

    public static void setCanGrowl(boolean canGrowl) {
        AnimalTypes.canGrowl = canGrowl;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "AnimalTypes{" +
                "type=" + type +
                ", desc='" + desc + '\'' +
                ", numLegs=" + numLegs +
                ", numSwings=" + numSwings +
                ", food='" + food + '\'' +
                ", maxWeight=" + maxWeight +
                '}';
    }

}
