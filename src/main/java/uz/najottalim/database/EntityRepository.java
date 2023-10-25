package uz.najottalim.database;

import java.util.List;
import java.util.Optional;

public interface EntityRepository<E, K> {
    List<E> findAll();

    Optional<E> findById(K id);
}
