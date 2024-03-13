package org.paccy.bookshop.DAO;


import org.paccy.bookshop.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection=connection;
    }

    public List<Book> getBookLIst(){
        List<Book> bookList = new ArrayList<>();
        String query= "SELECT * FROM books";

        try (PreparedStatement ps=connection.prepareStatement(query);
             ResultSet resultSet= ps.executeQuery()
        ) {
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name= resultSet.getString("name");
                String author=resultSet.getString("author");
                String year_of_publication=resultSet.getString("year_of_publication");
                String category= resultSet.getString("category");

                bookList.add(new Book(id,name,author,year_of_publication,category));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bookList;
    }

    public void addNewBook(Book book) throws SQLException {
        String query ="INSERT INTO books(name,author,year_of_publication,category) VALUES(?,?,?,?)";

        try(PreparedStatement ps= connection.prepareStatement(query)){
         ps.setString( 1,book.getName());
          ps.setString(2, book.getAuthor());
          ps.setString(3, book.getYear_of_publication());
          ps.setString(4, book.getCategory());

          ps.executeUpdate();

    }


}

public boolean deleteBook (int id ) throws SQLException {
    String query= "DELETE FROM books WHERE id=?";

    boolean rowDeleted;
    try (PreparedStatement preparedStatement=connection.prepareStatement(query);
    ){
        preparedStatement.setInt(1,id);
        rowDeleted=preparedStatement.executeUpdate()>0;
    }
    return rowDeleted;

}



}

