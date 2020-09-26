# User Guide Duke project (Marvel-Themed) 

![enter image description here](https://pbs.twimg.com/profile_images/2955406958/3f74743072a5643bb3551a7e66b10612.jpeg)

Duke is a Personal Assistant Chatbot that helps a person to keep track of various tasks. It comes in both CLI and GUI to allow user to visualize the conversation better. 

## Setting up

Upon downloading and running the command `java -jar <ip.jar path>`
turn up your volume and start off by choosing a character to serve as your chat bot assistant. You may type in the one of the following option : 
- `TONY`
- `STEVE`
- `ROMANOFF`

*Note that caps do not matter. 
During the chat, you may feel free to change your chatbot assistant anytime during the chat, by typing in the above names as mentioned. 
## Features

1. **Adding a new Task** 
	There are 3 different types of Task that you can add to Duke. Todo, Deadline and Event. Their respective formats are given as below: 
	- Adds a 'Todo' task 
		- Format: `todo task_name`
		- Example: 
			- Add 'eat sushi' to list as a todo task: `todo eat sushi`
		
		- Expected output: 
				

			>  Got it. I've added this task: 
			> 					[T][Uncompleted] eat sushi 
			> 			 Now you have 1 task in the list.

	- Adds a 'Deadline' task 
		- Format: `deadline task_name /by DD/MM/YYYY HHMM`
		- Example:
			- Add 'eat sushi' to list as a deadline task: `deadline eat sushi /by 1/10/2020 1800`

- Expected output: 
				

			>  Got it. I've added this task: 
			> 					[T][Uncompleted] eat sushi 
			> 			 Now you have 1 task in the list.
	- Adds an 'Event' task
		- Format:  `event task_name /by DD/MM/YYYY HHMM`
		- Example:
			- Add 'eat sushi' to list as an event task: `deadline eat sushi /by 1/10/2020 1800`
		
2. **List** 
	List out all the task that you have added. 
	Format: `list`
3. **Mark as done** 
	Marks a task as completed. 
	Format: `done task_index_on_list`
	Example: 
	- To mark the first task on list as completed: `done 1` 
4. **Delete** 
	Deletes the specified task on list 
	Format: `delete task_index_on_list`
	Example: 
	- To delete the first task on list: `delete 1`
	
5. **Find** 
	Finds a task by searching for a keyword 
	Format: `find keyword` 
	Example:
	- To find all the task with the word "eat": `find eat` 

6. **Bye** 
	Exits the application.
	Format: `bye` 

## FAQ

Q: **Will my data be saved after exiting from the application?** 

A: All task that have been added to the list will automatically be saved when you exit Duke. No Additional action is required to save or load up from boot. 

Q: **Where can i find a text file my tasks?** 

A: All task are saved at *./data/tasks.txt* depending on the location you have your duke.jar file. 

## Command Summary

 - **Add task to list** 
	 - `todo	 task_name` 
		 - eg. `todo eat sushi`
	 - `deadline  task_name /by DD/MM/YYYY HHMM` 
		 - eg. `deadline eat sushi /by 1/10/2020 1800`
	 - `event task_name /by DD/MM/YYYY HHMM` 
		 - eg. `event eat sushi /by 1/10/2020 1800`
 - **List task**: list
	 - eg. `list`
 - **Mark task as completed**: done task_index_on_list 
	 - eg. `done 1`
 - **Delete task**: delete task_index_on_list 
	 - eg. `delete 1`
 - **Find task**: find keyword
	 - eg. `find sushi`
 - **Exit**: bye
	 - eg. `bye`
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE1NDU0MTgzODBdfQ==
-->