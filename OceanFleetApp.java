import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * OceanFleetApp UC1 - Basic Data Model to represent a Vessel
 * OceanFleetApp UC2 - Store Vessel Records Using List
 *
 * @Developer
 * @version 1.0
 * @version 2.0
 */

// Utility class to manage vessels
class VesselUtil {

    private List<Vessel> vesselList;

    public VesselUtil() {
        vesselList = new ArrayList<>();
    }

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
        System.out.println("Vessel added successfully!");
    }

    public void displayAllVessels() {
        if (vesselList.isEmpty()) {
            System.out.println("No vessels available.");
            return;
        }

        for (Vessel vessel : vesselList) {
            System.out.println("----------------------------");
            System.out.println("ID: " + vessel.getVesselId());
            System.out.println("Name: " + vessel.getVesselName());
            System.out.println("Speed: " + vessel.getAverageSpeed());
            System.out.println("Type: " + vessel.getVesselType());
        }
    }
}

// Vessel Data Model (Encapsulation)
class Vessel {

    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    // Constructor
    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    // Getters & Setters
    public String getVesselId() {
        return vesselId;
    }

    public void setVesselId(String vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }
}

// Main Application
public class OceanFleetApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.print("How many vessels do you want to add? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter details for Vessel " + i);

            System.out.print("Vessel ID: ");
            String id = scanner.nextLine();

            System.out.print("Vessel Name: ");
            String name = scanner.nextLine();

            System.out.print("Average Speed: ");
            double speed = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Vessel Type: ");
            String type = scanner.nextLine();

            Vessel vessel = new Vessel(id, name, speed, type);
            vesselUtil.addVesselPerformance(vessel);
        }

        System.out.println("\nAll Stored Vessel Records:");
        vesselUtil.displayAllVessels();

        scanner.close();
    }
}
