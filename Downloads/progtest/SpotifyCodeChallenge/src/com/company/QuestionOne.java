package com.company;

import java.util.HashMap;
import java.util.Map;

public class QuestionOne {

    public static void main(String[] args) {
        System.out.println(sortByStrings("weather", "therapyw"));
        System.out.println(sortByStrings("good", "odg"));

    }

    public static StringBuilder sortByStrings(String s, String t){
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < t.length(); i++){
            for(int j = 0; j < s.length(); j++ ){
                if(t.charAt(i) == s.charAt(j)){
                    output.append(t.charAt(i));
                }
            }
        }

        return output;
    }

}
