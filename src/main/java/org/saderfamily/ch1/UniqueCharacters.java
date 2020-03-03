package org.saderfamily.ch1;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {
    // The exercise in the book doesn't specify case sensitivity. IMO T = t for purposes of duplicate characters
    public boolean isUnique(String potentialUnique) {
        if(null == potentialUnique || potentialUnique.isEmpty()) {
            return true;
        }
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

    public boolean isUniqueNoExtraStorage(String potentialUnique) {
        if(null == potentialUnique || potentialUnique.isEmpty()) {
            return true;
        }
        boolean allUnique = true;
        // Cheating a bit on this problem to meet the specs of the previous method
        String potentialUniqueLower = potentialUnique.toLowerCase();
        for(int i = 0; i < potentialUniqueLower.length() - 1; ++i) {
            for(int j = i + 1; j < potentialUniqueLower.length(); ++j ) {
                if(potentialUniqueLower.charAt(i) == potentialUniqueLower.charAt(j) ) {
                    allUnique = false;
                    break;
                }
            }
        }
        return allUnique;
    }
}
