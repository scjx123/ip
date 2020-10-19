# Developer Guide

## Design & implementation
The Architecture Diagram below represents a high-level design overview of the App. Specifically, it is done with an n-tier architectural style, where the higher layers make use of services provided by lower layers. 

![here](Architecture_Diagram.PNG)

**Main**
For the main layer, it contains a single class known as Duke. e app launch, Duke  to load any previous data from storage and followed by running the components of the app in sequence. Upon shutting down,  Duke calls upon method to save user's data automatically.  
**UI**
**Command Interpreter**
**Executer**
**Storage**


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE2MTA4MTgyNTYsLTE4NzIxMjcwMzQsOD
I2NDIwNzI2LDE0NjA0ODcyMjAsMTgxODUwMTk1MCwtMTgwNjAy
NjAsMjAxNTA2MjExMCwxMTUyMDk5MTgzLDE3NTgzOTc2MTRdfQ
==
-->