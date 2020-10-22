# Domnus - An easy way to track your schedules!

![here](../UI.png)

 - This is a desktop tasks tracker application. It comes with a fancy and plain mode of display in which user can switch anytime between them.
 - It is a Java application intended for students to track their modules, mc, daily task, as well as assignments for the indiUser Guide Duke project (Marvel-Themed) 
![Marvel The Avengers Logo Hd Wallpaper - Marvel - 1600x900 - Download HD  Wallpaper - WallpaperTip](https://wi.wallpapertip.com/wsimgs/26-262036_marvel-the-avengers-logo-hd-wallpaper-marvel.jpg)

Duke is a Personal Assistant Chatbot that helps a person to keep track of various tasks. It comes in both CLI and GUI to allow user to vidsual modules. 

## Setting up in Intellij

Prerequisites: JDK 11 (use the exact version), update Intellij to the most recent version.

1. **Configure Intellij for JDK 11**, as described [here](https://se-education.org/guides/tutorials/intellijJdk.html).
1. **Import the project _as a Gradle project_**, as described [here](https://se-education.org/guides/tutorials/intellijImportGradleProject.html).
1. **Verify the set up**: After the importing is complete, locate the `src/main/java/seedu/duke/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
   > Task :compileJava
   > Task :processResources NO-SOURCE
   > Task :classes
   
   > Task :Duke.main()
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   
   What is your name?
   ```
   Type some word and press enter to let the execution proceed to the end.

## Build automation using Gradle

* This project uses Gradle for builize the conversation better. 

## Setting up

Upon downloading and running the command `java -jar <ip.jar path>` start off by choosing a character to serve as your chat bot assistant. You may type in the one of the following option : 
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
				

			

				>     Got it. I've added this task: 
				> 	[T][Uncompleted] eat sushi 
				> 	Now you have 1 task in the list.

	- Adds a 'Deadline' task 
		- Format: `deadline task_name /by DD/MM/YYYY HHMM`
		- Example:
			- Add 'eat sushi' to list as a deadline task: `deadline eat sushi /by 1/10/2020 1800`
		- Expected output: 

				>     Got it. I've added this task: 
				> 	[D][Uncompleted] eat sushi by: Oct 1 2020 06:00PM
				> 	Now you have 2 task in the list.

			

	    -	note that you will only have 2 task in the list, if you have added the previous 'todo' example. 

	- Adds an 'Event' task
		- Format:  `event task_name /by DD/MM/YYYY HHMM`
		- Example:
			- Add 'eat sushi' to list as an event task: `event eat sushi /by 1/10/2020 1800`
		- Expected aoutomation and dependency management. It includes a basic build script as well (i.e. the `build.gradle` file).
* If yput: 
				

				>     Got it. I've added this task: 
				> 	[E][Uncompleted] eat sushi by: Oct 1 2020 06:00PM
				> 	Now you have 3 task in the list.

2. **List** 
	List out are new to Gradle, refer to the [Gradle Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/gradle.html).

## Testing

### I/O redirection tests

* To run _I/O redirection_ tests (aka _Text UI tests_), navigate to the `text-ui-test` and run the `runtest(.bat/.sh)` script.

### JUnit tests

* A skeleton JUnit test (`src/test/java/seedu/duke/DukeTest.java`) is provided with this project template. 
* If you are new to JUnit, refer to the [JUnit Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/junit.html).

## Checkstyle

* A sample CheckStyle rule configuration is provided in this project.
* If you are new to Checkstyle, refer to the [Checkstyle Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/checkstyle.html).

## CI using GitHub Actions

The project uses [GitHub actions](https://github.com/features/actions) for CI. When you push a commit to this repo or PR against it, GitHub actions will run automatically to build and verify the code as updated by the commit/PR.

## Documentation

`/docs` folder contains a skeleton version of the project documentation.

Steps for publishing documentation to the public: 
1. If you are using this project template for an individual project, go your fork on GitHub.<br>
   If you are using this project template for a team project, go to the team fork on GitHub.
2. Click on the `settings` tab.
3. Scroll down to the `GitHub Pages` section.
4. Set the `source` as `master branch /docs folder`.
5. Optionally, use the `choose a theme` button to choose a theme for your documentation.


## Site Map

* [User Guide](https://github.com/AY2021S1-CS2113-T13-2/tp/blob/master/docs/UserGuide.md)
* [Developer Guide](https://github.com/AY2021S1-CS2113-T13-2/tp/blob/master/docs/DeveloperGuide.md)
* [About Us](https://github.com/AY2021S1-CS2113-T13-2/tp/blob/master/docs/AboutUs.md)
* [Contact Us](https://github.com/AY2021S1-CS2113-T13-2/tp/blob/master/docs/ContactUs.md)ll the task that you have added. 
	Format: `list`
	Expected output: 
				

			>  Here are the task in your list: 
			> [T][Uncompleted] borrow book 
			> [D][Uncompleted] eat sushi by: Oct 1 2020 06:00PM
			> [E][Uncompleted] eat sushi by: Oct 1 2020 06:00PM
	However, do note that for GUI, the display is limited. Hence, the list will be chop off. You may refer to the CLI for the whole list. 

3. **Mark as done** 
	Marks a task as completed. 
	Format: `done task_index_on_list`
	Example: 
	- To mark the first task on list as completed: `done 1` 

	Expected output: 
	
		  > Nice! I've marked this task as done:  	
		  > [T][Completed] borrow book

4. **Delete** 
	Deletes the specified task on list 
	Format: `delete task_index_on_list`
	Example: 
	- To delete the first task on list: `delete 1`

	Expected output: 
	
		  > Got it. I've removed this task:
		  > [T][Completed] borrow book
		  > Now you have 2 task in the list.
	
5. **Find** 
	Finds a task by searching for a keyword 
	Format: `find keyword` 
	Example:
	- To find all the task with the word "eat": `find eat` 
	
	Expected output: 
	
		  > 1.[D][Uncompleted] eat sushi by: Oct 1 2020 06:00PM
		  > 2.[E][Uncompleted] eat sushi by: Oct 1 2020 06:00PM

6. **Bye** 
	Exits the application.
	Format: `bye` 
	Expected output: 
	
		  > Bye. Hope to see you again soon!


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
eyJoaXN0b3J5IjpbODgxNTk5NjU4XX0=
-->