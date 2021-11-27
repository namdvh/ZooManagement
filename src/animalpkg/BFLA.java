package animalpkg;

public class BFLA extends Animal{
    static boolean cute;
    public BFLA(){
        super();
        cute=true;
    }
    public BFLA(String id,String name,AnimalTypes type,String color,double weight,boolean cute){
        super(id,name,type,color,weight);
        this.cute=cute;
    }

    public static boolean isCute() {
        return cute;
    }

    public static void setCute(boolean cute) {
        BFLA.cute = cute;
    }

    @Override
    public String toString() {
        return "BFLA{" +super.toString()+"cute="+cute+"}\n";
    }

    @Override
    public String strtoFile() {
        return super.strtoFile()+";"+cute;

    }
}
