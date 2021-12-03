# PrettyConsoleTableGenerator
A simple tool to generate a formatted table in the console. Below is a sample output
```
+-----------+-----------------------------+-------------------+--------------------+-----------+-----------+
| method id | method name                 | duration estimate | ground truth count | hit count | precision |
+-----------+-----------------------------+-------------------+--------------------+-----------+-----------+
| 0         | createBracketedMazeCoords   | 0                 | 2380               | 85        | 0.91      |
| 1         | createConstrainedMazeCoords | 0                 | 1702               | 7         | 0.86      |
| 2         | findRoute                   | 0                 | 1703               | 30        | 0.67      |
| 3         | getQueryDirections          | 0                 | 1721               | 189       | 0.75      |
| 4         | handleDrag                  | 1                 | 1784               | 104       | 0.97      |
| 5         | performGameFinishedFeedback | 5                 | 8                  | 5         | 0.00      |
| 6         | performGameStartedFeedback  | 0                 | 8                  | 7         | 0.00      |
| 7         | playerContainsPoint         | 0                 | 22                 | 1         | 0.00      |
| 8         | setGameState                | 0                 | 23                 | 111       | 0.03      |
| 9         | createGame                  | 5                 | 8                  | 38        | 0.00      |
| 10        | cellContains                | 0                 | 1702               | 117       | 0.66      |
| 11        | getCols                     | 0                 | 9                  | 327       | 0.01      |
| 12        | getHeight                   | 0                 | 8                  | 122       | 0.01      |
| 13        | getRows                     | 0                 | 3132               | 585       | 0.69      |
| 14        | getWidth                    | 0                 | 8                  | 1087      | 0.00      |
| 15        | createMaze                  | 5                 | 8                  | 3         | 0.00      |
| 16        | renderDestination           | 0                 | 1712               | 492       | 0.78      |
| 17        | renderPlayer                | 0                 | 1705               | 429       | 0.84      |
| 18        | render                      | 3                 | 1723               | 327       | 0.94      |
| 19        | drawWalls                   | 0                 | 4400               | 1075      | 0.90      |
+-----------+-----------------------------+-------------------+--------------------+-----------+-----------+
```
Tool considers the content lengths and **automatically** adapt column widths. 
The inputs to the system will be the list of headers, list of rows with content merged for a single string per row by a user chosen seperator, and finally the very user chosen separator.

Sample input is given under the main method in the tool.

Tool also returns a string list that could be directly used to write the *pretty* table to a file.




