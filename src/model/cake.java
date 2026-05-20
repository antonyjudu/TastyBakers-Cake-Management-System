package model;

public class cake {
    private int cakeId;
    private String name;
    private String flavor;
    private double price;
    private boolean isActive;
    
    public cake() {
    	
    }
    
    public cake(int cakeId, String name, String flavor, double price, boolean isActive) {
        this.cakeId = cakeId;
        this.name = name;
        this.flavor = flavor;
        this.price = price;
        this.isActive = isActive;
    }

    public int getCakeId() {
        return cakeId;
    }
    public void setCakeId(int cakeId) {
        this.cakeId = cakeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
}