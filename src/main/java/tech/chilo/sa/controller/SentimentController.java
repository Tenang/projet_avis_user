package tech.chilo.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.chilo.sa.entities.Client;
import tech.chilo.sa.entities.Sentiment;
import tech.chilo.sa.enums.TypeSentiment;
import tech.chilo.sa.service.SentimentService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment" , produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment){
        this.sentimentService.creer(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentService.rechercher(type);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.sentimentService.supprimer(id);

    }
}
