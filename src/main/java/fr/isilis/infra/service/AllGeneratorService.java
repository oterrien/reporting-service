package fr.isilis.infra.service;

import fr.isilis.business.api.GeneratorService;
import fr.isilis.business.business.GeneratorServiceImpl;
import fr.isilis.business.model.CSVDataSet;
import fr.isilis.business.spi.SenderService;
import fr.isilis.infra.repository.NamedDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AllGeneratorService implements GeneratorService {

    private final List<GeneratorService> generatorService;

    private final SenderServiceAdapter senderAdapter;

    @Autowired
    public AllGeneratorService(List<NamedDataRepository> dataRepository, MailSenderService senderService) {

        this.senderAdapter = new SenderServiceAdapter(senderService);
        this.generatorService = dataRepository
                .parallelStream()
                .map(p -> new GeneratorServiceImpl(p.getName(), p, senderAdapter))
                .collect(Collectors.toList());
    }

    @Override
    public void generate() {
        generatorService
                .parallelStream()
                .forEach(p -> p.generate());
        this.senderAdapter.sendAll();
    }

    @RequiredArgsConstructor
    public static class SenderServiceAdapter implements SenderService {

        private final MailSenderService senderService;

        private final List<CSVDataSet> csvDataSetList = new ArrayList<>();

        @Override
        public synchronized void send(CSVDataSet dataSet) {
            csvDataSetList.add(dataSet);
        }

        private void sendAll() {
            log.info("Zip all");
            senderService.send(csvDataSetList.stream().map(p -> p.toString()).collect(Collectors.joining()).getBytes()); // MOCK
        }
    }
}
