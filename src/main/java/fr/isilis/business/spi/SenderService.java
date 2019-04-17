package fr.isilis.business.spi;

import fr.isilis.business.model.CSVDataSet;

public interface SenderService {

    void send(CSVDataSet data);
}
