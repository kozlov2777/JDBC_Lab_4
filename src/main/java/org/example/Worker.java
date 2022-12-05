package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Worker {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public Worker() {
        DB db = new DB();
        this.connection = db.getConnection();
    }

    public Product get( int id){
        String select = "select * from product where id=?";

        try {
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt(3);
                int id_internet_shop = resultSet.getInt(4);

                return new Product(id, name, price, id_internet_shop);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new Product();

    }
    public void save(Product o) {

        String insert ="insert into product(name,price,id_internet_shop) " +
                "values(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,o.getName());
            preparedStatement.setInt(2, o.getPrice());
            preparedStatement.setInt(3,o.getId_internet_shop());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(Product product, int id) {

        String update ="UPDATE product SET name=?, price=?, id_internet_shop=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getId_internet_shop());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteById(int id) {

        String delete ="delete from product where id=?";
        try {
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
