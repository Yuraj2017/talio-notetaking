## Description of project
Our application Talio is a to-do list application with which you can create your own lists and tasks to keep your tasks organised.
Our app offers a lot of flexibility, such as editing created lists and cards and moving cards around. As well as including an admin to control procedures where the Admin password is 1010
The app also allows for detailed tasks, multiple taskboards and multiple synchronized
instances of the application open at the time.
## Group members

| Profile Picture                                                                            | Name                  | Email                             |
|--------------------------------------------------------------------------------------------|-----------------------|-----------------------------------|
| ![](https://gitlab.ewi.tudelft.nl/uploads/-/system/user/avatar/5950/avatar.png?width=400)  | Sergiu-Nicolae Stancu | S.N.Stancu@student.tudelft.nl     |
| ![](https://secure.gravatar.com/avatar/70bd6424dcf4164c26d17566d394fbd3?s=200d=identicon)  | Yuraj Mangalgi        | Y.Mangalgi@student.tudelft.nl     |
| ![](https://secure.gravatar.com/avatar/bcc0b1f7425e3bafe9b1390e7ee0708a?s=200&d=identicon) | Danny Bunschoten      | D.M.Bunschoten@student.tudelft.nl |
| ![](https://secure.gravatar.com/avatar/63be381cd4f1c3ec0706e779a933f6a4?s=200&d=identicon) | Aadesh Ramai          | A.P.Ramai@student.tudelft.nl      |
| ![](https://gitlab.ewi.tudelft.nl/uploads/-/system/user/avatar/6165/avatar.png?width=400)  | Konstantin Teplykh    | K.Teplykh@student.tudelft.nl      |
| ![](https://secure.gravatar.com/avatar/773a24ae961de6c27bcb062be7015c01?s=200&d=identicon) | Emīls Dzintars        | E.Dzintars@student.tudelft.nl     |

## How to run it
Before running it you need to ensure that the setup is correct, the project structure needs to use SDK 19 oracle OpenJDK version 19 and language level set to 11 - Local Variable syntax for lamda parameters.

The scenebuilder requires Javafx sdk 19 which shoul dbe downloaded and set in the Java folder

In the edit configurations client Main it should be set to Java 19 SDK and in modify opitions select Add VM option and copy this line:

--module-path "C:\Program Files\Java\javafx-sdk-19.0.2.1\lib" --add-modules javafx.controls,javafx.fxml 

Where in the "" should be the path to your javafx sdk lib folder After doing this you can now start to run the program


When you want to run the program, you first have to start the server.
You can do this by following the following file path: server/src/main/java/server/Main.java.
Now right-click on the 'Main' java file and press run Main.main().

After you have started the server, you can run the client by following the following file path:
client/src/main/java/client/Main.java. Then right-click on the 'Main' java file and press run client.main().
A window should pop up in about 10 seconds after starting the client, which enables interaction with the application.
You are also able to run multiple clients at the same time by simply repeating the last step.

## How to contribute to it
Create an issue about it in gitlab, branch off of main and implement your changes in your branch.
Commit and push these changes and create a merge request, which will need three approvals before getting merged.
