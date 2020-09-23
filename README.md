# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```

## Features

1. Adding a new Task 
	There are 3 different types of Task that you can add to Duke. Todo, Deadline and Event. Their respective formats are given as below: 
	- Adds a 'Todo' task 
		- Format: `todo task_name`
		- Example: 
			- Add 'eat sushi' to list as a todo task: `todo borrow book`
	- Adds a 'Deadline' task 
		- Format: `deadline task_name /by DD/MM/YYYY HHMM`
		- Example:
			- Add 'eat sushi' to list as a deadline task: `deadline eat sushi /by 1/10/2020 1800`
	- Adds an 'Event' task
		- Format:  `event task_name /by DD/MM/YYYY HHMM`
		- Exa-
		
2. List 
	List out all the task that you have added. 
	Format: `list`
3. Mark as done 
	Marks a task as completed. 
	Format: `done task_index_on_list`
	Example: 
	- To mark the first task on list as completed: `done 1` 
4. Delete 
	Deletes the specified task on list 
	Format: `delete task_index_on_list`
	Example: 
	- To delete the first task on list: `delete 1`
	
5. Find 
	Finds a task by searching for a keyword 
	Format: `find keyword` 
	Example:
	- To find all the task with the word "eat": `find eat` 

6. Bye 
	Exits the application.
	Format: `bye` 

## FAQ

Q: Will my data be saved after exiting from the application? 
A: All task that have been added to the list will automatically be saved when you exit Duke. No Additional action is required to save or load up from boot. 

Q: Where can i find a text file my tasks? 
A: All task are saved at *./data/tasks.txt* depending on the location you have your duke.jar file. 

Command Summary  
***todo	 task_name
deadline  task_name /by DD/MM/YYYY HHMM
event task_name /by DD/MM/YYYY HHMM
list 
done task_index_on_list
delete task_index_on_list
find keyword
bye***


<!--stackedit_data:
eyJoaXN0b3J5IjpbLTIwNjYzMjgzNjhdfQ==
-->