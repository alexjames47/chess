# ♕ BYU CS 240 Chess

This project demonstrates mastery of proper software design, client/server architecture, networking using HTTP and WebSocket, database persistence, unit testing, serialization, and security.

## 10k Architecture Overview

The application implements a multiplayer chess server and a command line chess client.

[![Sequence Diagram](10k-architecture.png)](https://sequencediagram.org/index.html#initialData=C4S2BsFMAIGEAtIGckCh0AcCGAnUBjEbAO2DnBElIEZVs8RCSzYKrgAmO3AorU6AGVIOAG4jUAEyzAsAIyxIYAERnzFkdKgrFIuaKlaUa0ALQA+ISPE4AXNABWAexDFoAcywBbTcLEizS1VZBSVbbVc9HGgnADNYiN19QzZSDkCrfztHFzdPH1Q-Gwzg9TDEqJj4iuSjdmoMopF7LywAaxgvJ3FC6wCLaFLQyHCdSriEseSm6NMBurT7AFcMaWAYOSdcSRTjTka+7NaO6C6emZK1YdHI-Qma6N6ss3nU4Gpl1ZkNrZwdhfeByy9hwyBA7mIT2KAyGGhuSWi9wuc0sAI49nyMG6ElQQA)

[![MyDiagram](myDiagram)](https://sequencediagram.org/index.html?presentationMode=readOnly#initialData=IYYwLg9gTgBAwgGwJYFMB2YBQAHYUxIhK4YwDKKUAbpTngUSWDAEooDmSAzmFMARDQVqhFHXyFiwUgCkISNAHFgAWxTCqozOIZTScKCn4plajVp2Sm8BEajmQYy42nMAMtzCmUXB09wSLqRuEOwQAK5gftoButYhnEKUmo7aaTH0Vq4wACL8wACCII5cXJgAJvkARsBcKDDlVelp7FAR2DAAxGjAVACerByefAJoXQDuABZIYGKIqKQAtAB85MmUAFwwANoACgDyZAAqALowAPThdVAAOmgA3leUPWoANDC4pePQ5e8oKsAkAgAL6YDSUGArQacHgjJCCPxbQww2ZQAAUTygLxQ70+XG+UF+MH+gIQAEpMGwUXCEclRJDVnkwIVij4uFt2CgwABVa4Y67YilMlklLgMhpVLZkACibmlcCOMEx2JgADM2iolddMMKiqLIVCqcN+PCkiJHFs0OEEAhKUNYSbaeb6lDdazSlsQIZjLzKPznqocR9avifkL8nq2eLGlsAJIAORlLEVysDuJDBKJJKBMATR32WtoRodoz84rdos93tmBUik39WMD4eZkdK0clucT0uThcbbxgwDrRwgAGt0J38wO6zqI+6xYtDfbeI6zSkUFtB2BJsOx2g7dSV2WF6twVAN0PR+gwetYMebAswFsAEwABhfd3um+3l7QoPQ5W0Vp2i6aBpE5GAEgUCZplmTB5nQZgoVPLY9kOU4LjqUpTQ-VN+zxTNQVPcVINXUQtgQUIFAbbF0y+MNMBIo9lgrNkOS5X10VwlBmxFNkVhjchZXlFMBUDNUNV7GcWznA1lkYukLV7bEGMo0jHAZFiPRgTkwF2DMfgAMQ1DjsWopspN40p+I7GU5QVYM6MJcSIE1TELNbecVnk51PWgQxwD0xyAO8tdiNUxEYG4ABZfgQGmNB2EC0NCTRfCfleEA-JQAL9MJCkQvpFZNPZbSuVrLcd3QMy1B4jzZIKi0v0qvcGpdFZkKan9r2oCFj3gjBnzfD9Ot3P80AAzAgPCDpOlaFBxwSCJmE6KYZjmZAEPFZCdhyISjmlM5zkwrhsJ6C9d26mhbzk0IloiiiwkiNERvQfLbsiJjirYnlriMlzyu-XdnvO173JkqEBNs4SlLE9UXMk4r6veqIFPXGG1BUx6UedDTZ0rGBDBUCAaAB4Vqu4sH9QhjsWGlKL9gANWlKcKp-ZzNVJ-JKajamtlp+mmfR+o4Y5uthUxu7Udx6T8cJ4mTEDMmuNq8HVgE-nGeZ9hA1jHJ2ZgbxxcR3nWDpzWYFW2YTNhiTDa5421Zps3BaqBBQBHa21H1u3mW5tsTY1wXtbUeMbfhn3gD9+dHb552tbDzUI6jpGsYiq0bQlj6pePbb09tIi+o2gaYFfd8HjzsaJqmmbDHKCDPANwMxRWmD1ofLabxQxRpXQ85g5QO4Xr3AvVg8HhvF8VGOSbsewGB1nd3yzwJ8+vHWNKsAAea+fAdB4qTah+yh-1znff3rzl6bxEh4Yy+1EnnGirXrSdIn2e0RVqmY8EuzFX73XvaK3ts-aOEopRCXspbFAntha2yAWfEB7ZwG-xgK7d2MDAFqCNogg+EC-6BlDl7EWjcsHAJljzb+h98FELgaQhB5CrIX3HlfKe9wABE-cuBsJQvcfu5RdavCgTA14aCQAe1Em8fuhCUDAleAAOgUScUEs8V6oxzp3dhnDuE7F4YGfhORBGt2EaI8RAZJEEMDLIhRcilGXUoIXB8GxS4fg4U3bR2xdFqH0YYtaxi3ZiOEVIyx8jFGV0Am0aaXRsDhCgNgWw8Bqz1G8NBNacEi6IRPJ3HYBxjiHX7oPEGaAPxBLUIRG84oDBGFmN4CKXoqkKzUDvZqrwSkU0qcYGp2dmIgO+lvH8TSfyfz4pQvBLNd5jGIafSO59ljtOqYGa+hS4KJM6Y-RkPSN7eGkWiVpQz-YjJQa0zBKBsEMM8qsOZDT1BTxgHnZZ9TVmhVdBsupxh4woHGFswMOyLE1WTibBMSZqEoGkROAsSdLmPMKuss5VZ6nvM+d8vZoCBKAu7MCsFJCTlc0hQsrpuQXkrJ1jkH5IdzIOzAZ2IF2liWYqTsbKEuKzA3P-jke5HS8WP3alk1ldioAOIQhsbYpcTguNZdw1lYTJoRJmn0FANoIDjBgHIKCyTOgmLSe3JCWS9jcl7vks6C90Afn6mAOAEAKJQHeJKvl4oVVKE5WuLYAAreQDrGlDxacS14przWWopPaqF6kn6wo3n0oGQ9kW4JQcfSZYsyGWS4MeQNjqyI3xTcytZX0N4cT+iocNVVI3-IOdDLi+s3IMuWBm65PkhaYGravUNr9iWkpQLrKNJb7KsuOacxNya3VBvXLyhtXTs06V9Ra6AaIJ3+qjtG6GM7oAYOIfSkB-aFCDo2HckdWaNl1DNekv1S6JEoHJj6w9k6oAdspWinsi6oAYLzOC+B0y10rB3U67dA7U3Bu5T1M8tzrT5xvAKgawq3yivLkB0EmB-zhOArNPgAxEB2AHNgOJhAVwpNgqaju-6UK7TlPtQ6jRbWMtsHgWpFGoAFHQx-NJdhG2JqRP8eWUz6MUvVnHMZzUT7xvoYmpBpsBbMzLXGrc4sUOUdHRsuWNAI4cZwd-QO8c1AAJXS+4tlKVMWyMSentCa6oB24yY5dtDsUCaM8p7jRyNN0NfWcoTOn+4Gd9lJ+wMnQ1yegdcMmyKnPcbExJDivarPae42lJyxCQuGdVuFkTxIAQ5mi752LVMVjubTkBhj0muXLFztlguGX0mDTLvcCusHxqYCAA)

## IntelliJ Support

Open the project directory in IntelliJ in order to develop, run, and debug your code using an IDE.

## Maven Support

You can use the following commands to build, test, package, and run your code.

| Command                    | Description                                     |
| -------------------------- | ----------------------------------------------- |
| `mvn compile`              | Builds the code                                 |
| `mvn package`              | Run the tests and build an Uber jar file        |
| `mvn package -DskipTests`  | Build an Uber jar file                          |
| `mvn install`              | Installs the packages into the local repository |
| `mvn test`                 | Run all the tests                               |
| `mvn -pl shared tests`     | Run all the shared tests                        |
| `mvn -pl client exec:java` | Build and run the client `Main`                 |
| `mvn -pl server exec:java` | Build and run the server `Main`                 |

These commands are configured by the `pom.xml` (Project Object Model) files. There is a POM file in the root of the project, and one in each of the modules. The root POM defines any global dependencies and references the module POM files.

### Running the program using Java

Once you have compiled your project into an uber jar, you can execute it with the following command.

```sh
java -jar client/target/client-jar-with-dependencies.jar

♕ 240 Chess Client: chess.ChessPiece@7852e922
```
