package com.learning.annotation.validators.docValidators;

import com.learning.annotation.documents.Aadhar;
import com.learning.annotation.documents.BankStatement;
import com.learning.annotation.documents.BaseDocument;
import com.learning.annotation.documents.PanCard;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by santoshk on 2/21/18.
 */
public class DocumentFieldsValidator{

    AnnotationsHandler annotationsHandler = new AnnotationsHandler();



    public void validateDocumentFields(BaseDocument document, Map<String, Integer> issuesMap) throws IllegalAccessException {


        Aadhar aadhar = (Aadhar)document;
        PanCard pancard = aadhar.getPanCard();

        BankStatement bankStatement = aadhar.getBankStatement();

        List<BaseDocument> docs = new ArrayList<>();
        docs.add(aadhar);
        docs.add(pancard);
        docs.add(bankStatement);

        for(BaseDocument doc: docs){

            Field[] fields = doc.getClass().getDeclaredFields();

            doc.getClass().getAnnotations();

            for(Field field:fields){
                field.setAccessible(true);

                Annotation[] annotations =  field.getDeclaredAnnotations();
                if(annotations.length >0){

                    String validationResult = validateAnnotationsOnField(field.get(doc), annotations, issuesMap);
                }



            }

        }

    }



    private String validateAnnotationsOnField(Object obj, Annotation[] annotations,Map<String,Integer> issuesMap) {

        for(Annotation annotation:annotations ){
            annotationsHandler.validateAnnotation(obj, annotation, issuesMap);
        }
        return null;
    }

}
