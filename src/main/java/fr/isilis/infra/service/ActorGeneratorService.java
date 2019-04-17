package fr.isilis.infra.service;

import fr.isilis.business.api.GeneratorService;
import fr.isilis.business.business.GeneratorServiceImpl;
import fr.isilis.infra.repository.ActorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorGeneratorService implements GeneratorService {

    private final GeneratorService generatorService;

    @Autowired
    public ActorGeneratorService(ActorDataRepository actorDataRepository,
                                 ZipAndMailSenderService senderService) {

        this.generatorService = new GeneratorServiceImpl(actorDataRepository.getName(), actorDataRepository, senderService);
    }

    @Override
    public void generate() {
        this.generatorService.generate();
    }
}
