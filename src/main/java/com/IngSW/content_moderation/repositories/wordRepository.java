package com.IngSW.content_moderation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.IngSW.content_moderation.models.Word;

/* Classe che definisce il repository (database)  */
public interface wordRepository extends JpaRepository<Word, Long>{

}
