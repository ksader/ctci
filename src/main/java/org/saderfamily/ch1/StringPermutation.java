package org.saderfamily.ch1;

import java.util.Arrays;

public class StringPermutation {
    public boolean isPermutation(String potentialPerm, String source) {
        if(potentialPerm.length() != source.length()) {
            return false;
        }

        char potentialPermChars[] = potentialPerm.toCharArray();
        Arrays.sort(potentialPermChars);
        char sourceChars[] = source.toCharArray();
        Arrays.sort(sourceChars);
        boolean permutation = true;
        for(int i = 0; i < potentialPerm.length(); ++i) {
            if(potentialPermChars[i] != sourceChars[i]) {
                permutation = false;
                break;
            }
        }
        return permutation;
    }
}
