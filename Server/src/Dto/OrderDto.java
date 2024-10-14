package Dto;

import DatabaseConnection.DBConnection;
import Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDto {

    // Thêm đơn hàng mới vào cơ sở dữ liệu
    public static void addOrder(Order order) throws SQLException {
        String query = "INSERT INTO Orders (accountId, totalPrice) VALUES (?, ?)";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, order.getOrderId());
            statement.setDouble(2, order.getTotalCost());

            statement.executeUpdate();
        }
    }

    // Thêm chi tiết đơn hàng vào cơ sở dữ liệu
    public static void addOrderItem(int orderId, int menuItemId, int quantity) throws SQLException {
        String query = "INSERT INTO OrderItems (orderId, menuItemId, quantity) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            statement.setInt(2, menuItemId);
            statement.setInt(3, quantity);

            statement.executeUpdate();
        }
    }
}
