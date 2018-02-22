package com.learning.annotation.validators.fieldValidators;


import java.util.Date;

/**
 * Created by santoshk on 2/15/18.
 */
public class DOBValidator{




    public boolean isValid(Date date) {

        if(date.before(new Date()))
            return true;

        return false;

    }
}
