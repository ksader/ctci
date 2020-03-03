package org.saderfamily.ch1;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {
    public boolean isUnique(String potentialUnique) {
        boolean allUnique = true;
        Set<Character> uniques = new HashSet<>();
        for(int i = 0; i < potentialUnique.length(); ++i) {
            if(!uniques.contains(potentialUnique.charAt(i))) {
                uniques.add(potentialUnique.charAt(i));
            } else {
                allUnique = false;
                break;
            }
        }
        return allUnique;
    }
}
