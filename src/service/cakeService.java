package service;

import dao.cakeDAO;
import model.cake;

import java.util.List;

public class cakeService {

    private cakeDAO cakeDAO;

    public cakeService() {
        cakeDAO = new cakeDAO();
    }

    // Add Cake
    public boolean addCake(String name, String flavor, double price) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Cake name cannot be empty.");
            return false;
        }

        if (flavor == null || flavor.trim().isEmpty()) {
            System.out.println("Cake flavor cannot be empty.");
            return false;
        }

        if (price <= 0) {
            System.out.println("Invalid cake price.");
            return false;
        }

        cake cake = new cake();

        cake.setName(name);
        cake.setFlavor(flavor);
        cake.setPrice(price);
        cake.setActive(true);

        return cakeDAO.addCake(cake);
    }

    // Update Cake Name
    public boolean updateCakeName(int cakeId, String newName) {

        if (cakeId <= 0) {
            System.out.println("Invalid cake ID.");
            return false;
        }

        if (newName == null || newName.trim().isEmpty()) {
            System.out.println("Invalid cake name.");
            return false;
        }

        return cakeDAO.updateCakeName(cakeId, newName);
    }

    // Update Cake Flavor
    public boolean updateCakeFlavor(int cakeId, String newFlavor) {

        if (cakeId <= 0) {
            System.out.println("Invalid cake ID.");
            return false;
        }

        if (newFlavor == null || newFlavor.trim().isEmpty()) {
            System.out.println("Invalid flavor.");
            return false;
        }

        return cakeDAO.updateCakeFlavor(cakeId, newFlavor);
    }

    // Update Cake Price
    public boolean updateCakePrice(int cakeId, double newPrice) {

        if (cakeId <= 0) {
            System.out.println("Invalid cake ID.");
            return false;
        }

        if (newPrice <= 0) {
            System.out.println("Invalid price.");
            return false;
        }

        return cakeDAO.updateCakePrice(cakeId, newPrice);
    }

    // Get Cake By ID
    public cake getCakeById(int cakeId) {

        if (cakeId <= 0) {
            System.out.println("Invalid cake ID.");
            return null;
        }

        return cakeDAO.getCakeById(cakeId);
    }

    // Display Single Cake
    public void displayCake(int cakeId) {

        cake cake = getCakeById(cakeId);

        if (cake != null) {

            System.out.println("Cake ID : " + cake.getCakeId());
            System.out.println("Name    : " + cake.getName());
            System.out.println("Flavor  : " + cake.getFlavor());
            System.out.println("Price   : " + cake.getPrice());
            System.out.println("Active  : " + cake.isActive());

        } else {

            System.out.println("Cake not found.");
        }
    }

    // Get All Cakes
    public List<cake> getAllCakes() {

        return cakeDAO.getAllCakes();
    }

    // Display All Cakes
    public void displayAllCakes() {

        List<cake> cakeList = cakeDAO.getAllCakes();

        if (cakeList.isEmpty()) {

            System.out.println("No cakes available.");

        } else {

            for (cake cake : cakeList) {

                System.out.println("------------------------");
                System.out.println("Cake ID : " + cake.getCakeId());
                System.out.println("Name    : " + cake.getName());
                System.out.println("Flavor  : " + cake.getFlavor());
                System.out.println("Price   : " + cake.getPrice());
                System.out.println("Active  : " + cake.isActive());
            }
        }
    }

    // Deactivate Cake
    public boolean deactivateCake(int cakeId) {

        if (cakeId <= 0) {

            System.out.println("Invalid cake ID.");
            return false;
        }

        return cakeDAO.deactivateCake(cakeId);
    }
}