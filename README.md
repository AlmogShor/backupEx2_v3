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
>Threads allows a program to operate more efficiently by doing multiple things at the same time.
Threads can be used to perform complicated tasks in the background without interrupting the main program.

## ThreedPool
>Java Thread pool represents a group of worker threads that are waiting for the job and reused many times.
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


## Main Classes
- [x] **Ex2_1** 
    - **createTextFiles** - creating number of files (with given number). 
    - **getNumOfLines** - counting lines in natural way with BufferedReader.  
    - **getNumOfLinesThreads** - counting lines using threads. 
    - **getNumOfLinesThreadPool** - counting lines using thread pool.
- [x] **runnableFilesReader**


## UML diagram for Part 1
![תמונה של WhatsApp‏ 2023-01-13 בשעה 01 26 52](https://user-images.githubusercontent.com/92925727/212204006-70a76557-ea24-4179-a953-a45f2cdd64a2.jpg)


# Part 2
## BackGround
> In Java, there is no built-in option to give priority to an asynchronous task (a task that will be executed in a separate thread). The language does allow you to set a priority for the Thread that runs the task, but not for the task itself.





## The mission
Create a new type that represents an asynchronous task with priority and a new ThreadPool type that supports owning tasks
priority.
1. A generic task with a Type that returns a result and may throw an exception.
Each task has a priority used for scheduling, inferred from the integer value of the task's Type.
2. A custom thread pool class that defines a method for submitting a generic task as described in
the section 1 to a priority queue, and a method for submitting a generic task created by a
Callable<V> and a Type, passed as arguments.

## The Chalanges
1. Returning value operation - in this case we must use Callable interface - but the thread pool works with FutureTask and Runnable - the solutin explained in Design Patterns.
2. Use Priority Queue in our customExecutor but the FutureTask interface are not comparable - the solutin explained in Design Patterns - the solutin explained in Design Patterns.
3. Return the maximum priority in the queue in O(1) time & space complexity when this method may not access the queue to query the current maximum priority - we created "shadow" array that holds the number of task from each priotiry. When we submiting the task we קnter his priority in the specific cell in the array and before execute we count it down.



## Main Classes
- [x] **Task** 
  > Represents an operation that can be run asynchronously and can return a value of some type.
  It is not necessary for the operation to succeed and in case of failure, an exception will be thrown.
    - **Task** -  takes the callable task, convert it to Future task and execute it to the thread pool.
    - **createTask** - Factory method - Published method to create a task for safe creation.
    - **createTask** - Published task creation in case the type is other - not defined.
    - **equals** - Compares between two tasks.
    - **hashCode** - Hash performance of task.
   
    
- [x] **CustomExecutor**
  > Represents a new type of ThreadPool that supports a queue of priority tasks. CustomExecutor create a Task before putting it in the queue by passing Callable<V> and enum of type TaskType. CustomExecutor will execute the tasks according to their priorit. The threadpool size depends on a number of available processors. 
    - **submit** - takes the callable task, convert it to Future task and execute it to the thread pool.
    - **submit** - execute task without type definition.
    - **submit** - execute task with type definition.
    - **gracefullyTerminate** - Option to stop the CustomExecutor. Stops accepting new tasks, waits for already submitted tasks to complete even if they didn't start yet and Complete all tasks that are in the queue.
    - **beforeExecute** - 
    

- [x] **TaskType** (supplied ready to use)
  > Is an enum that describes the type of task (computational/IO/Other access/unknown) and its priority based on the value number of the task type.
  
## Design Patterns
In this assignment we used quite a few design patterns.
  
***Factiry*** - In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface. We used that pattern to make the task creation safely.
***Addapter*** - Adapter pattern works as a bridge between two incompatible interfaces. The adapter pattern convert the interface of a class into another interface clients expect. In our project we created new class that implements FutureTask and Runnble. When we submiting the task (Task callable type) to our CustomExecutor we change it to new adapted class.

## UML diagram for Part 2
   
![תמונה של WhatsApp‏ 2023-01-13 בשעה 01 26![תמונה של WhatsApp‏ 2023-01-13 בשעה 01 26 53](https://user-images.githubusercontent.com/92925727/212213086-395438a4-99a4-42fe-94cb-70f4dbeb70ea.jpg)53](https://user-images.githubusercontent.com/92925727/212203776-2c6d33bc-a932-4be9-8606-e138a3bc5622.jpg) 









