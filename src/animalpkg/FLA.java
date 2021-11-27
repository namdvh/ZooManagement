package animalpkg;

public class FLA extends Animal {
    static boolean canGrowl;
    static boolean danger;
    public FLA(){
        super();
        canGrowl=true;
        danger=true;
    }
    public FLA(String id,String name,AnimalTypes type,String color,double weight,boolean canGrowl,boolean danger){
        super(id,name,type,color,weight);
        this.canGrowl=canGrowl;
        this.danger=danger;
    }

    public static boolean isCanGrowl() {
        return canGrowl;
    }

    public static void setCanGrowl(boolean canGrowl) {
        FLA.canGrowl = canGrowl;
    }

//    @Override
//    public String toString() {
//        return "FLA{" +
//                "type=" + type +
//                '}';
//    }

    @Override
    public String toString() {
        return "FLA{" +super.toString()+"canGrowl="+canGrowl+"danger"+danger+"}\n";
    }

    @Override
    public String strtoFile() {
        return super.strtoFile()+";"+canGrowl+";"+danger;

    }
}
