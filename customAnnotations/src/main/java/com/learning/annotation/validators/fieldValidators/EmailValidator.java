package com.learning.annotation.validators.fieldValidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by santoshk on 2/21/18.
 */
public class EmailValidator {


    public boolean isValid(String email){


        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\n" +
                "      @[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$;");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }else{
            return false;
        }


    }
}
