package com.QuizApplication.Utilites;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class StringUtility
{
    //This method used to Capitalize The String for Example SAID will be converted to Said
    public static String capitalizeWord(String word)
    {
        /*
            Let's Suppose That I got user Input jAVA
             j it will be converted to upper
             AVA it will be converted lower
             so the final result Java
        */

        word = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        return word;
    }
}
