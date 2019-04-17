package fr.isilis.infra.service;

import fr.isilis.business.model.CSVDataSet;
import fr.isilis.business.spi.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailSenderService implements SenderService {

    @Override
    public void send(CSVDataSet dataSet) {
        send(dataSet.toString().getBytes()); // MOCK
    }

    public void send(byte[] mail) {
        log.info("Send by mail"); // MOCK
    }
}
