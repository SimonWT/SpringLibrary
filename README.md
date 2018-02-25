

 **DeepLib** 
 ====================
#### Innovation in Libraray Managment System

------------------------------

### **How to install our project on your PC** 

Install: Java 1.8, 
         MySQL Server(if no internet connection)
         Intelliji IDEA Ultimate

1. Download from this repository .zip and unarchive
2. Open Intellij Idea -> "Open" -> "Choose unarchived project-folder"
3. Setup Java SDK from your location.
4. If you have Internet Connection, that's all. Else you should install MySQL Server on your pc, start local mysql server, export .sql files from %Project-Folder%/MySQL/Dumps/Dumps+"lastdate"/
    And in IDEA in class src/main/java/DB/DBtest.class edit DB_URL, DB_USER, DB_PASS with access data of your local MySQL server.
5. If Intellij propose to import new files, click on "Auto-Import". In the case,you have a problem, as, when you didn't have reference
                                                                       to click, you should open File/Settings/Maven/Importing and then you should tick on "Import Maven project Automatically"
6. You should upload Maven( to start your project), you can use this link as help "https://habrahabr.ru/post/77382/".
7. In console you should print:   mvn jetty:run
 #### To start WEB-application compile src/main/java/Main/main.class and at Web-browser put in address line "localhost:8080"
 
 ### For check TEST CASES:
 
 1. Go to src/main/java/TestCases/
 2. And compile all of the classes inside this package
 
 


