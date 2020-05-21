package com.example.correct.controllers;

import com.example.correct.correctingFunctions.WordCheck;
import com.example.correct.helpers.FinalObject;
import com.example.correct.objects.FinalReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(path = "/dictionary")
public class DictionaryController {
    @Autowired
    private WordCheck wordCheck;

    @CrossOrigin
    @PutMapping(path = "/text")
    public @ResponseBody
    FinalReturnObject startChecking(@RequestBody List<String> words) {
        FinalObject fin = new FinalObject();
        Date start = new Date();
        Date finish;
        System.out.println("Start time " + start.toString());

        List<String> toReturn = new ArrayList<>();
        words.forEach(x -> {
            toReturn.add(wordCheck.checkWord(x.toLowerCase()));
        });
        System.out.println("Finished checking -----------------------------------\n\n\n");
        System.out.println("Selected word is: " + toReturn.toString());

        finish  = new Date();
        System.out.println("Was working from " + start.toString() + "  till " + finish.toString());
        return fin.createFinalObject(toReturn,words,finish.getTime() - start.getTime());
    }
}
