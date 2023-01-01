Feature: Validating Books

Scenario Outline: Add a Book in the list
Given Create a Book PayLoad with <id>, <title>, <description>, <pageCount>, <excerpt>, <publishDate>
When User calls "CreateBook" with "post" http request
Then API call got success with status code 200
And "title" in the response body is "string"

Examples:
|id|title|description|pageCount|excerpt|publishDate|
|2|string|string|20|string|2022-12-26T04:47:07.360Z|

Scenario Outline: Get a Book from the list
Given pass the book <id> to "get" book
When User calls "GetBook" with "get" http request
Then API call got success with status code 200


Examples:
|id|
|2|

Scenario Outline: Update a Book in the list
Given Update a Book with payload <id>, <title>, <description>, <pageCount>, <excerpt>, <publishDate>
When User calls "UpdateBook" with "put" http request
Then API call got success with status code 200


Examples:
|id|title|description|pageCount|excerpt|publishDate|
|2|Book|string|19|string|2022-12-26|

Scenario Outline: Delete a Book in the list
Given pass the book <id> to "delete" book
When User calls "DeleteBook" with "delete" http request
Then API call got success with status code 200


Examples:
|id|
|2|