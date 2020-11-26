### This project is to simulate dice game

#### Build & Instruction

#### Env
1. Maven 3.6.0
2. Java 8


### Assumption
#### Rank should be assigned only when points are earned
#### sysout has been used instead of logging


#### How to Run
1. Go to root project directory
2. Hit command mvn clean install 
3. Executable jar gets created inside target/ with name <DiceGame-1.0-SNAPSHOT.jar>
4. Run command by passing necessary argument 
java -jar <jarfileName> <noOfPlayers> <points_to_accumulate>
where 
noOfPlayers : No Of Players ,
points_to_accumulate : Points to Accmulate

When it ask for user input please enter the same

For example : 
java -jar target/DiceGame-1.0-SNAPSHOT.jar 2 10
