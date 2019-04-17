package fr.isilis.infra.repository;

import fr.isilis.business.model.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ActorDataRepository implements NamedDataRepository {

    @Override
    public String getName() {
        return "Actors";
    }

    @Override
    public List<Data> findAll() {
        return Stream.of(
                new Data("Jean-Paul", "Belmondo"),
                new Data("Alain", "Delon"),
                new Data("Catherine", "Deneuve")
        ).collect(Collectors.toList());
    }
}
