package dao;

import model.cake;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cakeDAO {

    // Add Cake
    public boolean addCake(cake cake) {

        String query = "INSERT INTO cakes(name, flavor, price, isActive) VALUES(?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement p = connection.prepareStatement(query)) {

            p.setString(1, cake.getName());
            p.setString(2, cake.getFlavor());
            p.setDouble(3, cake.getPrice());
            p.setBoolean(4, cake.isActive());

            int rows = p.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error while adding cake: " + e.getMessage());
        }

        return false;
    }

    // Update Cake Name
    public boolean updateCakeName(int cakeId, String newName) {

        String query = "UPDATE Cakes SET name = ? WHERE cakeId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement p = connection.prepareStatement(query)) {

            p.setString(1, newName);
            p.setInt(2, cakeId);

            int rows = p.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error while updating cake name: " + e.getMessage());
        }

        return false;
    }

    // Update Cake Flavor
    public boolean updateCakeFlavor(int cakeId, String newFlavor) {

        String query = "UPDATE Cakes SET flavor = ? WHERE cakeId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement p = connection.prepareStatement(query)) {

            p.setString(1, newFlavor);
            p.setInt(2, cakeId);

            int rows = p.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error while updating cake flavor: " + e.getMessage());
        }

        return false;
    }

    // Update Cake Price
    public boolean updateCakePrice(int cakeId, double newPrice) {

        String query = "UPDATE Cakes SET price = ? WHERE cakeId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement p = connection.prepareStatement(query)) {

            p.setDouble(1, newPrice);
            p.setInt(2, cakeId);

            int rows = p.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error while updating cake price: " + e.getMessage());
        }

        return false;
    }

    // Get Cake By ID
    public cake getCakeById(int cakeId) {

        String query = "SELECT * FROM cakes WHERE cakeId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement p = connection.prepareStatement(query)) {

            p.setInt(1, cakeId);

            ResultSet resultSet = p.executeQuery();

            if (resultSet.next()) {

                cake cake = new cake();

                cake.setCakeId(resultSet.getInt("cakeId"));
                cake.setName(resultSet.getString("name"));
                cake.setFlavor(resultSet.getString("flavor"));
                cake.setPrice(resultSet.getDouble("price"));
                cake.setActive(resultSet.getBoolean("isActive"));

                return cake;
            }

        } catch (SQLException e) {
            System.out.println("Error while fetching cake: " + e.getMessage());
        }

        return null;
    }

    // Get All Cakes
    public List<cake> getAllCakes() {

        List<cake> cakeList = new ArrayList<>();

        String query = "SELECT * FROM cakes";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement p = connection.prepareStatement(query);
             ResultSet resultSet = p.executeQuery()) {

            while (resultSet.next()) {

                cake cake = new cake();

                cake.setCakeId(resultSet.getInt("cakeId"));
                cake.setName(resultSet.getString("name"));
                cake.setFlavor(resultSet.getString("flavor"));
                cake.setPrice(resultSet.getDouble("price"));
                cake.setActive(resultSet.getBoolean("isActive"));

                cakeList.add(cake);
            }

        } catch (SQLException e) {
            System.out.println("Error while fetching cakes: " + e.getMessage());
        }

        return cakeList;
    }

    // Deactivate Cake
    public boolean deactivateCake(int cakeId) {

        String query = "UPDATE cakes SET isActive = false WHERE cakeId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement p = connection.prepareStatement(query)) {

            p.setInt(1, cakeId);

            int rows = p.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error while deactivating cake: " + e.getMessage());
        }

        return false;
    }
}