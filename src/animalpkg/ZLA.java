package animalpkg;

public class ZLA extends Animal{
    public boolean poisonous;
    public ZLA(){
        super();
        poisonous=true;
    }
    public ZLA(String id,String name,AnimalTypes type,String color,double weight,boolean poisonous){
        super(id,name,type,color,weight);
        this.poisonous=poisonous;
    }
    public boolean isPoisonous() {
        return poisonous;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }


    @Override
    public String toString() {
        return "ZLA{" +super.toString()+"poisonous="+poisonous+"}\n";
    }

    @Override
    public String strtoFile() {
        return super.strtoFile()+";"+"poisonous="+poisonous;
    }
}
