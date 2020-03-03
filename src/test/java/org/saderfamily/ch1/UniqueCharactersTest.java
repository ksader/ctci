package org.saderfamily.ch1;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class UniqueCharactersTest {

    @Test
    public void all_unique_characters() {
        assertTrue(new UniqueCharacters().isUnique("abcde"));
    }

    @Test
    public void duplicated_characters() {
        assertFalse(new UniqueCharacters().isUnique("xyzzy"));
    }
}
