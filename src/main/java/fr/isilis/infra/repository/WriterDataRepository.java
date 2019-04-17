package fr.isilis.infra.repository;

import fr.isilis.business.model.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class WriterDataRepository implements NamedDataRepository {

    @Override
    public String getName() {
        return "Writers";
    }

    @Override
    public List<Data> findAll() {
        return Stream.of(
                new Data("Emile", "Zola"),
                new Data("Victor", "Hugo"),
                new Data("Gustave", "Flaubert")
        ).collect(Collectors.toList());
    }
}
