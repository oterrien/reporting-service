package fr.isilis.business.spi;

import fr.isilis.business.model.Data;

import java.util.List;

public interface DataRepository {

    List<Data> findAll();
}
