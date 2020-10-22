# Developer Guide

## 1. Table of content
**1. Table of content**
2. Introduction
	2.1 Purpose of Document
	2.2 Audience
	2.3 Documentation Organization 
	2.4 User Guide
	2.5 Markup  
3. Setting Up 
4. Design 
5. Implementation
6. Appendix A Product Scope 
7. Appendix B User Stories 
8. Appendix C Use Cases 
9. Appendix D Non-funcitonal Requirements 
10. Appendix E Glossary 
11. Appendix F. Instruction for Manual Testing  

## 2. Introduction

## 3. Setting Up


## Design

The Architecture Diagram below represents a high-level design overview of the App. Specifically, it is done with an n-tier architectural style, where the higher layers make use of services provided by lower layers. 

![here](Architecture_Diagram.PNG)

**Main**
For the main layer, it contains a single class known as *Duke*. 
Main's interaction with Storage 
When the app launches, Duke loads any previous data from storage and then connects the components of the app in sequence. Upon shutting down,  Duke calls upon method to save user's data automatically.  

Main's interaction with UI
Main gets user input and displays messages through the use of UI component. 

Main's interaction with Command Interpreter 
Upon receiving command from the UI, Duke would pass the entire user input into Command Interpreter (CI)

Main's interaction with Execute 
Once CI processed the user input, duke proceeds to redirect the input to Execute for execution of action. 

**UI**
**Command Interpreter**
**Executer**
**Storage**

## Implementation
[add ur individual features here]




## Appendix A. Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## Appendix B. User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Appendix C. Non-Functional Requirements

{Give non-functional requirements}

## Appendix D. Glossary

* *glossary item* - Definition

## Appendix E. Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
<!--stackedit_data:
eyJoaXN0b3J5IjpbNzIyNjcwNDc3LC0xNjkxNDk0MjM2LC0yNj
I2NDMzMjgsLTE4NzIxMjcwMzQsODI2NDIwNzI2LDE0NjA0ODcy
MjAsMTgxODUwMTk1MCwtMTgwNjAyNjAsMjAxNTA2MjExMCwxMT
UyMDk5MTgzLDE3NTgzOTc2MTRdfQ==
-->