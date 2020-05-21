package com.example.correct.helpers;

import com.example.correct.database.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class ArraySelector{
    public static List<Dictionary> selectFromArrayByFirstLetter(List<Dictionary> dictionary, String word) {
        List<Dictionary> selectedDic = new ArrayList<>();

        System.out.println("Filling the selected dictionary.\n");
        for (com.example.correct.database.Dictionary x : dictionary) {
            try {
                if (x.getWord().startsWith(String.valueOf(word.charAt(0)))
                        || x.getWord().endsWith(String.valueOf(word.charAt(word.length() - 1)))) {
                    System.out.println("Adding word " + x.getWord());
                    selectedDic.add(x);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("!!!!!!!IndexOutOfBoundsException!!!!!!!");
            }
        }
        return selectedDic;
    }
}
