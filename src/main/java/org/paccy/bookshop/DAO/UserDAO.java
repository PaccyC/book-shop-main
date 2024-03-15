package org.paccy.bookshop.DAO;

import org.paccy.bookshop.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection=connection;
    }


    public void  addUser(User user) throws SQLException {
        String query= "INSERT INTO users (firstName,lastName,email,password,age,institution) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement statement=connection.prepareStatement(query)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5,user.getAge());
            statement.setString(6,user.getInstitution());

            statement.executeUpdate();
        }

    }
    //    Retrieving all customers from the database
    public List<User> getAllUsers() throws SQLException {

        List<User> users= new ArrayList<>();
        String query="SELECT * FROM users";
        try (PreparedStatement statement=connection.prepareStatement(query);
             ResultSet resultSet=statement.executeQuery()
        ){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String firstName= resultSet.getString("firstName");
                String lastName=resultSet.getString("lastName");
                String email=resultSet.getString("email");
                String password= resultSet.getString("password");
                int age=resultSet.getInt("age");
                String institution=resultSet.getString("institution");

                users.add(new User(id,firstName,lastName,email,password,age,institution));
            }
        }

        return users;
    }

    public User getUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String firstName= resultSet.getString("firstName");
                    String lastName=resultSet.getString("lastName");
                     email=resultSet.getString("email");
                    String password= resultSet.getString("password");
                    int age=resultSet.getInt("age");
                    String institution=resultSet.getString("institution");
                    return new User(firstName,lastName, email,password, age, institution);
                } else {

                    return null;
                }
            }
        }
    }
}
