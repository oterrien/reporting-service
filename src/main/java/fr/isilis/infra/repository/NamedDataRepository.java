package fr.isilis.infra.repository;

import fr.isilis.business.spi.DataRepository;

public interface NamedDataRepository extends DataRepository {

    String getName();
}
