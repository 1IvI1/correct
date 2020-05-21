package com.example.correct.correctingFunctions;

import com.example.correct.database.Dictionary;
import com.example.correct.database.repositories.DictionaryRepository;
import com.example.correct.helpers.ArraySelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class WordCheck {
    @Autowired
    private DictionaryRepository dic;

    private List<Dictionary> dictionary;
    private EditDistance editDistance = new EditDistance();


    public String checkWord(String word) {
        dictionary = dic.findAll();
        List<Dictionary> dictionaryStartingOnLetter = new ArrayList<>();
        String wordToReturn = checkWordEqualsToWordFromSelectedDic(word);
        if(wordToReturn == null) {
            wordToReturn = checkWordOnSelectedDictionaryMinEditDistance(word);
        }
        return wordToReturn;
    }

    private String checkWordEqualsToWordFromSelectedDic(String word) {
        System.out.println("\n\n\n Started checking in selected dictionary \n\n\n");
        System.out.println("Got word: " + word);
        List<Dictionary> selectedDic = ArraySelector.selectFromArrayByFirstLetter(dictionary,word);
        String wordToReturn = null;

        if(selectedDic.size() > 0) {
            for(int i = 0; i < selectedDic.size();i++) {
                Dictionary x = selectedDic.get(i);
//                System.out.println("Comparing gotten word " + word + " and " + x.getWord());
                if(x.getWord().equals(word)) {
                    System.out.println("Found word in dictionary: " + word + " " + x.getWord());
                    wordToReturn = x.getWord();
                    break;
                }
            }
        }
        if(wordToReturn == null) System.out.println("\n\nWord is not found in dictionary!!!!!!!!!!!!!!!!!!!!!!!!!");
        return wordToReturn;
    }

    private String checkWordOnSelectedDictionaryMinEditDistance(String word) {
        System.out.println("\n\n\n Starting checking by MIN EDIT DISTANCE in selected dictionary \n\n\n");
        int min = 9999999;
        List<Dictionary> selectedDic = ArraySelector.selectFromArrayByFirstLetter(dictionary,word);
        String wordToReturn = null;

        System.out.println("Selected dictionary size: " + selectedDic.size());

        for(int i = 0; i < selectedDic.size();i++) {
            Dictionary x = selectedDic.get(i);
            System.out.println("Checking " + word + " with x.getWord(): " + x.getWord());
            int tmp = editDistance.editDist(word, x.getWord(), word.length(),x.getWord().length());
            if(tmp < min) {
                min = tmp;
                wordToReturn = x.getWord();
                System.out.println("Possible result: " + x.getWord() + "\nInitial word: " + word + "\nMin edit distance " + tmp);
            }
            if(min == 1) break;
        }

        System.out.println("Selected word: " + wordToReturn);

        return wordToReturn;
    }

}
