package tech.chilo.sa.service;

import org.springframework.stereotype.Service;
import tech.chilo.sa.entities.Client;
import tech.chilo.sa.entities.Sentiment;
import tech.chilo.sa.enums.TypeSentiment;
import tech.chilo.sa.repository.SentimentRepository;

import java.util.List;

@Service
public class SentimentService {
    private SentimentRepository sentimentRepository;
    private ClientService clientService;

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    public  void creer(Sentiment sentiment){
        Client client = clientService.LireOUCreer(sentiment.getClient());
        sentiment.setClient(client);
        //Analyse

        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else {

             sentiment.setType(TypeSentiment.POSITIF);
        }

        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type == null){

            return this.sentimentRepository.findAll();
        }
        else {
            return this.sentimentRepository.findByType(type);
        }
    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
