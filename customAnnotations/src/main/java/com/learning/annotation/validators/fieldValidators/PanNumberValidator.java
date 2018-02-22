package com.learning.annotation.validators.fieldValidators;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by santoshk on 2/20/18.
 */
public class PanNumberValidator{


    public boolean isValid(String panNumber) {



        if (panNumber.length() != 10) {
            return false;
        }


        Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
        Matcher matcher = pattern.matcher(panNumber);
        if (matcher.matches()) {
            return true;
        }
        return false;



    }

    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException {
        System.out.print(this.isValid("ABb2736365"));


    }

}
