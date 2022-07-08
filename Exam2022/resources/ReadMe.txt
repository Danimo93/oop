Hello.

First I want to mention that I have been using my root user for the JDBC and my root password, but that password is one that I use for other services.
So I have removed it from the code. But there is only two pleases in the code that needs to be added. At the top of class Database and Database_Questions
there is a method in both named "conDb()" where you can insert your password.

There is also two sql scripts in this folder, the first is script.sql with I have been maintaining as I have been working on the project. The Finale.sql was
made when I was done (more or less) with this exam. Both should, hopefully, work just fine, but I wanted to add some redundancy.

Under the main method there are two methods: dq.historyQuestions() and dq.boxingQuestions(); that are made to fill the database with questions after it has
been connected and sett up. I hope they work fine for you.

I did not have time make and implement more questions, I wanted to, but time and a pounding headache stopped me.

Generally I hope that is as little as possible in terms of problems with getting this code up and running on your system.

The code is also commented, to the best for my current ability (It is currently over 12 hours since I started this exam...),
hopefully it makes the code more understandable and gives some insight to why I did what I did.



Under here are some of my personal thoughts and "regrets" about my performances on this project, feel free to skip it, if it's not relevant.
----------------------------------------------------

I am frustrated with how I did not manage to get proper use out of the Quiz and User classes. I feel like there i a lot of code that could
be made to work well with these Classes, but I honestly got so panicy and frustrated with not getting the override methods to work with the code
that I had already created. After a fair bit of banging my head against the wall and trying to make these methods work with the code that I already made
I decided to go off track from the specification of the exam papier. This was not done out of laziness or crass, but I got so upset that I just decided to
go about solving the problem my own way. As you told us: the most important part is that the code runs, and with these words in mind I decided to not let
the perfect be the enemy of the good. I am somewhat frustrated that my solution does not show that I have an understanding of Abstract classes and inheritance,
but I did what I could with the time and skill that I had.

The code did not turn out as good or as "fancy" as I wanted to, and I am a little disappointed with that, but yeah... I guess that might be a normal
feeling for us programmers.

