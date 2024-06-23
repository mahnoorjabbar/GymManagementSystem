# GymManagementSystem
## Description

The Gym Management System is a Java-based application that allows users to manage gym members, trainers, equipment, and workout schedules. The system provides a graphical user interface (GUI) using Swing for easy interaction.

## Features

- Admin and Gym Member login interfaces
- Display information about gym members, trainers, and equipment
- Show workout schedules for members
- Calculate and display monthly gym fees

## Installation
### Prerequisites
- Java Development Kit (JDK) installed (version 8 or higher)
- A Java IDE or text editor for running the code (e.g., IntelliJ IDEA, Eclipse, NetBeans)

### Steps
1. Clone the repository or download the ZIP file.
2. Open the project in your preferred Java IDE.
3. Ensure the `javax.swing` package is included in your Java environment.
4. Compile and run the `GymManagementSystem.java` file.
  
## Usage
1. Run the `GymManagementSystem.java` file.
2. The main menu will appear with options for Gym Admin and Gym Member.
3. Select "Gym Admin" or "Gym Member" to log in:
    - For admin access, use the ID code `ID` and password `p123`.
4. Navigate through the options to view members, trainers, equipment, and workout schedules.
5. Use the "Exit Program" button to close the application.

## Code Overview
### Main Classes and Methods
- AbstractClass: Abstract class with the abstract method `displayWorkoutSchedule`.
- **Person**: Base class with fields for name and age, and a method to display this information.
- **Member**: Inherits from `Person`, adds a member ID, and method to display member information.
- **Trainer**: Inherits from `Person`, adds a trainer ID and specialization, and method to display trainer information.
- **Equipment**: Inherits from `Trainer`, adds equipment name and maintenance information, and method to display equipment details.
- **MonthlyFee**: Class with a method to display monthly fee information.
- **GymMember**: Inherits from `Member`, adds membership type, and overrides method to display member information.
- **Workout**: Inherits from `AbstractClass`, adds description and duration of workouts, and method to display workout schedule.
- **AdminLogin**: Handles admin login and password verification.
- **GymManagementSystem**: Main class that sets up the GUI and handles user interactions.

### GUI Components
- **JFrame**: Main application window.
- **JPanel**: Container for grouping components.
- **JLabel**: Display text.
- **JButton**: Interactive buttons.
- **JComboBox**: Dropdown menu for selecting gym members.
- **JOptionPane**: Dialog boxes for displaying messages and input prompts.
