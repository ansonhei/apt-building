# Apartment Building Java Task - apt-building

Task Description:

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
