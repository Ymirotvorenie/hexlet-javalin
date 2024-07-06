package org.example.hexlet.repository;

import io.javalin.http.NotFoundResponse;
import lombok.Getter;
import org.example.hexlet.model.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepository{

    public static List<User> getEntities() throws SQLException {
        var sql = "SELECT * FROM users";

        try(var connection = dataSource.getConnection();
            var statement = connection.prepareStatement(sql)) {
            var resultSet = statement.executeQuery();
            var result = new ArrayList<User>();

            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(id, name, email, password);
                result.add(user);
            }
            return result;
        }
    }

    public static void save(User user) throws SQLException {
        var sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (var connection = dataSource.getConnection();
             var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong("id"));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static List<User> search (String term) throws SQLException {
        var sql = "SELECT * FROM users WHERE name LIKE \"?%\"";

        try (var connection = dataSource.getConnection();
            var statement = connection.prepareStatement(sql)) {
            statement.setString(1, term);
            var resultSet = statement.executeQuery();
            var result = new ArrayList<User>();

            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                result.add(new User(id, name, email, password));
            }
            return result;
        }
    }

    public static Optional<User> find (Long id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id = ?";

        try (var connection = dataSource.getConnection();
            var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(name, email, password);
                user.setId(id);

                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static void delete(Long id) throws SQLException{
        var sql = "DELETE FROM users WHERE id = ?";

        try (var connection = dataSource.getConnection();
            var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeQuery();
        }
    }
}
