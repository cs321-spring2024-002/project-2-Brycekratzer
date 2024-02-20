# Max Heap Implementation for My Life in Stardew

* Author: Bryce Kratzer
* Class: CS321 Section #002
* Semester: SPRING 2024

## Overview

This project implements a priority-based task management simulation inspired by the farming simulation video game "Stardew Valley." The simulation utilizes a priority queue abstract data type, extended from a max heap data structure, to manage various tasks based on their priority levels and time constraints. Tasks are generated dynamically and scheduled for completion by the player (farmer) within a specified duration. Each task carries specific attributes such as priority, energy consumption, and associated risks, closely mirroring the gameplay mechanics of Stardew Valley.

## Reflection

Throughout this project I had ran into many challenges that left me puzzled, but also satisfed
after completeing each seprate task. One of the bigger conflicts I faced was figuring out how I was going
to set up the heap data structure, that is, by what means. I felt that if I used an ADT that supports generics
it would be eaiser to test. This left me with ArrayList and the generic Array's. I remembered that ArrayList expand
in size on their own which would be very benefitcal considereding how Max-Heap Structures work. From there I began implementing 
The max heap class and continueing development.

Overall this project was one of my more challenging projects, but I learned more from this one project than I did from previous 
projects. One thing that this project got me more familiar with was Object Orientated Programming and allowed me to better
understrand how this type of langueage is benefital in some instances.

## Compiling and Using

To compile and run the simulation, use the following command-line arguments:

    java MyLifeInStardew 
    <max-priority-level> <time-to-increment-priority> <total simulation-time in days> <task-generation-probability> [<seed>]
Argument Details:

    <max-priority-level>
Defines the highest priority level for tasks, ranging from 0 to maxPriorityLevel.

    <time-to-increment-priority> 
Duration after which a task's priority increases by one if not completed.

    <total simulation-time in days>:
Total duration of the simulation in days.

    <task-generation-probability>Probability 
(between 0 and 1) to generate a new task during each hour.

    [<seed>]
Optional seed for the random number generator to ensure reproducible testing.

## Results 

Located in this repository is a **test-cases** folder which contains 6 unquie inputs and their excpected outputs. 6 out of the 6 scenarios passed which solidates the programs effectiveness. 

## Sources used

[CS321 Data Structures Notes](http://cs.boisestate.edu/~jhyeh/cs321/notes.pdf)

----------
