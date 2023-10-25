package uz.najottalim.database.impl;

import uz.najottalim.DatabaseCon;
import uz.najottalim.database.EntityRepository;
import uz.najottalim.model.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorRepositoryImpl implements EntityRepository<Actor, Long> {
    private final DatabaseCon databaseCon = DatabaseCon.getInstance();

    @Override
    public List<Actor> findAll() {
        Connection connect = databaseCon.connect();
        List<Actor> actors = new ArrayList<>();
        try {
            String query = "select * from " + Actor.getTableName();
            PreparedStatement ps = connect.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                actors.add(new Actor(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("birthdate").toLocalDate(),
                        resultSet.getString("gender")
                ));
            }
            resultSet.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    @Override
    public Optional<Actor> findById(Long id) {
        Connection connect = databaseCon.connect();
        Optional<Actor> optionalActor = Optional.empty();
        try {
            PreparedStatement ps = connect.prepareStatement("select * from " + Actor.getTableName() + " where id = ?");
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Actor actor = new Actor(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("birthdate").toLocalDate(),
                        resultSet.getString("gender")
                );
                optionalActor = Optional.of(actor);
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
