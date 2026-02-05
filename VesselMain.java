import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String id) {
        for (Vessel v : vesselList) {
            if (v.getVesselId().equalsIgnoreCase(id)) {
                return v;
            }
        }
        return null;
    }

    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> result = new ArrayList<>();
        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() > 30) {   // High performance condition
                result.add(v);
            }
        }
        return result;
    }
}

public class VesselMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.print("Enter number of vessels: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter vessel details (id:name:speed:type)");
            String input = scanner.nextLine();

            String[] data = input.split(":");

            if (data.length != 4) {
                System.out.println("Invalid format! Please enter again.");
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

        System.out.print("\nEnter Vessel ID to search: ");
        String searchId = scanner.nextLine();

        Vessel found = vesselUtil.getVesselById(searchId);

        if (found != null) {
            System.out.println("\nVessel Found:");
            printFormatted(found);
        } else {
            System.out.println("Vessel not found.");
        }

        System.out.println("\nHigh Performance Vessel(s):");
        List<Vessel> highList = vesselUtil.getHighPerformanceVessels();

        if (highList.isEmpty()) {
            System.out.println("No vessels available.");
        } else {
            for (Vessel vessel : highList) {
                printFormatted(vessel);
            }
        }

        scanner.close();
    }

    private static void printFormatted(Vessel vessel) {
        System.out.println(
                vessel.getVesselId() + " | " +
                        vessel.getVesselName() + " | " +
                        vessel.getVesselType() + " | " +
                        vessel.getAverageSpeed() + " knots"
        );
    }
}
