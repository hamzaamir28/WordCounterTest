package com.wordcounter.ms;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/words")
public class WordCounterController {
    private final WordCounter wordCounter = new WordCounter();

   @PostMapping
    public void addWords(@RequestBody List<String> words) {
        for(String word : words){
            wordCounter.addWord(word);
        }
    }

    @GetMapping("/count")
    public int getWordCount(@RequestParam String word) {
        return wordCounter.countWord(word);
    }
}
