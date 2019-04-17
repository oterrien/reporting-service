package fr.isilis.infra.repository;

import fr.isilis.business.model.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class SingerDataRepository implements NamedDataRepository {

    @Override
    public String getName() {
        return "Singers";
    }

    @Override
    public List<Data> findAll() {
        return Stream.of(
                new Data("Claude", "Nougaro"),
                new Data("Charles", "Aznavour"),
                new Data("Edith", "Piaf")
        ).collect(Collectors.toList());
    }
}
