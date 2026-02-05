import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* ================= VESSEL MODEL ================= */

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

    @Override
    public String toString() {
        return vesselId + " | " + vesselName + " | " + vesselType + " | " + averageSpeed + " knots";
    }
}

/* ================= VESSEL UTIL ================= */

class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    public Vessel getVesselByID(String id) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equalsIgnoreCase(id)) {
                return vessel;
            }
        }
        return null;
    }

    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> result = new ArrayList<>();

        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > 30) {   // High performance criteria
                result.add(vessel);
            }
        }

        return result;
    }
}

/* ================= USER INTERFACE ================= */

class UserInterface {

    private VesselUtil vesselUtil;
    private Scanner scanner;

    public UserInterface() {
        vesselUtil = new VesselUtil();
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.print("Enter number of vessels: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter vessel details (id:name:speed:type)");
            String input = scanner.nextLine();

            String[] data = input.split(":");

            if (data.length != 4) {
                System.out.println("Invalid format! Try again.");
                i--;
                continue;
            }

            String id = data[0];
            String name = data[1];
            double speed = Double.parseDouble(data[2]);
            String type = data[3];

            Vessel vessel = new Vessel(id, name, speed, type);
            vesselUtil.addVesselPerformance(vessel);
        }

        searchVessel();
        displayHighPerformance();

        scanner.close();
    }

    private void searchVessel() {

        System.out.print("\nEnter Vessel ID to search: ");
        String searchId = scanner.nextLine();

        Vessel found = vesselUtil.getVesselByID(searchId);

        if (found != null) {
            System.out.println("\nVessel Found:");
            System.out.println(found);
        } else {
            System.out.println("Vessel not found.");
        }
    }

    private void displayHighPerformance() {

        System.out.println("\nHigh Performance Vessel(s):");

        List<Vessel> list = vesselUtil.getHighPerformanceVessels();

        if (list.isEmpty()) {
            System.out.println("No vessels available.");
        } else {
            for (Vessel vessel : list) {
                System.out.println(vessel);
            }
        }
    }
}

/* ================= MAIN APP ================= */

public class OceanFleetApp {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
