package com.learning.annotation.validators.fieldValidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by santoshk on 2/21/18.
 */
public class MobileNumberValidator {


    public boolean isValid(String mobile){
        if(!(mobile.length()==10)){
            return false;

        }


        Pattern pattern = Pattern.compile("[1-9][0-9]{9}");
        Matcher matcher = pattern.matcher(mobile);
        if (matcher.matches()) {
            return true;
        }else{
            return false;
        }
    }
}
