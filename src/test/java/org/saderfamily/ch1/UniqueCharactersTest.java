package org.saderfamily.ch1;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class UniqueCharactersTest {

    @Test(dataProvider = "uniqueStrings")
    public void all_unique_characters(String s, String empty) {
        assertTrue(new UniqueCharacters().isUnique(s));
    }

    @Test(dataProvider = "duplicateCharacters")
    public void duplicated_characters(String s, String empty) {
        assertFalse(new UniqueCharacters().isUnique(s));
    }

    @DataProvider(name = "uniqueStrings")
    public Object[][] uniqueStrings() {
        return new Object[][]{
                {"abcde", ""},
                {"Janet", ""},
                {"Keith", ""}
        };
    }

    @DataProvider(name = "duplicateCharacters")
    public Object[][] duplicateCharacters() {
        return new Object[][]{
                {"xyzzy", ""},
                {"AAbbcc", ""},
                {"  ", ""},
                {"The quick brown fox jumped over the Lazy Dog", ""}
        };
    }
}
