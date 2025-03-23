public class Pant implements Measurement{
    private float waist;
    private float length;
    private byte type; // for Straight fit, 1 for Cuff
    private float inseam;
    private byte status; // 0 for pending, 1 for processing, 2 for completed, 3 for delivered

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public float getInseam() {
        return inseam;
    }

    public void setInseam(float inseam) {
        this.inseam = inseam;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Pant(float waist, float length, byte type, float inseam, byte status, String description) {
        this.waist = waist;
        this.length = length;
        this.type = type;
        this.inseam = inseam;
        this.status = status;
        this.description = description;
    }
}
