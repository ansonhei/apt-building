# Apartment Building Java Task - apt-building

## Overview

This project is a Java-based simulation of an apartment building control system. The application allows users to manage a building with apartments and common rooms, monitor and control their temperatures, and simulate temperature changes dynamically.

## Task Description:

- All Rooms should have a unique ID, a current temperature, a status for if heating is enabled (i.e. a heater), and a status for if cooling is
enabled (i.e. an air conditioner).
   - Initially a rooms temperature should be a random value between 10 degrees and 40 degrees.

- An Apartment should have the same functionality as a room with an additional property for the owners name.

- A Common Room should have the same functionality as a room with an additional property for the type of common room. A common room
can be either 'Gym', 'Library', and 'Laundry'

- A Building can have 0 or more Apartments and/or 0 or more Common Rooms
  - A building should have a requested temperature for the whole building. The default requested temperature should be 20.0 degrees
  - A building should have the ability to change the requested temperature
  - A building should have the ability to add additional Apartments or Common Rooms


- Main Application:
  - A building should be created. Initially the building should have 2 apartments, apartment 101 and 102, a Gym and a Library. The building
should also have a requested temperature of 25.0 degrees.
  - The application should initially indicate to the user which rooms have heating or cooling enabled based on the following logic.
    - If the room temperature is below the requested building temperature, heating should be enabled.
    - If the room temperature is above the requested building temperature, cooling should be enabled.

## Assumption
1. All room IDs are unique.
2. Temperature tolerance for heating/cooling is fixed at ±2°C (room temperature is close enough).
3. Random initial room temperatures are generated between 10°C and 40°C.
4. User inputs are validated for invalid choices and duplicate room IDs.
5. Heating is enabled if the room's temperature is below the `requestedTemperature - tolerance`, else is disabled.
6. Cooling is enabled if the room's temperature is above the `requestedTemperature + tolerance`, else is disabled.
7. Initial state of the building have 2 apartment (id: 101 with owner Tim, id: 102 with owner Amy), Gym (id: 103) and Library (id:104).

## Running the Application
- Run the application locally:
  - Execute the following command:
      ```bash
      java -cp target/apt-building-1.0.0.jar Main
      ```

- Using docker:
   - Build the Docker image:
     ```bash
      docker build -t apt-building:1.0.0 .
     ```
   - Run the application in a Docker container:
     ```bash
     docker run --rm -it apt-building:1.0.0
     ```

## Procedure
- Run the main application Main.java
- A menu will pop up with 4 options for user to choose 
Menu:
1. Set Temperature
2. Add Room
3. Simulate Temperature Changes
4. Exit
- User can input number 1 - 4:
   - Option 1) Requested temperature will be asked and new requested temperature of the building will be set. 
   - Option 2) New room id will be requested, then room type and owner name will be requested next.
   - Option 3) Temperature of each room will be increased or decreased according the heating and cooling status.
   - Option 4) The application will be terminated.

- The current state of the building will be printed at the beginning and after every action.
- The temperature will only alter after option 3 and remain unchange if it is close enough to requested one.

##Features

- Fully packaged with Maven for dependency and build management.
- Can be run locally or containerized using Docker.
- Dynamic menu-driven application for managing building temperatures and rooms.
- Temperature simulation logic based on heating/cooling thresholds.


