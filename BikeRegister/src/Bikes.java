public class Bikes extends Register{

    //I named the class User and not 'UserScore' because it made more sense to me to name it this.

    private String Name;
    private String BrandName;
    private String Component;
    private double Weight;
    private double Price;

    public Bikes(){
    }


    public Bikes(String Name, String BrandName, String Component, double Weight, double Price) {
        this.Name = Name;
        this.BrandName = BrandName;
        this.Component = Component;
        this.Weight = Weight;
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getComponent() {
        return Component;
    }

    public void setComponent(String component) {
        Component = component;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    //The way my program ended up it makes sense that an object of type User also has a topic, in my original plan for this program it did not
    //as an object of type User was meant to be able to have more than just one topic, oh well, it's a shame I could not get this to work the way I'd like it to



    //Getters and setters

}