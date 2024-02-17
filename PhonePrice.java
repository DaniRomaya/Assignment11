public class PhonePrice implements Comparable<PhonePrice>{
    private String name;
    private int price;

    public PhonePrice(int price){
        this.price = price;
    }

    public PhonePrice(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return "Price: " + price;
    }

    @Override
    public int compareTo(PhonePrice o) {
        return this.price - o.price;
    }

    public void setName(String name){
        this.name= name;
    }
    
    public int getPrice(){
        return price;
    }

    public void getPrice(int price){
        this.price = price;
    }
}
