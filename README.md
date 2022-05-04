# Individual Project 

## Instructions to build the project and steps to execute:

1.	Clone the repository: https://github.com/gopinathsjsu/individual-project-PriyankaMath
2.	Open the command line where the project directory is located (where pom.xml is found) and execute below steps
  ●	mvn compile
  ●	mvn clean install
  ●	Execute the below maven command to execute with arguments (Path to where the input file is located and path to where output file should be located) passed via           command line
      ○	mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="<arg1> <arg2 > <arg3> <arg4>"
      ○	arg1 – path to the input data (Sample.csv)
      ○	arg2 – path to flight details (flights.csv)
      ○	arg3 – path to Output.csv
      ○	arg4 – path to Output.txt

## Screenshots of execution steps:
  1.	mvn compile
  ![image](https://user-images.githubusercontent.com/21059586/166619420-9fcb0639-f95e-4011-81be-ad03d7d12068.png)

  2.	mvn clean install
  ![image](https://user-images.githubusercontent.com/21059586/166619442-69590879-d79d-45d5-b327-d7c929471ead.png)
  
  ![image](https://user-images.githubusercontent.com/21059586/166619452-fa960626-fec2-4488-a335-419077bf7422.png)
  
  3.	mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="C:\Priyanka\SJSU\202\files\Sample.csv C:\Priyanka\SJSU\202\files\flights.csv C:\Priyanka\SJSU\202\files\Output.csv C:\Priyanka\SJSU\202\files\Output.txt"
  
  ![image](https://user-images.githubusercontent.com/21059586/166619472-d609ff65-fd84-431a-825c-06c8cdac2c30.png)

  Input file 1 (Sample.csv - arg1)
  ![image](https://user-images.githubusercontent.com/21059586/166619488-8e42cae4-546f-4151-8b9b-14d68b5384ea.png)

  Input file 2: (flights.csv - arg2)
  ![image](https://user-images.githubusercontent.com/21059586/166619506-c943205c-d7ce-47a0-ae40-9d52de42e352.png)

  Output file 1: (Output.csv - arg3)
  ![image](https://user-images.githubusercontent.com/21059586/166619519-28ff411d-5067-4b65-905b-593e606a9573.png)

  Output file 2: (Output.txt - arg4)
  ![image](https://user-images.githubusercontent.com/21059586/166619533-36a5b9d3-76ac-4c79-b0e4-f9d4b9112a61.png)

  ## Design Patterns:
  
  ### Repository Pattern: 
Repository layer is added between the domain and data mapping layers to isolate domain objects from details of the data access code and to minimize scattering and duplication of query code.
Repository pattern in this project is used to store and query from the flight details and booking details obtained from csv files.

### Singleton Pattern:
Singleton pattern in this project is used to maintain a single instance of flights created, while providing a global access to this flight instance.

### Chain of Responsibility Pattern:
Chain of Responsibility pattern is used to handle the validations of flight bookings, such as, validation of flights, validation of seats along with seat category and validation of cards.
  
## Class Diagram:
  ![image](https://user-images.githubusercontent.com/21059586/166619698-7bd9c875-d6e4-42e2-9178-1feac84af4cf.png)

## JUnit test cases:
  ![image](https://user-images.githubusercontent.com/21059586/166619877-fd023ccf-a1c5-4902-ba3e-ea36dbe8917e.png)



  
