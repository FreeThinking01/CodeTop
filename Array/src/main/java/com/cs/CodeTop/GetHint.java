package com.cs.CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-11-08 10:42
 * @description: 猜数字游戏
 **/
public class GetHint {

    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> secretMap = new HashMap();
        HashMap<Character, Integer> guessMap = new HashMap();
        int n = secret.length();
        int Bulls = 0, Cows = 0;
        for(int i = 0; i < n; i++){
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);
            if(secretChar == guessChar){
                Bulls++;
            }else{
                secretMap.put(secretChar, secretMap.getOrDefault(secretChar, 0) + 1);
                guessMap.put(guessChar, guessMap.getOrDefault(guessChar, 0) + 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : secretMap.entrySet()){
            if(guessMap.containsKey(entry.getKey())){
                Cows += guessMap.get(entry.getKey()) <= entry.getValue() ? guessMap.get(entry.getKey()) : entry.getValue();
            }
        }

        return String.valueOf(Bulls) + "A" + String.valueOf(Cows) + "B";

    }
}
