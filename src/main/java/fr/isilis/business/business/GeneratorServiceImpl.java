package fr.isilis.business.business;

import fr.isilis.business.api.GeneratorService;
import fr.isilis.business.model.CSVDataSet;
import fr.isilis.business.model.Data;
import fr.isilis.business.spi.DataRepository;
import fr.isilis.business.spi.SenderService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GeneratorServiceImpl implements GeneratorService {

    private final String name;

    private final DataRepository repository;

    private final SenderService senderService;

    @Override
    public void generate() {

        List<Data> dataList = repository.findAll();
        CSVDataSet csvDataSet = convert(dataList);
        senderService.send(csvDataSet);
    }

    private CSVDataSet convert(List<Data> dataList) {

        CSVDataSet csvDataSet = new CSVDataSet();
        csvDataSet.setName(this.name);
        csvDataSet.setHeader("name;iban");
        csvDataSet.setRow(dataList.stream().map(p -> p.toCsv()).collect(Collectors.toList()));
        return csvDataSet;
    }
}
