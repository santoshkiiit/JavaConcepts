package com.learning.annotation.validators.docValidators;

import com.learning.annotation.documents.BaseDocument;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by santoshk on 2/21/18.
 */
public class DocumentValidator {


    DocumentConsistencyValidator documentConsistencyValidator = new DocumentConsistencyValidator();
    DocumentFieldsValidator documentFieldsValidator = new DocumentFieldsValidator();

    Map<String, Integer>  fieldIssuesMap = new HashMap<>();
    Map<String, Integer>  consistencyIssuesMap = new HashMap<>();


    public String fetchValidationResultForDocuments(List<BaseDocument> documents) throws IllegalAccessException {

        for(BaseDocument document:documents) {

            documentConsistencyValidator.validate(document,consistencyIssuesMap);
            documentFieldsValidator.validateDocumentFields(document,fieldIssuesMap);
        }


        StringBuilder result = new StringBuilder("Field value issues"+"\n");
        Iterator fieldsIterator = fieldIssuesMap.keySet().iterator();

        while(fieldsIterator.hasNext()){
           String issueType = (String) fieldsIterator.next();

            Integer occurences = fieldIssuesMap.get(issueType);

            result.append(issueType + ":" + occurences+"\n");


        }

        result.append("Consistency Issues"+"\n");
        Iterator consistencyCheckIterator = consistencyIssuesMap.keySet().iterator();


        while(consistencyCheckIterator.hasNext()){
            String issueType = (String) consistencyCheckIterator.next();

            Integer occurences = consistencyIssuesMap.get(issueType);

            result.append(issueType + ":" + occurences+"\n");


        }

        return result.toString();
    }
}
