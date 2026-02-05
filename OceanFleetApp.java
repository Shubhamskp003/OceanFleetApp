import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * OceanFleetApp UC3 - Retrieve Vessel by Vessel ID
 * OceanFleetApp UC4 - Identify High-Performance Vessels
 *
 * @Developer
 * @version 3.0
 * @version 4.0
 */

// Utility Class
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

    // UC3 — Retrieve by ID
    public Vessel getVesselByID(String id) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equalsIgnoreCase(id)) {
                return vessel;
            }
        }
        return null;
    }

    // UC4 — Identify High Performance Vessels
    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> result = new ArrayList<>();

        if (vesselList.isEmpty()) return result;

        double maxSpeed = vesselList.get(0).getAverageSpeed();

        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() == maxSpeed) {
                result.add(vessel);
            }
        }

        return result;
    }
}

// Vessel Model
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

            vesselUtil.addVessel(new Vessel(id, name, speed, type));
        }

        System.out.println("\nAll Stored Vessels:");
        vesselUtil.displayAllVessels();

        // UC3
        System.out.print("\nSearch Vessel By ID: ");
        String searchId = scanner.nextLine();

        Vessel found = vesselUtil.getVesselByID(searchId);

        if (found != null) {
            System.out.println("\nVessel Found:");
            System.out.println("ID: " + found.getVesselId());
            System.out.println("Name: " + found.getVesselName());
            System.out.println("Speed: " + found.getAverageSpeed());
            System.out.println("Type: " + found.getVesselType());
        } else {
            System.out.println("Vessel not found.");
        }

        // UC4
        System.out.println("\nHigh Performance Vessel(s):");

        List<Vessel> highList = vesselUtil.getHighPerformanceVessels();

        if (highList.isEmpty()) {
            System.out.println("No vessels available.");
        } else {
            for (Vessel v : highList) {
                System.out.println("----------------------------");
                System.out.println("ID: " + v.getVesselId());
                System.out.println("Name: " + v.getVesselName());
                System.out.println("Speed: " + v.getAverageSpeed());
                System.out.println("Type: " + v.getVesselType());
            }
        }

        scanner.close();
    }
}
