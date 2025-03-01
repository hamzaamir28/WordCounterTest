package com.wordcounter.ms;
import java.util.concurrent.ConcurrentHashMap;

public class WordCounter {
    
    static ConcurrentHashMap<String, Integer> wordCount = new ConcurrentHashMap<>();
    private final Translator translator = new Translator();
    
    public boolean validateWord(String word){
        //if only chars, return true
        return word.matches("[a-zA-Z]+");
    }

    public void addWord(String word){
        //validate the word
        if(!validateWord(word)) return;
        //translate the word into english
        String englishTranslation = translator.translate(word);
        //update the map
        wordCount.put(englishTranslation, wordCount.getOrDefault(englishTranslation, 0) + 1);
    }

    public int countWord(String word){
        //validate the word
        if(!validateWord(word)) return 0;
        //get the english translation of the word
        String englishTranslation = translator.translate(word);
        //return map.get(word)
        return wordCount.get(englishTranslation);
    }

}
