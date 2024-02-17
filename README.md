# _**Tetris Game Challenge**_

I tried to build it using the microservice concept (Breaking into layer so that each layer will perform its task independently and loosely coupled.) Using this concept has its own perk
when it comes to scalability and reusability(codes and functions). But i am not leveraging SpringBoot entirely. Its just Maven with simple Java Microservice layering.

## **Installation:-**

Its a simple Java program. So a simple import into IntelliJ would be good enough to auto-configure the Java JDK and you can run/trigger the Main function from Main class and provide
inputs via IDEA terminal but in case you want to trigger the Application via System's Terminal here are few useful steps along with links:-

1) Code repository is in Package Structure and a Maven build, So we require to install Maven and provide its Jre location to path variable to trigger it via terminal.
2) Useful link for Maven Installtion, Build and Run from cmd can be found here:- https://stackoverflow.com/questions/61156178/how-to-compile-and-execute-a-java-project-from-the-command-line
3) Maven Installation help :- https://maven.apache.org/install.html
4) If you are facing issues in setting up Java JDK path here is a solution link :- https://stackoverflow.com/questions/22842743/how-to-set-java-home-environment-variable-on-mac-os-x-10-9
5) Setup Maven Jre path into System's Enviornment path :- https://www.cyberciti.biz/faq/appleosx-bash-unix-change-set-path-environment-variable/
6) After all these above steps done , run these commands to Build and Run application from cmd inside the Tetris game package:-

   i) mvn compile

       assassin17@Souravs-Air Tetris_programming_challenge % mvn compile
   
   ii) mvn package

       assassin17@Souravs-Air Tetris_programming_challenge % mvn package
   
   iii) java -jar <path_to_SNAPSHOT.jar> (usually created in Target folder)

       assassin17@Souravs-Air Tetris_programming_challenge % java -jar /Users/assassin17/Desktop/Tetris_programming_challenge/target/tetris-1.0-SNAPSHOT.jar

### Dive Right into Code...

#### Code Structure
```
├───src
│   ├───main
│   │   ├───java
│   │   │   │   Main.java // Main method's in here.
│   │   │   ├───Bean
|   |   |   |       Shape.java
|   |   |   ├───Handler
|   |   |   |       ShapeHandler.java
|   |   |   ├───Interface
|   |   |   |       ShapeAndOrientation.java
|   |   |   ├───Service
|   |   |   |       GameLogic.java
│   │   │
│   │   └───resources
│   │           applicationIDs.tmp
│   │           applications.csv
│   │
│   └───test
│       └───java
└───target
```

Each class is quite self-explanatory work wise but i will try to keep it short:-

Shape is bean to store block shape, Coordinates it will occupy in 2D space matrix column wise, and height of shape block. Interface to implement certain enhancements in future for the
game play. Handler to impliment certain methods of the Interface class and the GameLogic class which has the Algo and Idea for the Game Play.

Keeping in mind the constraint of time, I tried to develop the game in simplest way possible. Using the concept of 2D Matrix to track where the pieces are coming and getting placed
inside the grid. A simple Array to store the Maximum Columns height for each column inside grid (Eg. in our case its 0-9 in size) so that we can avoid multiple iteration/traversing of the 2D Matrix.
Last but not the least using the knowledge of each piece and their shape, orientation in 2D space and converting these information into 2D points in space.

    Space Complexity - O(N*N)
    Time Complexity - O(N*N)

Hope you like it, Shout out if you face any issues while playing :)

### Happy Gaming :D 
