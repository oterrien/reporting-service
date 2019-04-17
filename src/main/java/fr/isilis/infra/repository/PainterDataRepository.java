package fr.isilis.infra.repository;

import fr.isilis.business.model.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class PainterDataRepository implements NamedDataRepository {

    @Override
    public String getName() {
        return "Painters";
    }

    @Override
    public List<Data> findAll() {
        return Stream.of(
                new Data("Claude", "Monet"),
                new Data("Pablo", "Picasso"),
                new Data("Eugène", "Delacroix")
        ).collect(Collectors.toList());
    }
}
