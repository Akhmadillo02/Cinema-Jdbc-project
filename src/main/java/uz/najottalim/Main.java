package uz.najottalim;

import uz.najottalim.database.impl.ActorRepositoryImpl;
import uz.najottalim.database.impl.CinemaRepositoryImpl;
import uz.najottalim.model.Actor;

import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        ActorRepositoryImpl actorRepository = new ActorRepositoryImpl();
        Optional<Actor> actor = actorRepository.findById(201L);
        if (actor.isPresent()) {
            System.out.println(actor);
        } else {
            System.out.println("Not found!");
        }
        CinemaRepositoryImpl cinemaRepository = new CinemaRepositoryImpl();
        System.out.println(cinemaRepository.findAll());
    }
}