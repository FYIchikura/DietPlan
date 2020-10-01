package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DietPlan {//mvn clean install

    public String getDinner(String dietString, String breakfastString, String lunchString) {
        char diet[] = this.sortString(dietString);
        List<Character> breakfast = this.stringToList(breakfastString);
        List<Character> lunch = this.stringToList(lunchString);
        List<Character> dinner = new ArrayList<Character>();

        Character breakfastEaten = null;
        Character lunchEaten = null;
        for (int i = 0; i < diet.length; i++) {

            if(this.listContainsChar(breakfast, diet[i])) {
                breakfastEaten = diet[i];
                diet[i] = ' ';
            }
            breakfast = this.removeChar(breakfast, breakfastEaten);
            breakfastEaten = null;

            if (diet[i] != ' ' && this.listContainsChar(lunch, diet[i])) {
                lunchEaten = diet[i];
                diet[i] = ' ';
            }
            lunch = this.removeChar(lunch, lunchEaten);
            lunchEaten = null;

            if (diet[i] != ' ') {
                dinner.add(diet[i]);
            }
        }

        if(breakfast.isEmpty() && lunch.isEmpty()) {
            return this.concatCharsIntoString(dinner);
        } else {
            return "CHEATER";
        }
    }

    public char[] sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return tempArray;
    }

    public List<Character> stringToList(String inputString) {
        List<Character> list = new ArrayList<Character>();
        for(Character c: inputString.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    public String concatCharsIntoString(List<Character> inputList) {
        StringBuilder finalString = new StringBuilder();
        for(Character c: inputList) {
            if(!c.equals(' ')) {
                finalString.append(c);
            }
        }
        return finalString.toString();
    }

    public Boolean listContainsChar(List<Character> listInput, Character charInput) {
        for (char c: listInput) {
            if(charInput == c) {
                return true;
            }
        }
        return false;
    }

    public List<Character> removeChar(List<Character> listInput, Character character) {
        int idx = listInput.indexOf(character);
        if(idx>-1) {
            listInput.remove(idx);
        }
        return listInput;
    }
}
