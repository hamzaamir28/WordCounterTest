package com.wordcounter.ms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WordCounterTest {

    private Translator translator;
    
    @Test
    private void test_for_valid_word(){
        WordCounter wordCounter = new WordCounter();
        assertEquals(true, wordCounter.validateWord("sample"));
        assertEquals(false, wordCounter.validateWord("fh7anid"));
        assertEquals(true, wordCounter.validateWord("Alpha"));
        assertEquals(true, wordCounter.validateWord("WORD"));
        assertEquals(false, wordCounter.validateWord("fh!!!id"));
    }

    @Test
    private void test_for_add_word(){
        translator = Mockito.mock(Translator.class);
        WordCounter wordCounter = new WordCounter();

        Mockito.when(translator.translate("flower")).thenReturn("flower");
        Mockito.when(translator.translate("flor")).thenReturn("flower");
        Mockito.when(translator.translate("blume")).thenReturn("flower");
        
        wordCounter.addWord("flower");
        wordCounter.addWord("flor");
        wordCounter.addWord("blume");

        assertEquals(3, wordCounter.countWord("flower"));
    }

    @Test
    private void test_for_count_word() throws Exception{
        WordCounter wordCounter = new WordCounter();
        wordCounter.addWord("word");
        wordCounter.addWord("!!!!!");
        assertEquals(1, wordCounter.countWord("word"));
    }
}
