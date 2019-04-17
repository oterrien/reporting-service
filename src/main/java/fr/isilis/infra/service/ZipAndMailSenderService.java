package fr.isilis.infra.service;

import fr.isilis.business.model.CSVDataSet;
import fr.isilis.business.spi.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ZipAndMailSenderService implements SenderService {

    public final MailSenderService senderService;

    @Autowired
    public ZipAndMailSenderService(MailSenderService senderService) {
        this.senderService = senderService;
    }

    @Override
    public void send(CSVDataSet dataSet) {
        log.info("Zip");
        this.senderService.send(dataSet.toString().getBytes());//MOCK
    }

}
