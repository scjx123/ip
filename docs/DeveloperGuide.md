


# Developer Guide

## 1. Table of content
**1. Table of content**\
**2. Setting Up**\
**3. Design**\
&nbsp;&nbsp;&nbsp;3.1 Architecture\
&nbsp;&nbsp;&nbsp;3.2 Main Layer\
&nbsp;&nbsp;&nbsp;3.3 UI Layer\
&nbsp;&nbsp;&nbsp;3.4 Command Interpreter Layer\
&nbsp;&nbsp;&nbsp;3.5 Executor Layer\
&nbsp;&nbsp;&nbsp;3.6 Storage Layer\
**4. Implementation**\
&nbsp;&nbsp;&nbsp;4.1 Module Planner Feature\
&nbsp;&nbsp;&nbsp;4.2 Checker Feature\
&nbsp;&nbsp;&nbsp;4.3 Cap Caculator Feature\
&nbsp;&nbsp;&nbsp;4.4 Reminder Feature\
&nbsp;&nbsp;&nbsp;4.5 Postpone Feature\
**5. Appendix A Product Scope**\
**6. Appendix B User Stories** \
**7. Appendix C Use Cases** \
**8. Appendix D Non-funcitonal Requirements** \
**9. Appendix E Glossary** \
**10. Appendix F. Instruction for Manual Testing**

## 2. Setting Up

1.  Ensure that you have Java 11 or above installed.
2.  Download the latest version of  `Duke`  from  [Our Release Page](https://github.com/AY2021S1-CS2113-T13-2/tp/releases/tag/v1.0).
3.  Copy the file to the folder you want to use as the home folder for your Mobile Nusmod.
4.  Open the Command Prompt if you are running on Windows or Terminal if you are running on Mac OS.
5.  Navigate to your home folder and type ‘java -jar domnus.jar’
6.  Type ‘bye’ to terminate your session.

## 3. Design

### 3.1 Architecture
The **Architecture Diagram** below represents a high-level design overview of the App. Specifically, it is done with an **N-tier architectural style**, where the higher layers make use of services provided by lower layers. 

![here](Images/Architecture_Diagram.PNG)


**3.2 Main Layer**<br>
For the `main` layer, it contains a single class known as `Duke`. 

**3.3 UI Layer**<br>
Main gets user input and displays messages through the use of UI component. 
The UI layer entails the package *visualize*, which contains classes *ColoredString*, *Bitmap*, *UI*, *Cli*, 
*FancyCli* and enumerations *Color* and *Sprite* in the following structure:
![uml](Images/Package%20visualize.png)

UI's interaction with user<br>
UI gets user input through *nextline()*, and renders strings as a user-comprehensible interface through 
*update(String, Data)*.

UI's interaction with the rest of the program<br>
UI passes the user's input string out to the Duke object, which then passes the string to the Command Interpreter layer.
UI also reads data from the Data object for refreshing purposes, but does not modify it. 

**1.3 Command Interpreter Layer**<br>
Upon receiving command from the UI, Duke would pass the entire user input into Command Interpreter (CI)

**1.4 Execute Layer**<br>
Once CI processed the user input, duke proceeds to redirect the input to Execute for execution of action. 

**1.5 Storage Layer**<br>
Once CI processed the user input, duke proceeds to redirect the input to Execute for execution of action. 

**1.6 Flow of DOMSUM**<br>
The sequence diagram below shows the main interaction of classes with each other throughout the whole lifecycle of DOMSUM.
![uml](Images/DOMSUM_Main_Flow.png)

## 4. Implementation<br>
This section highlights some of our project's key feature and its implementation. 

### 4.1 Take Feature
The take mechanism is facilitated by the TakeAction class. It extends Action class, and internally it stores an arraylist of Item object in `targetBackup`. Additionally, it implements the following operation: 

 - `prepare()` - Sets `isMod` flag according to user's 
 - `act()`- Gets `targetList` 
 - `modifyObject`()
 - `getObjectInfo`
 - `safetyCheck()`
 - `superAct()`

Given below is an example usage scenario and how the statistic mechanism behaves at each step. 

Step 1. The user enters `take 1 2 CS2113`	once the execute layer executes the message and calls `action.prepare()` class, `TakeAction` will begin its `prepare()` operation

Step 2. `prepare()` first checks th
Step 2. `prepare()` initializes two ArrayList() known as `indices` and `codes` . In which, `indices` stores the index of the module that user have keyed in, while `codes` stores the module code on the other hand. `Prepare()` 

Step 3. prepare() also calls safetyCe the isBlind() 

Step 3. Next, execute layer will call `action.act()` which causes TakeAction to begin its `act()` operation. If `isMod` flag is set, `act()` will search for the user specified module and get the list of tasks tagged to it.

Step 4. Once the list of task is obtain, the operation will loop through the task list and count the number of completed task followed by generating a ratio. 

Step 5. This ratio will be passed into `roundedRatioBar` to return *String* of a rounded ratio to 1 decimal place enclosing it in square brackets. 

Step 6. Now `StatsAction` is completed and it will return this string back to `Execute` for to be printed through `UI`. 

*Note*: if user did not enter `-mod` keyword, then at step 3, the flag will not be set, and hence all task's statistics will be calculated.  

**Design consideration:**

**Aspect : How statistics executes**
 - **Alternative 1 (current choice):** Create a separate class and get list of tasks/taken modules' task and scan through them to calculate statistics
	 - Pros: Reduces Coupling and increase testability as a software unit itself. 
	 - Cons: May have performance issues in terms of memory usage 

 - **Alternative 2:** initialize statistics as zero and each task contains an aspect called statistics
	 - Pros: Will use less memory since the task itself will be deleted. 
	 - Cons: Stats will be updated constantly even though we do not need it. 



### 4.2 Statistic Feature 
The statistic mechanism is facilitated by the StatsAction class. It extends Action class, and internally stores an arraylist of Item object in `targetList`. Additionally, it implements the following operation: 

 - `prepare()` - Sets `isMod` flag according to user's 
 - `act()`- Gets `targetList` and calculates the raw ratio of the completed items.
 - `roundedRatioBar()`- Returns a rounded ratio enclosed in square brackets for printing. 

Given below is an example usage scenario and how the statistic mechanism behaves at each step. 

Step 1. The user enters `stats -mod CS2113`	once the execute layer executes the message and calls `action.prepare()` class, `StatsAction` will begin its `prepare()` operation

Step 2. `prepare()` looks at the input called `ParamNode args` which is user command processed by Command Intepreter layer, and starts to identify whether user has enter the keyword `mod ` if `userInput` contains the keyword, then `isMod` flag will be set. 

Step 3. Next, execute layer will call `action.act()` which causes StatsAction to begin its `act()` operation. If `isMod` flag is set, `act()` will search for the user specified module and get the list of tasks tagged to it.

Step 5. Once the list of task is obtain, the operation will loop through the task list and count the number of completed task followed by generating a ratio. 

Step 6. This ratio will be passed into `roundedRatioBar` to return *String* of a rounded ratio to 1 decimal place enclosing it in square brackets. 

Step 7. Now `StatsAction` is completed and it will return this string back to `Execute` for to be printed through `UI`. 


**Design consideration:**

**Aspect : How statistics executes**
 - **Alternative 1 (current choice):** Create a separate class and get list of tasks/taken modules' task and scan through them to calculate statistics
	 - Pros: Reduces Coupling and increase testability as a software unit itself. 
	 - Cons: May have performance issues in terms of memory usage 

 - **Alternative 2:** initialize statistics as zero and each task contains an aspect called statistics
	 - Pros: Will use less memory since the task itself will be deleted. 
	 - Cons: Stats will be updated constantly even though we do not need it. 

### 4.3 Checker Feature 

The checker mechanism is facilitated by the utility class `Checker`. It is an independent class on its own without extensions and is stored under the `Data` package of our app. The class implements the following operations: 

 - `checkDuplicates()`- Calls the checkClash method and return the status of boolean variable `isClash` .
 - `checkClash(ArrayList< item >, Item)`- Updates `isClash` once a duplicate item is found in the list.
 - `checkRecurrenceDate(Task)` - Checks if the current date is beyond the stated date in the list, and provides a new update for the date recurring date.

Given below is an example usage scenario and how the checker mechanism behaves at each step. 

![here](Images/Checker_Diagram.png)

Step 1. A new `Deadline` object is created and needs to be added to the existing list of task. Hence it calls `addTask()` method under `Data` class. 

Step 2. Data instantiates a Checker with its existing list by calling its constructor, and the task to be added to the list 

Step 3. Data proceeds to call the `checkRecurrenceDate(Task)` of the Checker class, to get a newDate if today's date is beyond the stated weekly date.
 
Step 4. If `newDate` is not `null`it shows that there is a new updated date. Therefore, we proceed to update the object with our updated weekly date. 

Step 5. Now we proceed to call `checkDuplicates()` of Checker class. 

Step 6. If `false` , there is no duplicates in the existing list, and the task can be safely added. Otherwise, no action will be taken. 

**Design consideration: 
Aspect: How checker executes**

 - **Alternative 1(current choice):** Check for clashes *before* adding task onto list: 
	 - Pros: Easy to implement as we know specifically what to find in the list eg similar dates & description.
	 - Cons: Delays the efficiency of adding tasks onto list. 
 - **Alternative 2:** Check for clash after task is being added onto list 
	 - Pros: Does not hinder the speed of task adding. 
	 - Cons: Harder to implement as we have to loop through the entire list to look for duplicates. 

### 4.4 CAP calculator feature

The proposed undo/redo mechanism is facilitated by `CalculateCapAction`. It extends `Action` to execute command given by the user, output are then passed on to `Ui` for display. 
Additionally, it implements the following operations:

* `CalculateCapAction#act()` - Calculate the user CAP based on stored user grades / input modules.
* `CalculateCapAction#prepare()` - Parse user command to suitable parameter for `CalculateCapAction#act()` function.

Given below is an example usage scenario and how thecap calculator mechanism behaves at each step.

Step 1. The user executes `cap` command find his current CAP grade. Command is then parsed by `CalculateCapAction#prepare()` to be passed as arguments for `CalculateCapAction#act()`.

Step 2. `CalculateCapAction#act()` retrieves data from the stored user's grades.

Step 3. `CalculateCapAction#act()` then retrieves module data from the `modulelist.txt` to determine Modular Credit (MC) allocation.

Step 4. CAP value is calculated and returned to the user through `Ui`.

The following activity diagram summarizes what happens when a user executes a new command:

![cap uml diagram](Images/Cap_Calculator_Diagram.JPG)


### 4.5 Reminder Feature

The proposed undo/redo mechanism is facilitated by `ReminderAction`. It extends `Action` and the output is passed onto `UI` for display. Additionally, it implements the following operations:

* `ReminderAction#act()` — List out the deadlines and events tasks that are due within 3 days

Given below is an example usage scenario and how the reminder mechanism behaves at each step.

Step 1. The user executes `reminder` command to list out tasks due within 3 days. Command is then parsed by `ReminderAction#act()`.

Step 2. `ReminderAction#act` retrieves tasklist data from the user's list

Step 3. `ReminderAction#act` then sorts the due dates in ascending order

Step 4: Tasks due within 3 days are returned to the user through Ui

The following sequence diagram diagram shows how the reminder operation works

![Reminder_Sequence_Diagram](Images/ReminderAction_Sequence_Diagram.png)

### 4.6 Postpone Feature

The proposed undo/redo mechanism is facilitated by `PostponeAction`. It extends `Action` to execute command given by the user, output are then passed on to `Ui` for display. 
Additionally, it implements the following operations:

* `PostponeAction#act()` - Postpone the deadline or event task by the chosen parameter.
* `PostponeAction#prepare()` - Parse user command to suitable parameter for `PostponeAction#act()` function.

Given below is an example usage scenario and how thecap calculator mechanism behaves at each step.

Step 1. The user executes `postpone [index]` command to postpone the targeted task. Command is then parsed by `PostponeAction#prepare()` to be passed as arguments for `PostponeAction#act()`.

Step 2. `PostponeAction#act()` re-sets the date of the targeted task from the stored user's tasks by default a day.

Step 3. `PostponeAction#act()` then updates the stored user's data.

Step 4. Postponed target task is returned to the user through `Ui`.

The following activity diagram summarizes what happens when a user executes a new command:

![Postpone_Sequence_Diagram](Images/PostponeAction_Sequence_Diagram.png)

These operations are exposed in the Model interface as Model#commitAddressBook(), Model#undoAddressBook() and Model#redoAddressBook() respectively.
## Appendix A. Product scope
### Target user profile

 - has a need to manage significant number of schedules 
 - prefer desktop apps over other types 
 - can type fast
 - prefers typing to mouse interactions 
 - is reasonably comfortable using CLI apps 

### Value proposition
All in one app to track tasks and their dates, monitor productivity and calculate cap. 

## Appendix B. User Stories

|Priority| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
| *** |Student before start of semester|List the modules MC|Follow the recommended MC |
| *** |Student before start of semester|List of module available|Easily Choose which modules to take|
| ** |Student before start of semester|Find the modules either by keyword, module code or even MC |Easily see the desired modules |
| ** |Student before start of semester|Select the modules but not taking it yet |Easily whether the MC fits my requirement |
| *  |Student before start of semester|Find out the etails of the Module|To find out more about the modules.|
| *** |Student before start of semester|Take the desired modules|Mark the modules that i want to take as taken  |
| *** |Student during the semester|Add tasks such as todo,deadline and event into my list|Easily keep track of all the task i have to complete  |
| ** |Student during the semester|Have a Reminder of which deadline is due soon|Ensure that no task is missed out  |
| *** |Student during the semester|Add task to modules |Easily know which tasks belongs to which modules  |
| *** |Student during the semester|Delete task once they are completed |Remove unnecessary task on the list |
| ** |Student after the semester|Calculate the CAP of my individual modules|Easily find out my performance this semester |
| * |Student after the semester|Clear the list of tasks and modules|Start afresh for the next semester |

{More to be added}
## Appendix C. Use Cases: 
This section describes the Use Cases for some of the features implemented in DOMNUS. 

**Use Case: Taking a module 
MSS:** 

 1. User requests to list all modules 
 2. DOMNUS shows a list of modules 
 3. User requests to mark a specific module as 'taken' 
 4. DOMNUS marks the module as taken

Use case ends.<br>
**Extensions** \
&nbsp;&nbsp;&nbsp;3a. The module given is invalid\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3a.1Use case shows `[NOT FOUND]` message\ 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Use case resumes at step 3\
&nbsp;&nbsp;&nbsp;3b. User adds in the wrong module \
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3b.1The `untake` command can be used to untake the taken module \

**Use Case: List MC**
**MSS:**


 1. User requests to list total MC on the current list. \
 2. DOMNUS shows the total MC of the current list. Default list is entire modules list. \

Use case ends.<br> 
**Extensions** 

&nbsp;&nbsp;&nbsp;1a. User not focusing on the correct list \
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1a1. DOMNUS shows the entire module list total MC instead of the 'taken' list MC \

 
Use Case: 

## Appendix D. Non-Functional Requirements

1.  Should work on any  _mainstream OS_  as long as it has Java  `11`  or above installed.
2.  Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

_{More to be added}_

## Appendix E. Glossary

 - N-tier Architectural Style 
	 - In the n-tier style, high layers make use of services provided by lower layers. Lower layers are independent of higher layers. 
 - Mainstream OS: Windows, Linux, Unix, OS-X
 - Private contact detail 

## Appendix F. Instructions for manual testing

1. Launch and Shutdown 
Step 1: Download the latest version of  `Duke`  from  [Our Release Page](https://github.com/AY2021S1-CS2113-T13-2/tp/releases/tag/v1.0).\
Step 2: Copy the file to the folder you want to use as the home folder for your Mobile Nusmod.\
Step 3: Open the Command Prompt if you are running on Windows or Terminal if you are running on Mac OS.\
Step 4: Navigate to your home folder and type  **‘java -jar domnus.jar’**\

1. Launch and Shutdown 
Step 1: Download the latest version of  `Duke`  from  [Our Release Page](https://github.com/AY2021S1-CS2113-T13-2/tp/releases/tag/v1.0).\
Step 2: Copy the file to the folder you want to use as the home folder for your Mobile Nusmod.\
Step 3: Open the Command Prompt if you are running on Windows or Terminal if you are running on Mac OS.\
Step 4: Navigate to your home folder and type  **‘java -jar domnus.jar’**\

2. Switching between Fancy and CLI 
Test case: `fancy`<br>
Expected: Switches to fancy mode of display <br>
Test case: `plain`<br>
Expected: Switches to plain mode of display<br>
Test case: `Fancy` ,`Plain`<br>
Expected: Error message due to cap sensitive. <br>
3. Focusing between different list
	Test case: `focus mod`/`task`/`todo`/`deadline`/`event`/`selected`/`taken`<br>
			   Expected : Shows the current list you are focused on. No list will be shown. <br>
	Test case: `focus taken` <br>
	Expected: Shows the current list of modules you have taken. <br>
	Other incorrect focus commands to try: `focus 0` , `focus what?`, ... (focus on non-existent list) <br>
	Expected : Error message due to invalid command. <br>
	
4. List Modules/Task
Test case: `focus mod` -> `list`<br>
	Expected: Shows the list of modules. <br>
	Test case: `focus task` -> `list` <br>
	Expected: Shows the current list of task. <br>
	
5. Find Modules 
Test case: `focus mod` -> `find Engin`<br>
Expected: Shows the list of available modules with keyword 'Engin' <br>
Test case:  `focus mod` -> `find 2113`<br>
Expected: Shows the list of modules with keyword '2113'<br>
Test case: `focus task`-> find deadline <br>
Expected: Show list of deadline modules 

 6. Details of Modules 
 Test cases: `detail CS2113`<br>
 Expected: Shows Module code, name, mc, and description. <br>
Test cases: `detail 1`<br>
Expected: Shows the information of the 1st task based on the current list focused on. <br>
Test cases: `detail xyz` No detail of such item is found. <br>
7. Take Modules 
Test cases: `focus mod` -> `take 1 2` <br>
Expected: Takes the 1st and 2nd module on the module list.<br>
Test cases: `focus task` -> `take 1 2` <br>
Expected: Task is not module, therefore it cannot be taken.<br>
Test cases: `focus mod` -> `take CS2113` <br>
Expected: Mark CS2113 as taken.<br>
Test cases: `focus mod` -> `take cs2113`<br>
Expected: Module not found as inputs are case sensitive. <br>
7. Reminder <br>
Test cases: `reminder `<br>
Expected: Shows task that are due within 3 days. <br>

8. Cap Calculation <br>
Test cases: `cap -m CS2113 A+ EE2026 B CS1010 B-<br>
Expected: Shows you the calculated cap. <br>

<!--stackedit_data:
eyJoaXN0b3J5IjpbNzUxMTEyNDUwLC04MDA1ODI2MDEsMTYzNT
A0NjM4OCwtMTQ4MDQ0NDI0NSwtNTQ5NTczNzM2LC05MTQ1NjE2
NDcsMTE3ODc4NDQwXX0=
-->