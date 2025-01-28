import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        // Initial state of the building
        Building building = new Building(25.0, 2.0);
        building.addRoom(new Apartment(101, "Tim"));
        building.addRoom(new Apartment(102, "Amy"));
        building.addRoom(new CommonRoom(103, "Gym"));
        building.addRoom(new CommonRoom(104, "Library"));

        building.updateRoomControls();

        // Lock for synchronized output
        final Object lock = new Object();

        // Scheduler for recalculating temperatures
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            synchronized (lock) {
                System.out.println("\n[Auto-Update] Recalculating temperatures...");
                building.simulateTemperatureChanges();
                building.updateRoomControls();
                System.out.println("[Auto-Update] Current Building State:");
                System.out.println(building);
                displayMenu(); // Reprint the menu after auto-updates
            }
        }, 0, 10, TimeUnit.SECONDS); // Every 10 seconds

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Menu Loop
        while (running) {
            synchronized (lock) {
                displayMenu(); // Display menu before getting user input
            }

            if (scanner.hasNextInt()) {
                // Get user's option
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                synchronized (lock) {
                    switch (choice) {
                        case 1 -> {
                            System.out.print("Enter new requested temperature: ");
                            double newTemp = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            // set new requested temperature
                            building.setRequestedTemperature(newTemp);
                        }
                        case 2 -> {
                            // Request room ID
                            System.out.print("Enter room ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            // Check if Room ID already exists
                            if (building.getRooms().stream().anyMatch(room -> room.getId() == id)) {
                                System.out.println("Room ID already exists. Please try again.");
                                break;
                            }
                            // Request room type
                            System.out.print("Enter room type (apartment/common): ");
                            String type = scanner.nextLine();
                            if (type.equalsIgnoreCase("apartment")) {
                                // Request owner name of the new apartment
                                System.out.print("Enter owner name: ");
                                String owner = scanner.nextLine();
                                building.addRoom(new Apartment(id, owner));
                            } else if (type.equalsIgnoreCase("common")) {
                                // Request common room type
                                System.out.print("Enter common room type (Gym/Library/Laundry): ");
                                String commonType = scanner.nextLine();
                                // Limit common room type
                                if (!commonType.toUpperCase().equals("GYM") && !commonType.toUpperCase().equals("LIBRARY") && !commonType.toUpperCase().equals("LAUNDRY")) {
                                    System.out.println("Invalid common room type. Must be Gym, Library, or Laundry.");
                                    break;
                                }
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
                        //  Exit application
                        case 4 -> {
                            running = false;
                            scheduler.shutdown(); // Shut down the scheduler
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                synchronized (lock) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume invalid input
                }
            }
        }

        scanner.close();
        synchronized (lock) {
            System.out.println("Exiting the application.");
        }
    }

    /**
     * Displays the menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Set Temperature");
        System.out.println("2. Add Room");
        System.out.println("3. Simulate Temperature Changes");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }
}
