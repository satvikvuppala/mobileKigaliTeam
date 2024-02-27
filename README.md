# Mobile Automation Framework
This is a structured set of tools and reusable componentes designed to streamline and enhance the test automation of mobile devices. With its primary motives being reusability, modularity, and understandability, it serves as a robust framework for mobile test automation.
## About

This framework was designed using the **Page Object Model (POM)**, which provides efficiency in organizing and maintaining automation scripts by encapsulating the elements and actions of the UI in separate classes, known as Page Objects. It simply represents each page of an application as a separate class, and interactions with the UI elements are defined within these classes.
## Built With:
- **Desing Pattern**: Page Object Model (POM).
- **Automation Tool**: Appium
- **BDD Tool**: Cucumber
- **Pragramming Language**: Java
- **Build Tool**: Maven

## Key Features
- Automation of tests on android applications
- Parameterization of device name on which the execution will take place
- Recording and storing videos for scenario execution
- Capturing and storing screenshots for failed scenarios
- Reporting on test execution results in both HTML and JSON formats
- Executing tests using both cucumber and maven lifecycle command

## Getting Started
### Prerequisites
- Java
- Maven
- Android emulator or Android device in debugging mode

### Setup
1. Clone this repository to your desired folder:
    ```
    git clone https://github.com/TSR-Repo/MobileFramework.git
    ```
2. Open the cloned repository in your preferred IDE
3. In your emulator, create a device with your preferred name
4. Start your created device

### Run Tests

**There are two different ways to run the tests:**
1. Using the `RunnerTest`class

    - Open RunnerTest class
    - Run it and wait for all the test cases to execute
    - Check the **target/reports** folder for the test execution reports and recoreded videos of the executions


    *<u>NOTE</u>: This method runs the tests on a device with the name "Pixel7" as it is set as the default value. If your device name is not Pixel7, then use the second method.*


2. Using the `Maven command` in the command line:

    - Open the cloned repository in your commandline(terminal).
    - Execute the following command:
        ```
        mvn test -DdeviceName=your_device_name
        ```
    - Wait for all the test cases to execute
    - Check the `target/reports` folder for the test execution reports and recorded videos of the executions


    *<u>NOTE</u>: In the command on step 2, remember to replace "your_device_name" with the actual name of the device you want to execute your tests on.*

    ## Contributing

    Issues and feature requests are welcome. Feel free to check the [issues page](https://github.com/TSR-Repo/MobileFramework/issues).
