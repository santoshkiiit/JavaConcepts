package com.learning.annotation.validators.docValidators;

import com.learning.annotation.implementation.*;
import com.learning.annotation.validators.fieldValidators.*;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.Map;

/**
 * Created by santoshk on 2/21/18.
 */
public class AnnotationsHandler {

    static final String PANINVALID ="Invalid Pan Number";
    static final String MOBILEINVALID ="Invalid Mobile Number";
    static final String EMAILINVALID ="Invalid email address";
    static final String DATEINVALID ="Incorrect DOB";
    static final String NAMEINVALID ="Invalid Name";



    public boolean validateAnnotation(Object obj, Annotation annotation, Map<String,Integer> issuesmap) {

        Class annotationClass = annotation.annotationType().getClass().getDeclaringClass();

        if (annotation instanceof ValidDate) {
            DOBValidator dobValidator = new DOBValidator();

           // return dobValidator.isValid((Date) obj);
            if(!dobValidator.isValid((Date) obj)){
                
                this.updateIssuesMap(issuesmap, DATEINVALID);
                
            }

        }

        if (annotation instanceof ValidName) {

            NameValidator nameValidator = new NameValidator();

           // return nameValidator.isValid((String) obj);
            if(!nameValidator.isValid((String) obj)){
                this.updateIssuesMap(issuesmap, NAMEINVALID);
            }


        }

        if (annotation instanceof ValidPanNumber) {
            PanNumberValidator panNumberValidator = new PanNumberValidator();
           // return panNumberValidator.isValid((String) obj);
            if(!panNumberValidator.isValid((String) obj)){
                this.updateIssuesMap(issuesmap, PANINVALID);

            }

        }


        if (annotation instanceof ValidEmail) {
            EmailValidator emailValidator = new EmailValidator();
            //return emailValidator.isValid((String) obj);
            if(!emailValidator.isValid((String) obj)){
                this.updateIssuesMap(issuesmap, EMAILINVALID);

            }

        }

        if (annotation instanceof ValidMobile) {
            MobileNumberValidator mobileNumberValidator = new MobileNumberValidator();
            if(!mobileNumberValidator.isValid((String) obj)){
                this.updateIssuesMap(issuesmap, MOBILEINVALID);

            }

        }
        return false;

    }

    private void updateIssuesMap( Map<String,Integer> issuesmap, String reason) {

        if(issuesmap.containsKey(reason)){
            issuesmap.put(reason,issuesmap.get(reason)+1);

        }else{
            issuesmap.put(reason,1);

        }
    }

}
