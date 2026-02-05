/**
 * OceanFleetApp UC1 - Basic Data Model to represent a Vessel
 *
 * This class will store attributes of vessel details.
 *
 * @Developer
 * @version1.0
 * */

class Vessel {
    // Instance Variables (Encapsulation: kept private)
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    // No-Argument Constructor
    public Vessel() {
    }

    // Parameterized Constructor
    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    // Getter Methods
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

    // Setter Methods
    public void setVesselId(String vesselId) {
        this.vesselId = vesselId;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }
}


public class OceanFleetApp {
    public static void main(String[] args) {

    }
}