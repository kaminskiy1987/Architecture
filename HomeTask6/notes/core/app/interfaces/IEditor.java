package HomeTask6.notes.core.app.interfaces;

import java.util.Collection;
import java.util.Optional;

public interface IEditor<T, TId> {

    boolean add(T item);

    boolean edit(T item);

    boolean remove(T item);

    Optional<T> getById(TId id);

    Collection<T> getAll();
}