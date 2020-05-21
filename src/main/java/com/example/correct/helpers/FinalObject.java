package com.example.correct.helpers;

import com.example.correct.objects.FinalReturnObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FinalObject {
    public FinalReturnObject createFinalObject(List<String> rightWords, List<String> wrongWords, long time) {
        FinalReturnObject finalReturnObject = new FinalReturnObject();
        StringBuffer strb = new StringBuffer();
        String rightWord,wrongWord;
        try {
            for (int i = 0; i < rightWords.size(); i++) {
                rightWord = rightWords.get(i);
                wrongWord = wrongWords.get(i);
                if (!rightWord.equals(wrongWord)) {
                    finalReturnObject.mistakes.add(wrongWord);
                    finalReturnObject.correctedWords.add(rightWord);
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }

        for(String s: rightWords){
            strb.append(s += " ");
        }
        finalReturnObject.text = strb.toString();
        finalReturnObject.totalWordsCount = rightWords.size();
        finalReturnObject.wrongWordsCount = finalReturnObject.mistakes.size();
        finalReturnObject.time =
                TimeUnit.MILLISECONDS.toHours(time) + ":" +
                TimeUnit.MILLISECONDS.toMinutes(time) + ":" +
                TimeUnit.MILLISECONDS.toSeconds(time);
        return finalReturnObject;
    }
}
