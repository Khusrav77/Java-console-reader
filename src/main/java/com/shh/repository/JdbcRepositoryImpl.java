package com.shh.repository;

import com.shh.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class JdbcRepositoryImpl implements JdbcRepository<Person>{

    private final Connection connection;

    public JdbcRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Integer create(Person person) {
        String sql = "INSERT INTO person (name, age) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        return Optional.empty();
    }

    @Override
    public Collection<Person> getAll() {
        return List.of();
    }

    @Override
    public void update(Integer id, Person person) {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
