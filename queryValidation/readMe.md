Basic Query Validation Util

step1: validates the query string using stack and build a expression stack if the query is valid -- commited
step2: takes the expression stack as input and builds a QueryExpression object, which can be evaluated in DOA layer.

Assumptions:

Each query condition is nested inside a start and end tag  (/{/[ 

some valid query expressions:
(A)
(A) OR (B) OR (C)
(A) OR ( (B) OR ( (C) AND (D) ) )
