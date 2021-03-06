# Flags
Flags is a game application written in Java (IntelliJ). It was one of projects made for classes “Basics of machine learning” and represents the knowledge base type of machine learning.

The idea is to find by the app a graphic of national flag secretly chosen by the user. To do so, it asks closed questions about flags. There are 23 questions that are scored by algorithm to find such that two groups of flags (answer for the question is Yes or No) are roughly the same size (divided in half). This was achieved by asking two questions with conjunction and/or.

There are 223 flags, so if an app is able to guess user’s flag, it must ask sometimes eight questions to distinguish all flags (there is no way to find each flag in seven questions 2^7=128). The Flags app achieved a minimum possible number of questions and ask no more them than eight.

The project is covered with unit test where it is possible and have scenario tests to check whether all flags can be found within eight questions. All the code was written in clean code approach.

Here are some screenshots:


![](screenshots/Screenshot4.png)
![](screenshots/Screenshot3.png)
![](screenshots/Screenshot2.png)
![](screenshots/Screenshot1.png)
![](screenshots/classDiagram.png)
