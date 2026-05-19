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
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cake.getName());
            preparedStatement.setString(2, cake.getFlavor());
            preparedStatement.setDouble(3, cake.getPrice());
            preparedStatement.setBoolean(4, cake.isActive());

            int rows = preparedStatement.executeUpdate();

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
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, cakeId);

            int rows = preparedStatement.executeUpdate();

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
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newFlavor);
            preparedStatement.setInt(2, cakeId);

            int rows = preparedStatement.executeUpdate();

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
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, cakeId);

            int rows = preparedStatement.executeUpdate();

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
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, cakeId);

            ResultSet resultSet = preparedStatement.executeQuery();

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
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

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
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, cakeId);

            int rows = preparedStatement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error while deactivating cake: " + e.getMessage());
        }

        return false;
    }
}