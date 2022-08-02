#QUESTIONS UNDER THIS COMMENT ARE MEANT FOR "multichoicequiz" TABLE

INSERT INTO quizdb.multichoicequiz(ID, question, answerA, answerB, answerC, answerD, correctAnswer)
VALUES (1,'What color is the sun?','black', 'blue','green', 'yellow', answerD);

INSERT INTO quizdb.multichoicequiz(ID, question, answerA, answerB, answerC, answerD, correctAnswer)
VALUES(2, 'What color is the ocean?', 'brown', 'blue', 'purple', 'black', answerB);

INSERT INTO quizdb.multichoicequiz(ID, question, answerA, answerB, answerC, answerD, correctAnswer)
VALUES(3, 'How are earthquakes measured?', 'with the richter scale', 'with a geiger counter', 'with a fish scale', 'with a kg scale ', answerA);

INSERT INTO quizdb.multichoicequiz(ID, question, answerA, answerB, answerC, answerD, correctAnswer)
VALUES(4, 'What is the name for a cloud that touches grass?', 'rain', 'mist', 'thunder', 'fog', answerD);

#END OF QUESTIONS FOR "multichoicequiz" TABLE


#QUESTIONS UNDER THIS COMMENT ARE MEANT FOR "binaryquiz" TABLE

INSERT INTO quizdb.binaryquiz(ID, question, correctAnswer)
VALUES(1, 'Is broccoli healthy?', 'yes');

INSERT INTO quizdb.binaryquiz(ID, question, correctAnswer)
VALUES(2, 'Can apples grow like sqares naturally?', 'no');

INSERT INTO quizdb.binaryquiz(ID, question, correctAnswer)
VALUES(3, 'Is junkfood healty?', 'no');

INSERT INTO quizdb.binaryquiz(ID, question, correctAnswer)
VALUES(4, 'Is all food chemically sprayed?', 'no');

#END OF QUESTIONS FOR "binaryquiz" TABLE

# Run all of the code above to insert questions into all tables!