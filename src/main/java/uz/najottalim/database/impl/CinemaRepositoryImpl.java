package uz.najottalim.database.impl;

import uz.najottalim.DatabaseCon;
import uz.najottalim.database.EntityRepository;
import uz.najottalim.model.Cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CinemaRepositoryImpl implements EntityRepository<Cinema, Long> {
    private final DatabaseCon databaseCon = DatabaseCon.getInstance();

    @Override
    public List<Cinema> findAll() {
        Connection connect = databaseCon.connect();
        List<Cinema> cinemas = new ArrayList<>();
        try {
            String query = "select * from cinema";
            PreparedStatement ps = connect.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                cinemas.add(new Cinema(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("director"),
                        resultSet.getString("producer"),
                        LocalTime.ofSecondOfDay(resultSet.getLong("duration")),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getLong("budget")
                ));
            }
            resultSet.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cinemas;
    }

    @Override
    public Optional<Cinema> findById(Long id) {
        Connection connect = databaseCon.connect();
        Optional<Cinema> optionalActor = Optional.empty();
        try {
            PreparedStatement ps = connect.prepareStatement("select * from cinema where id = ?");
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                optionalActor = Optional.of(new Cinema(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("director"),
                        resultSet.getString("producer"),
                        LocalTime.ofSecondOfDay(resultSet.getLong("duration")),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getLong("budget")));
            }
            resultSet.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return optionalActor;
    }
}
