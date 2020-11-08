# User Guide
![here](Images/Logo.PNG)png)

## Introduction

Domsun is a **Desktop Command Line Interface (CLI) program that allows users to manage tasks and modules.** <br>
Domsun is targeted at busy NUS students who want to manage their tasks and modules well to achieve their dream CAP. <br>
Users will be able to browse and select modules, create and arrange tasks, add tasks to modules,<br>
create reminders, calculate and set goals for their MCs / CAPs.

## Contents

- [Preliminaries](#preliminaries)
  * [Installation](#installation)
  * [Running the program](#running-the-program)
  * [Guide format](#guide-format)
- [Features](#features)
- [Usage](#usage)
    * [`add` - Add task(s) to module(s)](#add---add-task-to-module)
    * [`bye` - Quit the program](#bye---quit-the-program)
    * [`cap` - Prints CAPs](#cap---calculate-caps)
    * [`clear` - Clear the task list](#clear---clear-the-task-list)
    * [`deadline` - Add a deadline to the task list](#deadline---add-a-deadline-to-the-task-list)
    * [`delete` - Delete a task from the task list](#delete---delete-a-task-from-the-task-list)
    * [`detail` - Prints item detail](#detail---Prints-item-detail)
    * [`done` - Mark a task as done](#done---mark-a-task-as-done)
    * [`edit` - Modify attributes of an item](#edit---Modify-attributes-of-an-item)
    * [`event` - Add an event to the task list](#event---add-an-event-to-the-task-list)
    * [`fancy` - Switch the UI to the fancy mode (GUI-like CLI)](#fancy---switch-the-ui-to-the-fancy-mode-(gui-like-cli))
    * [`find` - Find an event in the task list](#find---find-an-event-in-the-task-list)
    * [`focus` - Change the context of the program](#focus---change-the-context-of-the-program)
    * [`grade` - Add grade to course or module](#grade---add-grade-to-course-or-module)  
    * [`help` - Print help text of the commands](#help---print-help-text-of-the-commands)
    * [`list` - Print a list of added tasks](#list---print-a-list-of-added-tasks)
    * [`mc` - Prints MCs](#mc---prints-mcs)
    * [`next` - Switch the target region to the next page ***(GUI mode only)***](#next---switch-the-target-region-to-the-next-page)
    * [`plain` - Switch the UI to the plain mode (pure-text CLI)](#plain---switch-the-ui-to-the-plain-mode-(pure-text-cli))
    * [`prev` - Switch the target region to the previous page ***(GUI mode only)***](#prev---switch-the-target-region-to-the-previous-page)
    * [`postpone` - Postpone a task to a later date](#postpone---postpone-a-task-to-a-later-date)
    * [`reminder` - Print tasks that are due soon](#reminder---print-tasks-that-are-due-soon)
    * [`sel` - Select items by index](#sel---select-items-by-index)
    * [`snooze` - Delays reminder popup](#snooze---delays-reminder-popup)
    * [`stats` - Prints Statistics](#stats---Prints-Statistics)
    * [`take` - Take module(s)](#take---take-module)
    * [`todo` - Add a todo to the task list](#todo---add-a-todo-to-the-task-list)
    * [`undone` - Mark a task as undone](#undone---mark-a-task-as-undone)
    * [`unknown` - Prints error message](#unknown---prints-error-message)
    * [`unsel` - Unselect items](#unsel---unselect-items)
    * [`untake` - Untake module(s)](#untake---untake-module)
- [Triggering the syntax reminder](#triggering-the-syntax-reminder)
- [FAQ](#faq)
- [Command Summary](#command-summary)

## Preliminaries

### Installation

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `Domsun` from [Our Release Page](https://github.com/AY2021S1-CS2113-T13-2/tp/releases).

> Java 11 and above is highly recommended, although Domsun might run on a lower version.

### Running the program

Open your command line or terminal and navigate to the folder where you downloaded the jar file (e.g., `~/downloads`). 
Then simply run the comman ` -jaomsun.jar`:

```batch
$ cd ~/downloads
$ ls 
domsun.jar
$ java -jar domsun.jar
```

> Note: You can also run Domsun by double clicking the `domsun.jar` file directly.

### Domsun Tutorial 
Here is an overview of how Domsun works. It maintains 3 key lists that you should take note. 
![here](Images/Overview1pic2.PNG)

1. `focus` command focuses the app onto the list of task that you currently have. 
2. Likewise, `focus mod`focuses the app on the entire list of modules available in NUS, while `focus taken` is the list of taken modules of your choice. 
3. To add a task under a module, you may enter the command `add -task 1 2 -mod CS2113`. 1 and 2 here are indices of the tasks in the task list. So be sure to have some task added BEFORE typing this command. 
4. To mark a module as 'taken', you may enter `take CS2113 CS1010` while focusing on the module list by using `focus mod`. alternatively, you may use the indices method as before such as `take 1 2` to take the 1st and 2nd module available on the module list. 
5. The `list` commands follows the app's current focus. If it is focusing on list of task, typing list will show all task. Likewise for modules and taken. 
6. Typing `detail 1` when focusing on task list, will display the 1st index, task details. 
7. Note that `detail 2` here will display different results as the two indicies of 2 represent different modules! 

**A point to note before venturing into the libraries of commands that we have.**<br>
You can switch between fancy mode display, and plain display anytime during the program. 
During `list` command, you will be able to toggle between pages of fancy by using `prev` and `next`
However, the current version of fancy mode is still in beta, hence, it is expected to not be able to fully display certain commands that are too long. such as `help`, `detail`,`mc` etc. Do look forward to the next update!
![here](Images/Overview2 etes 



Features . 
. N

#### Addition and removal of tasks
The program allows user to add or delete tasks from the task list.<br>
The program also provides shortcuts such as the `clear` command to delete tasks quickly.

### Mark tasks as done or undone
The program allows user to mark tasks as done (denoted by `[V]`) or undone (denoted by `[X]`).

### List tasks and reorder them by their ***date*** field
The program allows user to list tasks in ascending order or descending order with respect to their ***date*** values.<br>
The program also allows the user to filter the task list and only display tasks within a specified date.

### Deadlines, Events and ToDo's
The program allows user to create 3 different kinds of tasks, *deadlines*, *events* and *todos*.<br>
*deadline* and *event* consists of both *description* and *time*, while *todo* does not contain *time*.<br>
The *time* field consists of a *date* part (such as `Oct 13 1998`), and a *time* part (such as `00:00`).<br>

### Fuzzy parsing
The program fuzzily parses user's inputs with respect to date and time.<br>
Supports any date format delimited by `" "`, `-` and `/`, with days, months and years in any order, such as 
`"Oct 13 1998"`, `13/10/193/98` and `1998-10-13`.<br>
Supports any time format delimited by `:` in 1 or 2 digits, such as13
`1:1:0`, `01:01:00`, `1:01` and, `01:1`. Does not support the notations "am" or c.

### Auto-save and auto-load
The program saves the tasks list automatically every time the list changes. <br>
When the program loads up, it looks for the last saved tasks list first and tries to load it.

### Syntax reminder
The program can remind the user of the syntax of a command if the command is correct but wrong syntax is present.

### Module operations
The program allows users to list modules, mark modules as taken or untaken, and score grades for each module.

### Find function
The program allows users to find items (tasks or modules) by keyword using the `find` command. 

### Dynamic target
The program operates data dynamically. Users can operate on items as-is in the displayed sequence,<br>
and need not follow the sequence of task creation or module addition.

### GUI inside CLI
The program has a GUI mode that accomplishes a GUI-like CLI interface using the ansi escape code sequence.<br> 
The user can use `fancy` to switch to the GUI mode and use `plain` to switch to plain text CLI mode.

### Link tasks to Modules
The program allows users to add some tasks to modules using the `add` command.

### Reminders
The program allows user to set reminders at certain time, or remind themselves of the most urgent tasks on start-up.

## Usage


## Features - Daily Tasks 

### `todo` - Add a todo to the task list

Typing `todo` allows the program to parse user's input and create a ***todo*** object with 
specified *description*. It will be appended to the end of the task list.

Syntax:

`todo [description]`

Example of usage: 

`todo class`

Expected outcome:

   ```  
    ____________________________________________________________
        Got it. I've added this task:
        [T][X] class
        Now you have 1 tasks in the list.
    ____________________________________________________________
   ```

### `deadline` - Add a deadline to the task list

Typing `deadline` allows the program to parse user's input and create a ***deadline*** object with 
specified *description* and *time*. It will be appended to the end of the task list.

Syntax: 

`deadline [description] /by [time]`

Example of usage:

`deadline ddl /by 21/9/15 1:12`

Expected outcome:

   ```  
    ____________________________________________________________
        Got it. I've added this task:
        [D][X] ddl (by: Sep 15 2021 01:12)
        Now you have 1 tasks in the list.
    ____________________________________________________________
   ```

 in the list.
    ____________________________________________________________
   ```

### `event   ```
    ____________________________________________________________
         task:
        [D][X] ddl (by: Sep 15 2021 01:12)
        Now you have 0 tasks` - Add an event to the task list

Typing `event` allows the program to parse user's input and create an ***event*** object with 
specified *description* and *time*. It will be appended to the end of the task list.

Syntax:

`event [description] /at [time]`

Example of usage: 

`event midterm exam /at May 13 2020 8:00`

Expected outcome:

   ```  
    ____________________________________________________________
        Got it. I've added this task:
        [E][X] midterm exam (at: May 13 2020 08:00)
        Now you have 1 tasks in the list.
    ____________________________________________________________
   ```

### `list` - Print a list of added tasks

Typing `list` commands the program to print either all added tasks or tasks at a specified *date*.<br>
The user can also control how the tasks printed are ordered with respect to *date*:<br>

The `asc` parameter tells the program to list tasks in ascending order with respect to their *date* field.<br>
The `desc` parameter tells the program to list tasks in descending order with respect to their *date* field.<br>
The `spec` parameter tells the program to only list tasks with the specified value of the *date* field.<br>

Note: with each execution of the `list` command, the indices of all tasks will be 
dynamically changed to refer to the task in the current list with the current indices.<br>
In other words, indices of tasks are not tied to their sequence of creation, allowing the user
to use commands much more flexibly, especially with the `find` command or the reordering parameters.

Syntax:

`list` <br> `list date [asc / desc / spec "date"]`, where `"date"` can be in any common date format.

Example of usage: 

`list`

Expected outcome:

   ```  
    ____________________________________________________________
        Here is the list ofNoted. I've removed this tasks:
        1.[D][X] math exam (by: Oct 15 2020 10:30)
        2.[D][X] CS exam (by: Oct 18 2020 15:00)
        3.[E][X] exam review session (at: Oct 01 2020 08:00)
    ____________________________________________________________
   ```

Example of usage: 

`list date asc`

Expected outcome:

   ```  
    ____________________________________________________________
        Here is the list of tasks:
        1.[E][X] exam review session (at: Oct 01 2020 08:00)
        2.[D][X] math exam (by: Oct 15 2020 10:30)
        3.[D][X] CS exam (by: Oct 18 2020 15:00)
    ____________________________________________________________
   ```

Example of usage: 

`list date spec 10/15/20`

Expected outcome:

   ```  
    ____________________________________________________________
        Here is the list of tasks:
        1.[D][X] math exam (by: Oct 15 2020 10:30)
    ____________________________________________________________
   ```


### `done` - Mark a task as done

Typing `done` allows the user to mark the task at a specified *index* as **done**.<br>
Note: *index* can be an integer number or a letter (`A` or `a` corresponds to 1).

Syntax:

`done [index]`

Example of usage: 

`done 1`

Expected outcome:

   ```  
    ____________________________________________________________
        Nice! I've marked this task as done:
        [D][V] ddl (by: Sep 15 2021 01:12)
    ____________________________________________________________
   ```


### `undone` - Mark a task as undone

Typing `undone` allows the user to mark the task at a specified *index* as **undone**.<br>
Note: *index* can be an integer number or a letter (`A` or `a` corresponds to 1).

Syntax:

`undone [index]`

Example of usage: 

`undone 1`

Expected outcome:

   ```  
    ____________________________________________________________
        Nice! I've marked this task as undone:
        [DE][X] math exam (by: Oct 15 2020 10:30)
    ____________________________________________________________
   ```


### `find` - Find an event in the task list

Typing `find` commands the program to search through the task list and print all tasks with the
specified *keyword*. If there is no task with such a *keyword*, `[NOT FOUND]` will be printed instead.

Syntax:

`find [keyword]`

Example of usage: 

`find exam`

Expected outcome (found):

   ```  
    ____________________________________________________________
        Tasks with the specified keyword are:
        1.[D][X] math exam (by: Oct 15 2020 10:30)
        2.[D][X] CS exam (by: Oct 18 2020 15:00)
        3.[E][X] exam review session (at: Oct 01 2020 08:00)
    ____________________________________________________________
   ```

Expected outcome (not found):

   ```  
    ____________________________________________________________
        Tasks with the specified keyword are:
        [NOT FOUND]
    ____________________________________________________________
   ```

### `postpone` - Postpone a task by index

Typing `postpone` delays a task specified by the user or by default a day.<br>
Note: Option `h` for an hour. Option `w` for a week. Option `y` for a year.

Syntax:

`postpone [index]` <br>
`postpone [h/w/y] [index]` 

Example of usage:

`postpone 1`

Expected outcome:
 
    ```
    ____________________________________________________________
        I've postpone this task:
        [D][X] project submission (by: Sep 16 2021 01:12)
    ____________________________________________________________
    ```

Example of usage:

`postpone h 1`

Expected outcome:
    
    ```
    ____________________________________________________________
        I've postpone this task:
        [D][X] project submission (by: Sep 16 2021 02:12)
    ____________________________________________________________
    ```

Example of usage:

`postpone w 1`

Expected outcome:

    ```
    ____________________________________________________________
        I've postpone this task:
        [D][X] project submission (by: Sep 23 2021 02:12)
    ____________________________________________________________
    ```

Example of usage:

`postpone y 1`

Expected outcome:

    ```
    ____________________________________________________________
        I've postpone this task:
        [D][X] project submission (by: Sep 23 2022 02:12)
    ____________________________________________________________
    ```


### `reminder` - Print tasks that are due soon

Typing `reminder` prints the tasks that are due within a certain time range or to activate the reminder.<br>
Note: The reminder popup is set by default to emerge every 5 minutes.  

Syntax:

`reminder` <br>
`reminder [on/off]`

Example of usage: 

`reminder`

Expected outcome:

   ```  
    ____________________________________________________________
    Here are the tasks due within 3 days: 
    [D][X] submission 2 (by: Oct 15 2020 02:00)
    ____________________________________________________________
   ```
Example of usage:

`reminder on`

Expected outcome:

   ```  
    ____________________________________________________________
    Here are the tasks due within 3 days: 
    [D][X] submission 2 (by: Oct 15 2020 02:00)
    ____________________________________________________________
   ```

Example of usage:

`reminder off`

Expected outcome:

   ```  
    ____________________________________________________________

    ____________________________________________________________
   ```


### `snooze` - Delays reminder popup

Typing `snooze` delays reminder popup by a default of 1 minute.

Syntax:

`snooze`

Example of usage:

`snooze`

Expected outcome:

    ```
    ____________________________________________________________
        I've snoozed the reminder for 1 minute. Will remind you in 6 minutes.
    ____________________________________________________________    
    ```


## Features - Module Planner 

### `take` - Take module

Typing `take` marks specified module(s) as taken.

Syntax:

`take [index(es) / module code(s) (for modules only)]`

Example of usage: 

`take CS2113 CS2113T`

Expected outcome:

   ```  
    ____________________________________________________________
    I have marked these modules as taken:
    Module: CS2113
    Module: CS2113T
    ____________________________________________________________
   ```

### `untake` - Untake module

Typing `untake` marks specified module(s) as not taken.

Syntax:

`untake [index(es) / module code(s) (for modules only)]`

Example of usage: 

`untake CS2113T`

Expected outcome:

   ```  
    ____________________________________________________________
    I have marked these modules as not taken:
    Module: CS2113T
    ____________________________________________________________
   ```

### `sel` - Select items by index

Typing `sel` selects the items specified.

Syntax:

`sel [index(es) (for the currently listed items) / module code(s) (for modules only)]`
ed on selected option.
        Use "help [target]" to see details :) Try "help help"!
    ____________________________________________________________
   ```
Example of usage: 

`sel 1 2 3`

Expected outcome:

   ```  
    ____________________________________________________________
    I have selected the items you specified:
    Item 1: borrow book
    Item 2: eat
    Item 3: jumping
    ____________________________________________________________

   ```



### `unsel` - Unselect items

Typing `unsel` marks items specified as unselected.

Syntax:

`unsel [index(es) (for the currently listed items) / module code(s) (for modules only)]`

Example of usage: 

`unsel 1 2 3`

Expected outcome:

   ```  
    ____________________________________________________________
    I have un-selected the items you specified:
    Item 1: borrow book
    Item 2: eat
    Item 3: jumping
    ____________________________________________________________
   ```

### `detail` - Prints item detail
Typing `detail` prints the details of a specified item.

Syntax:

`detail [module code (for modules only) / index]
        2.[D][X] CS exam (by: Oct 18 2020 15:00)
        3.[E][X] exam review session (at: Oct 01 2020 08:00)
    ____________________________________________________________
   ```

Example of usage: 

`detail 1`

Expected outcome:

   ```  
    ____________________________________________________________
    Here areis the details you requested:
    Item 1: [T][X] borrow booklist of tasks:
        1.[E][X] exam review session (at: Oct 01 2020 08:00)
        2.[D][X] math exam (by: Oct 15 2020 10:30)
        3.[D][X] CS exam (by: Oct 18 2020 15:00)
    ____________________________________________________________
   ```

Example of usage: 

`detail CS2113T`

Expected outcome:

   ```  
    ____________________________________________________________
    Here are the details you requested:
    Item: CS2113T Software Engineering & Object-Oriented Programming 4MC
    "This module introduces the necessary skills for systematic and rigorous development of software sys
    tems. It covers requirements, design, implementation, quality assurance, and project management aspe
    cts of small-to-medium size multi-person software projects. The module uses the Object Oriented Prog
    ramming paradigm. Students of this module will receive hands-on practice of tools commonly used in t
    he industry, such as test automation tools, build automation tools, and code revisioning tools will 
    be covered.
    Tasks: [NOT FOUND]    Here is the list of tasks:
        1.[D][X] math exam (by: Oct 15 2020 10:30)
    ____________________________________________________________
   ```


### `grade` - Add grade to course or module

Typing `grade` allows the user to add grade to the user's taken course or module.

Syntax:

`grade` <br>
`grade [-option] [module] [grade] {[module] [grade]...}` <br>

`option: -s(show, default), -a(add)`

Example of usage:

`grade -a CS2113 A- CG1112 A-`

Expected outcome:

    ____________________________________________________________
        These are your grades so far:
        1. CS2113   A-
        2. CG1112   A-
    ____________________________________________________________
    
Example of usage:

`grade`

Expected outcome:

    ____________________________________________________________
        These are your grades so far:
        1. CG1112   A-
        2. CS1010   A
        3. CS1231   B
        4. CS2040C  A
        5. CS2113   A-
    ____________________________________________________________
    

### `goal` - Calculate how far the user is from his/her target CAP

Typing `goal` allows the user to calculate how far the user is from his/her target CAP.

Syntax:

`goal [-option] [total MC] [target CAP] {[taken MC] [current CAP]}` <br>

`option: -u(user's cap and mc), -c(custom cap and mc)`

Example of usage:

`goal -c 160 4.9 100 4.5`

Expected outcome:

    ____________________________________________________________
        Your required average CAP is: 5.57
        Looks like the target is a bit far away TT
    ____________________________________________________________
    
Example of usage:

`goal -u 160 4.9`

Expected outcome:

    ____________________________________________________________
        Your required average CAP is: 4.89
        Jia you! :D
    ____________________________________________________________
    

### `mc` - Prints MCs

Typing `mc` prints the number of MCs based on selected option. By default, this command focuses on the entire module list. In order to print the MC of taken modules, do remember to enter 'focus taken' before proceeding with this command. 

Syntax:

`mc [-option] [-detail]` <br>
`option: -d(detailed)`

Example of usage (when there are modules in the target): 

`mc`

Expected outcome:

   ```  
    ____________________________________________________________
    Here is the total MC:
    22
    ____________________________________________________________
   ```
Example of usage (when there are modules in the target): 

`mc -d`

Expected outcome:

   ```  
    ____________________________________________________________
    Here is the total MC:
    EE1001: 4MCs
    EE1001X: 4MCs
    EE1002: 4MCs
    EE1003: 4MCs
    EE1111: 6MCs
    ____________________________________________________________
   ```

### `cap` - Prints CAPs

Typing `mc` prints the calculated CAP for courses based on selected option.

Syntax:

`cap [-option] [module] [grade] {[module] [grade]...}`
`option: -u(user, default), -m(multiple/custom modules)`

Example of usage (when there are modules in the target): 

`cap`

Expected outcome:

   ```  
    ____________________________________________________________
    Here is your existing CAP: 4.00
    ____________________________________________________________
   ```
Example of usage (when there are modules in the target): 

`cap -m CS2113 A CS1010 B`

Expected outcome:

   ```  
    ____________________________________________________________
    Here is your existing CAP: 4.25
    ____________________________________________________________
   ```


## Features - General Features for both Daily Tasks & Module Planner

### `add` - Add task to module

Typing `add` adds specified task(s) to specified module(s).

Syntax:

`add -task [index(es)] -mod [module code(s)]`

Example of usage: 

`add -task 1 2 -mod CS2113 CS2113T`

Expected outcome:

   ```  
    ____________________________________________________________
    I have added the specified tasks to the specified modules.
    CS2113 << tasks: borrow book; eat; 
    CS2113T << tasks: borrow book; eat; 
    ____________________________________________________________
   ```

### `clear` - Clear the task list

Typing `clear` results in the program deleting all added tasks from the task list.

Example of usage: 

`clear`

Expected outcome:

   ```  
    ____________________________________________________________
        Nice! I've cleared everything in the list.
    ____________________________________________________________
   ```

### `delete` - Delete a task from the task list

Typing `delete` deletes the task with specified *index* from the current task list.<br>
Note: *index* can be an integer number or a letter (`A` or `a` corresponds to 1).

Syntax:

`delete [index]`

Example of usage: 

`delete 1`

Expected outcome:
    ```
    ____________________________________________________________
        
    ____________________________________________________________
    ```  

### `edit` - Modify attributes of an item

Typing `edit ` modifies the attributes of an task or module

Syntax:

`edit [-mod / -task] [index / code (for module only)] [field=new value]`

`No space allowed around "=". Use "_" in place of space for the "[field=new value]" parameters`


Example of usage:
`edit -mod CS2113T grade=A`

Exepected outcome:
    
    ```
    ____________________________________________________________
        Trying to modify the attribute(s) you specified:
        grade=A; 
    ____________________________________________________________
    ```

Example of usage:
`edit -task 1 description=do_homework`

Expected outcome:
    
    ```
    ____________________________________________________________
        Trying to modify the attribute(s) you specified:
        description=do homework; 
    ____________________________________________________________
    list
    ____________________________________________________________
        Here is the list of items:
        1.[T][X] do homework
        2.[T][X] blah
    ```

Example of usage:
`edit -task 1 type=event`
    
Expected outcome:
    
    ```
    ____________________________________________________________
        Trying to modify the attribute(s) you specified:
        type=event; 
    ____________________________________________________________
    list
    ____________________________________________________________
        Here is the list of items:
        1.[E][X] do homework (at: Jan 01 2021 00:00)
        2.[T][X] blah    

    ```

Example of usage:
`edit -mod CS2113 grade=A -task 1 description=do_homework type=event`

Expected outcome:

    ```
    ____________________________________________________________
        Trying to modify the attribute(s) you specified:
        grade=A; 
        description=do homework; type=event; 
    ____________________________________________________________
    list
    ____________________________________________________________
        Here is the list of items:
        1.[E][X] do homework (at: Jan 01 2021 00:00)
        2.[T][X] blah
    ```



### `focus` - Change the context of the program

Typing `focus` changes the context that all other commands are based on to the specified target. <br>
If no parameter is provided, the program will focus on `task`. <br>
Other commands such as `list`, `done`, `sel`, etc. all operated based on the current focused context.

Syntax:

`focus`
`focus [deadline / todo / event / task / mod / selected / taken]`

Example of usage: 

`focus mod`

Expected outcome:

   ```  
    ____________________________________________________________
    Now we are focusing on:
    mod
    ____________________________________________________________
   ```
Example of usage: 

`focus`

Expected outcome:

   ```  
    ____________________________________________________________
    Now we are focusing on:
    task
    ____________________________________________________________
   ```

### `stats` - Prints Statistics

Typing `stats` prints the percentage of the task completed.

Syntax:

`stats [-option] [-detail]` <br>
`option: -mod` <br>
`detail: [module code]`

Example of usage (when focused on task list, and no task is completed): 

`stats`

Expected outcome:

   ```  
    ____________________________________________________________
    Here are the statistics: 
    [0.0%]
    ____________________________________________________________
   ```
Example of usage (when checking specific modules, with all task completed): 

`stats -mod CS2113 `

Expected outcome:

   ```  
    ____________________________________________________________
    Here are the statistics: 
    [100.0%]
    ____________________________________________________________
   ```

### `help` - Print help text of the commands

Typing `help` allows the user to either print a list of available commands, 
or print the details of a specified command.

Syntax:

`help` <br> `help [target]`

Example of usage: 

`hel`

Expected outcome:

   ```  
    ____________________________________________________________
    I have selected the items you specified:
    Item 1: borrow book
    Item 2: eat
    Item 3: jumping
    ____________________________________________________________
   ```

### `take` - Take module

Typing `take` marks specified module(s) as taken.

Syntax:

`take [index(es) / module code(s) (for modules only)]`

Example of usage: 

`helptake CS2113 CS2113T`

Expected outcome:

   ```  
    ____________________________________________________________
        Here are all available commands:
        Command: bye  Description: Quit the program
        Command: clear  Description: Clear the task list
        Command: deadline  Description: Add a deadline to the task list
        Command: delete  Description: Delete a task from the task list
        Command: done  Description: Mark a task as done
        Command: event  Description: Add an event to the task list
        Command: find  Description: Find an event in the task list with the specified keyword
        Command: help  Description: Print the list of available commands, or print the details of a specified command
        Command: focus  Description: Change context. Changes the target of other commands to the specified target
        Command: reminder  Description: List out events and deadlines tasks that are due within 3 days
        Command: list  Description: Print a list of tasks/modules depending on the current Focus
        Command: todo  Description: Add a todo to the task list
        Command: undone  Description: Mark a task as undone
        Command: unknown  Description: Prints the error message for an unrecognized command for debugging purposes
        Command: next  Description: Switch the target region to the next page, keeping other regions unchanged.
        Command: prev  Description: Switch the target region to the previous page, keeping other regions unchanged.
        Command: fancy  Description: Switch to a fancy Cli (requires the shell to support ansi codes).
        Command: plain  Description: Switch to a plain Cli.
        Command: sel  Description: Make selection: Add specified item(s) to the selection.
        Command: unsel  Description: Cancel selection: Make specified item(s) no longer selected.
        Command: add  Description: Add task(s) to module(s): Add specified task(s) to specified module(s).
        Command: take  Description: Take module(s): Mark specified module(s) as taken.
        Command: untake  Description: Untake module(s): Mark specified module(s) as not taken.
        Command: mc  Description: Print MCs: Print the number of MCs based on selected option.
        Command: detail  Description: Print Details: Print the details of a specified module.
        Command: cap  Description: Calculate CAP: Calculate CAP for courses based on selected option.
        Use "help [target]" to see details :) Try "help help"!
    ____________________________________________________________
   ```
Example of usage: 

`help list`

Expected outcome:

   ```
    ____________________________________________________________
        Name: list
        Description: Print a list of items depending on the current Focus
        Syntax:
        list
        list date [asc / desc / spec "date"(any common date format)]
        Usages:
        1. "list" >> list all added items
        2. "list date asc" >> list items with a "date" field in ascending order
        3. "list date spec Oct 5 2020" >> list items with specific "date" field of Oct 5 2020
    ____________________________________________________________

   ```


### `fancy` - Switch the UI to the fancy mode (GUI-like CLI)

Typing `fancy` switches the UI to the fancy mode (GUI-like CLI interface).<br>
This command has no effect if the UI is already in fancy mode.<br>
The fancy mode only shows correctly if your terminal supports ansi escape codes.

Syntax:

`fancy`

Example of usage: 

`fancy`

Expected outcome:

the UI switches to fancy mode (GUI-like CLI interface).


### `plain` - Switch the UI to the plain mode (pure-text CLI)

Typing `plain` switches the UI to the plain mode (pure-text CLI interface). <br>
This command has no effect if the UI is already in plain mode.<br>
The plain mode shows correctly on all terminals.

Syntax:

`plain   ```  
    ____________________________________________________________
        Got it. I've added this task:
        [T][X] class
        Now you have 1 tasks in the list.
    ____________________________________________________________
   ```

### `undone` - Mark a task as undone

Typing `undone` allows the user to mark the task at a specified *index* as **undone**.<br>
Note: *index* can be an integer number or a letter (`A` or `a` corresponds to 1).

Syntax:

`undone [index]`

Example of usage: 

`plain`

Expected outcome:

The UI switches to plain mode (pure-text CLI interface).


### `next` - Switch the target region to the next page

Typing `next` switches the target region to the next page, should a next page exist.<br>
This command has no effect on pure text CLI mode.

Syntax:

`next [region]` <br>
`region: i(item list), s(selection), a(all, default)`

Example of usage: 

`next`

Expected outcome ***(GUI mode only)***:

The both regions of the GUI are switched to the next page if a next page is available.

Example of usage: 

`next i`

Expected outcome ***(GUI mode only)***:

The item list region (top) of the GUI is switched to the next page if a next page is available.


### `prev` - Switch the target region to the previous page

Typing `prev` switches the target region to the previous page, should a previous page exist.<br>
This command has no effect on pure text CLI mode.

Syntax:

`prev [region]` <br>
`region: i(item list), s(selection), a(all, default)`

Example of usage: 

`prev`

Expected outcome ***(GUI mode only)***:

The both regions of the GUI are switched to the pevious page if a previous page is available.

Example of usage: 

`prev i`

Expected outcome ***(GUI mode only)***:

The item list region (top) of the GUI is switched to the previous page if a previous page is available.



### `unknown` - Prints error message

Typing `unknown` or any string that is not a command will trigger the `unknown` command.<br>
The `unknown` command prints an error message for debug purposes, it is also the default behaviour of the program
when it fails to recognize the user's command. <br>

Note: If the program recognizes the command successfully, yet fails to find required parameters, 
it will not trigger this `unknown` command. It will print a syntax error and remind the user of
the correct syntax instead.

Syntax:

`unknown` <br> `[anything that is not a command]`

Example of usage: 

`who is duke?`

Expected outcome:

   ```  
    ____________________________________________________________
        OOPS, I don't know what that means :-( Try "help"!
    ____________________________________________________________
   ```

### `bye` - Quit the program

Typing `bye` results in the program saving the current task list to a local file named 
`./data/duke.txt`, and then quitting the program.unsel` - Unselect items

Typing `unsel` marks items specified as unselected.

Syntax:

`unsel [index(es) (for the currently listed items) / module code(s) (for modules only)]`

Example of usage: 

``

Expected outcome:

   ```  
    ____________________________________________________________
    
    ____________________________________________________________
   ```


### Triggering the syntax reminder

Typing a correct command with wrong syntax will trigger the syntax reminder.

Example of usage:

`deadline /at 10-10-10`<br>

Note that the command `deadline` is a correct command, but:<br>
1. Description is missing
2. Parameter name is wrong

Expected outcome:

   ```  
    ____________________________________________________________
        Invalid Command! Please check the syntax.
        deadline [description] /by [time]
    ____________________________________________________________
   ```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Send the `data` folder in your program directory to the program directory on your new device.

**Q**: How do I run this program ?

**A**: To run this program execute the jar file by ‘java -jar domnus.jar’

## Command Summary

A cheat sheet of commonly used commands:

### Daily Tasks
|**Action** | **Format**| **Examples**|
|------------|-------------|-------------|
|**todo**|`todo [description]`|`todo borrow book`|
|**deadline**|`deadline [description] -by [time]`|`deadline project submission -by 21/9/15 1:12`|
|**event**|`event [description] -at [time]`|`event concert -at May 13 2020 8:00`|
|**list**|`list date [asc / desc / spec “date”]`|`list date asc`|
|**done**|`done [index]`|`done 2`|
|**undone**|`undondelete [index]`|`undone 2`|
|**find**|`find [keyword]`|`find exam`|
|**postpone**| `postpone [index]`|`postpone 1`|
|**reminder**|`reminder [on/off]` |`reminder`|
|**snooze**|`snooze`||


### Module Planner
|**Action** | **Format**| **Examples**|
|------------|-------------|-------------|
|**take**|`take [index / module code]`|`take CS2113T`|
|**untake**|`untake [index / module code]`|`untake CS2113T`|
|**sel**|`sel [index / module code]`|`sel 1 2 3`|
|**unsel**|`unsel [index / module code]`|`unsel CS1010 CS2113`|
|**detail**|`detail [index / module code]`|`detail CS2113T`|
|**grade**|`grade [-option] [module] [grade] {[module] [grade]...}`|`grade -a CS2113 A CG1112 A-`|
|**goal**|`goal [-option] [total MC] [target CAP] [taken MC] [current CAP]`|`goal -c 160 4.9 100 4.5`|
|**mc**|`mc [-option] [-details]`|`mc -p`|
|**cap**|`cap [-option] [module] [grade] {[module] [grade]...}`|`cap -m CS2113 A CG1112 A-`|


### General Features
|**Action** | **Format**| **Examples**|
|------------|-------------|-------------|
|**add**|`add -task [index] -mod [module code]`|`add -task 1 -mod CS2113`|
|**clear** | `clear`||
|**delete**|`delete [index]`|`delete 2`|
|**edit**|`edit [-mod / -task] [index / code (for module only)]`|`edit -mod CS2113 grade=A -task 1 description=do_homework type=event`|
|**focus**|`focus [deadline / todo / event / task / mod / selected / taken]`|`focus deadline`|
|**stats**|`stats [target]`| `stats`|
|**help**|`help [options]`|`help deadline`|
|**fancy**|`fancy [option]`|`fancy`|
|**plain**|`plain [option]`|`plain`|
|**next**|`next [option]`|`next`|
|**prev**|`prev [option]`|`prev`|
|**bye**|`bye`||
<!--stackedit_data:
eyJoaXN0b3J5IjpbNDYzOTEzMjQ1XX0=
-->