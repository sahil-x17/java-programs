import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

// Interface representing a bookable entity
interface Bookable {
    void bookTicket();
}

// Interface representing a route finder
interface RouteFinder {
    String findBestRoute();
}

// Base class representing a bus
class Bus {
    protected int id;
    protected String name;
    protected String route;
    protected double ticketPrice;
    protected String timings;

    public Bus(int id, String name, String route, double ticketPrice, String timings) {
        this.id = id;
        this.name = name;
        this.route = route;
        this.ticketPrice = ticketPrice;
        this.timings = timings;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Route: " + route + " | Ticket Price: Rs. " + ticketPrice + " | Timings: " + timings;
    }
}

// Class representing a luxury bus
class LuxuryBus extends Bus implements Bookable {
    public LuxuryBus(int id, String name, String route, double ticketPrice, String timings) {
        super(id, name, route, ticketPrice, timings);
    }

    @Override
    public void bookTicket() {
        System.out.println("Booking a ticket for Luxury Bus: " + getId());
    }
}

// Class representing a regular bus
class RegularBus extends Bus implements Bookable, RouteFinder {
    public RegularBus(int id, String name, String route, double ticketPrice, String timings) {
        super(id, name, route, ticketPrice, timings);
    }

    @Override
    public void bookTicket() {
        System.out.println("Booking a ticket for Regular Bus: " + getId());
    }

    @Override
    public String findBestRoute() {
        return "Finding the best route for Regular Bus: " + getId();
    }
}

// Exception class for handling duplicate bus IDs
class DuplicateBusIdException extends Exception {
    public DuplicateBusIdException(String message) {
        super(message);
    }
}

// Class representing the bus management system
class BusManagementSystem {
    private static ArrayList<Bus> buses = new ArrayList<>();

    // Method to add a bus to the inventory
    public static void addBus(Bus bus) throws DuplicateBusIdException {
        for (Bus existingBus : buses) {
            if (existingBus.getId() == bus.getId()) {
                throw new DuplicateBusIdException("Bus with ID " + bus.getId() + " already exists.");
            }
        }
        buses.add(bus);
    }

    // Method to display the bus inventory
    public static void displayInventory() {
      if (buses.isEmpty()) {
          System.out.println("Bus inventory is empty.");
          return;
      }

      System.out.println("ID            |        Route         |      Ticket (Rs.)    |         Timings");
      System.out.println("-----------------------------------------------------------------------------------");
      for (Bus bus : buses) {
          System.out.printf("%-14d|%-30s|%-23.2f|%-20s\n", bus.getId(), bus.getRoute(), bus.getTicketPrice(), bus.getTimings());
      }
  }
    
    // Method to get the list of buses
    public static ArrayList<Bus> getBuses() {
        return buses;
    }
    
    // Method to update bus information by ID
    public static void updateBus(int id, String newName, String newRoute, double newTicketPrice, String newTimings) {
        for (Bus bus : buses) {
            if (bus.getId() == id) {
                bus.setName(newName);
                bus.setRoute(newRoute);
                bus.setTicketPrice(newTicketPrice);
                bus.setTimings(newTimings);
                System.out.println("Bus information updated successfully.");
                return;
            }
        }
        System.out.println("Bus not found in inventory: ID " + id);
    }
    
    // Method to delete a bus by ID
    public static void deleteBus(int id) {
        Iterator<Bus> iterator = buses.iterator();
        while (iterator.hasNext()) {
            Bus bus = iterator.next();
            if (bus.getId() == id) {
                iterator.remove();
                System.out.println("Bus deleted successfully: ID " + id);
                return;
            }
        }
        System.out.println("Bus not found in inventory: ID " + id);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int busId;
        String busName;
        double busPrice;
        String route;
        String timings;

        do {
            System.out.println("\n---------------Menu:---------------");
            System.out.println("1. Add bus to System");
            System.out.println("2. Display bus System");
            System.out.println("3. Search for bus by ID");
            System.out.println("4. Update bus information");
            System.out.println("5. Delete bus by ID");
            System.out.println("6. Save current system data to a file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter bus ID to add the bus: ");
                        busId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter bus name or number: ");
                        busName = scanner.nextLine();
                        System.out.print("Enter route: ");
                        route = scanner.nextLine();
                        System.out.print("Enter bus price: ");
                        busPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter timings: ");
                        timings = scanner.nextLine();
                        Bus newBus = new Bus(busId, busName, route, busPrice, timings);
                        BusManagementSystem.addBus(newBus);
                        System.out.println("Bus added to inventory: " + newBus.getId());
                    } catch (DuplicateBusIdException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    BusManagementSystem.displayInventory();
                    break;
                case 3:
                    System.out.print("Enter bus ID to search for the bus: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (Bus bus : BusManagementSystem.getBuses()) {
                        if (bus.getId() == searchId) {
                            System.out.println("Bus found in inventory:");
                            System.out.println(bus);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Bus not found in inventory: ID " + searchId);
                    }
                    break;
                case 4:
                    System.out.print("Enter bus ID to update information: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name or bus number: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new route for the bus: ");
                    String newRoute = scanner.nextLine();
                    System.out.print("Enter new price for the bus: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter new timings for the bus: ");
                    String newTimings = scanner.nextLine();
                    BusManagementSystem.updateBus(updateId, newName, newRoute, newPrice, newTimings);
                    break;
                case 5:
                    System.out.print("Enter bus ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    BusManagementSystem.deleteBus(deleteId);
                    break;
                case 6:
                    saveSystemDataToFile();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7); // Change the condition to exit when choice is 7
        scanner.close();
    }
    
    // Method to save current system data to a file
    private static void saveSystemDataToFile() {
        try {
            FileWriter writer = new FileWriter("bus_system.txt");
            for (Bus bus : BusManagementSystem.getBuses()) {
                writer.write(bus.toString() + "\n");
            }
            writer.close();
            System.out.println("System data saved to 'bus_system.txt'.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving data to file: " + e.getMessage());
        }
    }
}
