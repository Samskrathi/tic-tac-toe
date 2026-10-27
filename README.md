# Tic-Tac-Toe

A console Tic-Tac-Toe game built with Java 17 and Gradle. The project is split
into `tic-tac-toe-core` for game rules and `tic-tac-toe-cli` for the interactive
console application. Lombok generates the immutable move model, and both modules
include JUnit 5 tests.

## Run

```bash
gradle test
gradle :tic-tac-toe-cli:run
```

Enter each move as a row and column from 1 to 3, separated by a space.
