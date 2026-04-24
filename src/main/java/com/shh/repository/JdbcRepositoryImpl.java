package com.shh.repository;

import com.shh.model.Person;
import com.shh.util.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class JdbcRepositoryImpl implements JdbcRepository<Person>{

    private static final String INSERT = "INSERT INTO person (name, age) VALUES (?, ?)";
    private static final String SELECT = "SELECT * FROM person WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM person";
    private static final String UPDATE = "UPDATE person SET name = ?, age = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM person WHERE id = ?";


    @Override
    public Integer create(Person person) {

        try (PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(INSERT)) {
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.executeUpdate();


            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Person> get(Integer id) {
        try(PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(SELECT)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Person(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Collection<Person> getAll() {
        List<Person> list = new ArrayList<>();

        try(PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Integer id, Person person) {

        try(PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setInt(3, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean delete(Integer id) {
        try(PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            ps.setInt(1, id);
           return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
