package com.IngSW.content_moderation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IngSW.content_moderation.models.Word;
import com.IngSW.content_moderation.repositories.wordRepository;

import java.util.List;

@Service
public class ModerationService {

    @Autowired
    private wordRepository wordRepository;

    /* Metodo che ritorna tutte le righe della tabella word nel db */
    public List<Word> getAll() {
        return wordRepository.findAll();
    }

    /*
     * Metodo che controlla se il testo che gi viene passato contiene o meno le
     * parole inappropriate presenti nel database e restituisce un booleano
     */
    public boolean isContentAppropriate(String text) {
        List<Word> inappropriateWords = wordRepository.findAll();
        int i = 0;
        boolean isAppropriate = false;
        for (i = 0; i < inappropriateWords.size() && isAppropriate == false; i++) {
            isAppropriate = text.toLowerCase().contains(inappropriateWords.get(i).getWord());
        }

        return isAppropriate;
    }
}
