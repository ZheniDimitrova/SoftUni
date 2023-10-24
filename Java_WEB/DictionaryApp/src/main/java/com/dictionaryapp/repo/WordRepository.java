package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.entity.enums.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query("select w from Word  as w join w.language as l where l.name = :language")
    List<Word> findAllWordsByLanguage(LanguageEnum language);
}
