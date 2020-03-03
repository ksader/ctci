package org.saderfamily.ch1;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {
    public boolean isUnique(String potentialUnique) {
        boolean allUnique = true;
        Set<Character> uniques = new HashSet<>();
        String potentialUniqueLower = potentialUnique.toLowerCase();
        for(int i = 0; i < potentialUniqueLower.length(); ++i) {
            if(!uniques.contains(potentialUniqueLower.charAt(i))) {
                uniques.add(potentialUniqueLower.charAt(i));
            } else {
                allUnique = false;
                break;
            }
        }
        return allUnique;
    }
}
