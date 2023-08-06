# class-AdvancedJava
Files for the UAH course

# Errata

Java continues to evolve over the years, and some of the technology changes or becomes obsolete. I will
update the course materials with the changes as I can. But until I do, I'll list them here.

https://en.wikipedia.org/wiki/Java_version_history

## RMI

Java 9 introduced the [concept of Modules](https://www.oracle.com/corporate/features/understanding-java-9-modules.html) that improves security, but requires changes to the RMI code in this course. I need to add a recording on these modules, and I need to update the RMI code. Until then you must use an earlier Java version. Your UAH VM has a working version of Java.

## Derby

Beginning with java 9, Derby is no longer included with the JDK. The JDK "db" directory no longer exists. Here is how to download and install Derby into the JDK directory:

  - Pick the latest version of derby and download the ZIP file. I use this mirror: [https://mirror.olnevhost.net/pub/apache/db/derby/](https://mirror.olnevhost.net/pub/apache/db/derby/)
  - Copy the root "db-derby-XXXXX-bin" directory to your JDK directory where you expected to find derby. Change the name to just "db" as you copy it.
  
For my version of JDK and Derby this is what I did: 
  - Downloaded the ZIP file "db-derby-10.15.2.0-bin.zip" to the desktop
  - Opened the windows File Explorer, right clicked the ZIP file, and extracted it to the desktop
  - Renamed the new folder on the desktop to just "db"
  - Used the File Explorer to copy the "db" folder to "C:\Program Files\Java\jdk-11.0.3"

A added the "derbyclient.jar" and the "derbynet.jar" to connect to the DB.

## Module 1 
### Introduction

This all needs reworking. Reference parts of the syllabus, but do so vaguely so it can be updated going forward.

There is no longer a virutal lab machine. I'll show you how to install Java and Eclipse on your own computer.

GitHub reference to the course materials. Poke around the repo for examples and hints.

| Slide | Title | Needed Updates |
| ----- | ----- | -----          |
| 1-2   | Welcome                | `Rework` |
| 3     | About Your Instructor  | `Rework` |
| 4     | Syllabus               | `Rework` |
| 5     | Virtual Lab Machine and Course Instructions | `Rework/Remove` |

### A-01 Eclipse

This is copied from Intro Java

### A-02 Concurrency
| Slide | Title | Needed Updates |
| ----- | ----- | -----          |
| 1 | Overview                | |
| 2 | More Info | `replace 2nd link` |
| 3 | CPU Review | |
| 4 | Two Things at Once | |
| 5-6 | Asynchronous Callbacks | |
| 7-8 | Multiple Threads | |
| 9 | Multiple Cores | |
| 10 | Multiple Processes | |
| 11 | Thread Woes | |
| 12 | Your Turn | `no discussion forum referenced a couple times` |

### A-03 Thread Basics
