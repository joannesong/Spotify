package com.company;

import java.util.ArrayList;
import java.util.List;

public class QuestionThree {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        System.out.println(changePossiblities(4, arr));
    }

    public static int changePossiblities(int amount, int[] coins) {
        List<Integer> coinArr = new ArrayList<>();
        coinArr.add(1);
        for(int i = 0; i < amount; i++) {
            coinArr.add(0);
        }
        for (int j = 0; j < coins.length; j++){
            for(int k = 1; k < coinArr.size(); k++){
                if(k >= coins[j]){
                    int sum = coinArr.get(k) + coinArr.get(k - coins[j]);
                    coinArr.set(k,sum);
                }
            }
        }
        return coinArr.get(amount);
    }

}











