package com.learning.annotation.validators.fieldValidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by santoshk on 2/16/18.
 */
public class NameValidator{





    public boolean isValid(String name) {

        if(name!=null && name.isEmpty()){
            return false;
        }

        Pattern pattern = Pattern.compile("[A-Za-z]*");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }


}
