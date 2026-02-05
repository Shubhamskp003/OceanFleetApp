import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * OceanFleetApp UC2 - Store Vessel Records Using List
 * OceanFleetApp UC3 - Retrieve Vessel by Vessel ID
 *
 * @Developer
 * @version 2.0
 * @version 3.0
 */

// Utility class
class VesselUtil {

    private List<Vessel> vesselList;

    public VesselUtil() {
        vesselList = new ArrayList<>();
    }

    public void addVessel(Vessel vessel) {
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

    // UC3 — Search by ID
    public Vessel getVesselByID(String id) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equalsIgnoreCase(id)) {
                return vessel;
            }
        }
        return null;
    }
}

// Data Model
class Vessel {

    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    public String getVesselId() {
        return vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }
}

// Main App
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
            vesselUtil.addVessel(vessel);
        }

        System.out.println("\nAll Stored Vessel Records:");
        vesselUtil.displayAllVessels();

        // UC3 Search Feature
        System.out.println("\nSearch Vessel By ID");
        System.out.print("Enter Vessel ID to search: ");
        String searchId = scanner.nextLine();

        Vessel foundVessel = vesselUtil.getVesselByID(searchId);

        if (foundVessel != null) {
            System.out.println("\nVessel Found:");
            System.out.println("ID: " + foundVessel.getVesselId());
            System.out.println("Name: " + foundVessel.getVesselName());
            System.out.println("Speed: " + foundVessel.getAverageSpeed());
            System.out.println("Type: " + foundVessel.getVesselType());
        } else {
            System.out.println("Vessel not found with ID: " + searchId);
        }

        scanner.close();
    }
}
