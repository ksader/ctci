package org.saderfamily.ch1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StringPermutationTest {

    @Test(dataProvider = "validPermutations")
    public void valid_permutation(String potential, String source) {
        assertTrue(new StringPermutation().isPermutation(potential, source));
    }

    @Test(dataProvider = "invalidPerms")
    public void invalid_permutation(String potentail, String source) {
        assertFalse(new StringPermutation().isPermutation(potentail, source));
    }

    @DataProvider(name = "validPermutations")
    public Object[][] validPermutations() {
        return new Object[][] {
                {"ab", "ba"},
                {"z", "z"},
                {" ", " "},
                {"", ""},
                {"tacocat", "ccaatto"},
                {"tacocat", "cacatot"},
                {"TacoCat", "TCacoat"}

        };
    }

    @DataProvider(name = "invalidPerms")
    public Object[][] invalidPerms() {
        return new Object[][] {
                {"ab", "bc"},
                {"ab", "abba"},
                {"TacoCat", "tacocat"}
        };
    }
}
