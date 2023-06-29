FRC 3559 Intro to Programming
Edwin Sanchez
# Horse Race Project (Object-Oriented Programming Introduction)
The goal of this project is to learn a little bit about Object-Oriented-Programming: How to make objects, how to use them, and most importantly, *why* we use them.

We will also look at how to use project management tools in order to help facilitate the design of our code/program.

## Project Management Tools
There are many tools that you may use to do project management. Some, but not all, include:
* **Guiding Document:** this is the document you write in order to declare the programing goals and any other details you might want to specify. If you ever get lost, you can come back to this document and double-check if your code matches the end goal you wanted.
* **Class Diagrams:** used to design classes for object-oriented code.
* **Flow Charts:** can help to visualize how your program transitions between its many states.
* **UI Diagramming/Mapping:** used to draw out the UI for a given program to help understand how the user may interact with the system and give an insight into how one might design some of the functionality of the code.

For this project, we will use the **Guiding Document**, **UI Diagramming**, and **Class Diagrams**.

### Guiding Document
Normally, for smaller projects, my `README.md` is the document I use as my guiding document. We will write out our guiding document below. Here are a few things you may want to add to your guiding documents in future projects:

* **Project Title/Name:** Don't mistake the power of a good name. This can help you to summarize your project in a single word or phrase, which is powerful when it comes to setting up a good mindset to work on a project.

* **Goals:** what is the goal of your project? Write this out explicitly so that you know exactly what your goal is. You should be able to summarize your project's goal in about a paragraph.

Often times people get stuck in projects because they do a poor job setting their goal. Without having an explicit goal, it's hard to measure whether or not you are succeeding, which can be de-motivating. It also makes it hard to know if that anything you are working on is really helping you reach your end goal. Many people get caught up in little details - **avoid trying to make an everything project**. Projects that try to do everything will end up doing nothing.

* **Requirements:** This can be nice if your program needs to have very specific requirements that aren't quite worth mentioning directly in your goal. For instance, you may be developing a texting app. While your goal is to facilitate communication through your app, you may have a requirement for your app to be *accessible* - meaning that maybe you design the app to allow blind people to easily use it. 

While these requirements aren't you true objective, they are things you think are crucial for your project to be able to work well. Also, remember to only add the things you need - again, avoid creating an everything project (I'm mentioning it a lot because it's a very common issue developers face).

* **Inputs:** These are what will need to go into your program. For a simple program, you may not have many of these. This could just be deciding how your user will interact with your program (ie. terminal, GUI, etc.). Other things may include files that your program depends on for working. For larger project, you may need to dedicate significant time to understanding what inputs your program will need/have.
* **Outputs:** These are what your program will output. This could be files as well as text printed to the terminal to facilitate user interaction (This sort of goes hand-in-hand with inputs).
* **Classes/Methods:** This section should contain all of the details your code will have. Any functions or Classes you will create should be written out here so that anyone who need to know how your code works can look at this and instantly understand what it does/how it should work. If you write this out before you start programming, you will have a guide to go by when you're writing code so that you don't get lost. The amount of detail you put in here will be reflected in how much difficulty you have writing your code.

Below is an example of a Guiding Document, designed around the current project:

```
Project Title: Horse Race Project

Goal:
The goal of this project is to write a terminal/command line program that allows a user to bet on a horse race. This program should:

1) Allow the user to quit the program.
2) Allow the user to see their available ballance.
3) Allow the user to start a race, pick a horse to bet on, watch the race, and then have their balance updated to reflect the results of their race and the bet.

Requirements:
- If the user inputs wrong values when navigating the menu, the program should be able to handle this.
- If the user does not have enough money to continue to bet, then they should be denied the ability to start a race.

Inputs:
The user will use the terminal to input decisions for the program. The user's inputs will be restricted to explicit options listed in menus printed to the screen.

Outputs:
The program will output menus for the user to interact with, as well as other statements depending on the selected option. During the horse race, the program will output the current state of the race for the user to see.
```

# TODO:
* Instroduce OOP Programming
  * Create a program (Horse Race)
  * Utilize Objects (Horse)
  * Have the students fill out the functionality of the Objects to make the program work
* Introduce Software Project Management Tools
  * UML (Unified Markup Language)
  * Class diagrams
  * UI mapping
  * Flow charts
  * State Machines
  * Project Guiding Document (README.md in this case)
    * Goal
    * Inputs
    * Outputs
    * Methods/Classes