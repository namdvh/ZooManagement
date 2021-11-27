package animalpkg;

public class BFA extends Animal {
    static boolean heroic;

    public BFA() {
        super();
        heroic = true;
    }

    public BFA(String id, String name, AnimalTypes type, String color, double weight, boolean heroic) {
        super(id, name, type, color, weight);
        this.heroic = heroic;
    }

    public static boolean isHeroic() {
        return heroic;
    }

    public static void setHeroic(boolean heroic) {
        BFA.heroic = heroic;
    }

    @Override
    public String toString() {
        return "BFA{" +super.toString()+"heroic="+heroic+"}\n";
    }

    @Override
    public String strtoFile() {
        return super.strtoFile() + ";" +heroic;
    }
}
