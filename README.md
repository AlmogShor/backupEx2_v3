# Object - Oriented Programing course - Exercise 2
## Made by [@ Yulia Katz](https://github.com/yukatz) and [ @ Almog Shor](https://github.com/AlmogShor)



Download and run the Project:

Download the whole project and export it by the above actions:
```
Click Code (Green Button) -> Click Download ZIP -> Choose Extract to Folder in Zip 
```

## Introduction
This is our third project in the OOP course.
In this project we worked with threads.


## Threed
Threads allows a program to operate more efficiently by doing multiple things at the same time.
Threads can be used to perform complicated tasks in the background without interrupting the main program.

## ThreedPool
Java Thread pool represents a group of worker threads that are waiting for the job and reused many times.
In the case of a thread pool, a group of fixed-size threads is created. 
A thread from the thread pool is pulled out and assigned a job by the service provider. 
After completion of the job, the thread is contained in the thread pool again.

# Part 1
In this part we tested efficiency between different forms of using threads.
We ceated several text files and calculated the total number of lines in these files.
We did it by using three methods:
- [x] Normal method without using threads.
- [x] With using threads.
- [x] With using threadPool.

This is the performance in milliseconds for the three methods
| Normal  | Thread | ThreadPool  | 
| ------  | ------ | ---------   |
|  7 ms   |  37 ms |   3 ms      | 

- [x] **Ex2_1** 
    - **createTextFiles** - creating number of files (with given number). 
    - **getNumOfLines** - counting lines in natural way with BufferedReader.  
    - **getNumOfLinesThreads** - counting lines using threads. 
    - **getNumOfLinesThreadPool** - counting lines using thread pool.
- [x] **runnableFilesReader**


## UML diagram for Part 1
![תמונה של WhatsApp‏ 2023-01-13 בשעה 01 26 52](https://user-images.githubusercontent.com/92925727/212204006-70a76557-ea24-4179-a953-a45f2cdd64a2.jpg)


# Part 2
In this part we were asked to create two new types that extend the functionality of Java's Concurrency Framework:
A generic task with a Type that returns a result and may throw an exception.
Each task has a priority used for scheduling􀍕 inferred from the integer value of the task􀍛s Type.
2. A custom thread pool class that defines a method for submitting a generic task as described in
the section 1 to a priority queue, and a method for submitting a generic task created by a
Callable<V> and a Type, passed as arguments.



- [x] **Task** 
 > Callable task with 
    - **Task** -  takes the callable task, convert it to Future task and execute it to the thread pool.
    - **createTask** - Factory method - Published method to create a task.
    - **createTask** - Published task creation in case the type is other - not defined.
    - **equals** - Compares between two tasks.
    - **hashCode** - Hash performance of task.
   
- [x] **CustomExecutor**
  > Thread Pool
    - **submit** -  takes the callable task, convert it to Future task and execute it to the thread pool.
    - **submit** - without type definition.
    - **submit** - methods to register  observers.
    - **gracefullyTerminate** - methods to unregister observers.
    - **Insert** - Inserts the string into this character sequence.
    - **Append** - Appends the specified string to this character sequence.
    - **Delete** - Removes the characters in a substring of this sequence.
    - **Undo** - Erases the last change done to the document, reverting it to an older state.



## UML diagram for Part 2
![תמונה של WhatsApp‏ 2023-01-13 בשעה 01 26 53](https://user-images.githubusercontent.com/92925727/212203776-2c6d33bc-a932-4be9-8606-e138a3bc5622.jpg)









