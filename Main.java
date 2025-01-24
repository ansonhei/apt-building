import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initial state of the building
        Building building = new Building(25.0, 2.0);
        building.addRoom(new Apartment(101, "Tim"));
        building.addRoom(new Apartment(102, "Amy"));
        building.addRoom(new CommonRoom(103, "GYM"));
        building.addRoom(new CommonRoom(104, "LIBRARY"));

        building.updateRoomControls();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nCurrent Building State:");

            // print current state of the building
            System.out.println(building);

            // User Menu with 4 options
            System.out.println("\nMenu:");
            System.out.println("1. Set Temperature");
            System.out.println("2. Add Room");
            System.out.println("3. Simulate Temperature Changes");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            // Get user's option
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    default -> System.out.println("Invalid choice. Please enter 1 - 4.");

                    case 1 -> {
                        System.out.print("Enter new requested temperature: ");
                        double newTemp = scanner.nextDouble();
                        scanner.nextLine();
                        // set new requested temperature
                        building.setRequestedTemperature(newTemp);
                    }
                    case 2 -> {
                        boolean idExists = false;

                        // Request room ID
                        System.out.print("Enter room ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            // check if room id already exists
                            for (Room room : building.getRooms())
                            {
                                if(room.getId() == id){
                                System.out.println("Room ID already exists. Please try again.");
                                idExists = true;
                                break;
                                }
                            }

                        // ask for options again if room id already exists    
                        if (idExists) {
                            break;
                        }

                        // Request room type
                        System.out.print("Enter room type (apartment/common): ");
                        String type = scanner.nextLine();
                        if (type.toUpperCase().equals("APARTMENT")) {
                            // Request owner name of the new apartment
                            System.out.print("Enter owner name: ");
                            String owner = scanner.nextLine();
                            building.addRoom(new Apartment(id, owner));
                        } else if (type.toUpperCase().equals("COMMON")) {
                            // Request common room type
                            System.out.print("Enter common room type (Gym/Library/Laundry): ");
                            String commonType = scanner.nextLine();
                            building.addRoom(new CommonRoom(id, commonType));
                        } else {
                            System.out.println("Invalid room type.");
                        }

                        // update room controls
                        building.updateRoomControls();
                    }
                    case 3 -> {
                        //  simulate temperature changes
                        building.simulateTemperatureChanges();

                        // update room controls
                        building.updateRoomControls();
                    }

                    //  Exit
                    case 4 -> running = false;

                    
                    }
                }
            
            else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
        }

        scanner.close();
        System.out.println("Exiting the application.");
        System.out.println("\nFinal Building State:");
        System.out.println(building);
    }
}
