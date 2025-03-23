public class Shirt implements Measurement {
    private float chest;
    private float sleeveLength;
    private float shirtLength;
    private float shoulder;
    private float neck;
//    private int collarType;
    private byte cuffType;  // 0 for half sleeves, 1 for Square cuff, 2 for round cuff
    private byte status; // 0 for pending, 1 for processing, 2 for completed, 3 for delivered
    private String description;

    public float getChest() {
        return chest;
    }

    public void setChest(float chest) {
        this.chest = chest;
    }

    public float getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(float sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public float getShirtLength() {
        return shirtLength;
    }

    public void setShirtLength(float shirtLength) {
        this.shirtLength = shirtLength;
    }

    public float getShoulder() {
        return shoulder;
    }

    public void setShoulder(float shoulder) {
        this.shoulder = shoulder;
    }

    public float getNeck() {
        return neck;
    }

    public void setNeck(float neck) {
        this.neck = neck;
    }

    public byte getCuffType() {
        return cuffType;
    }

    public void setCuffType(byte cuffType) {
        this.cuffType = cuffType;
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

    public Shirt(float chest, float sleeveLength, float shirtLength, float shoulder, float neck, byte cuffType, byte status, String description) {
        this.chest = chest;
        this.sleeveLength = sleeveLength;
        this.shirtLength = shirtLength;
        this.shoulder = shoulder;
        this.neck = neck;
        this.cuffType = cuffType;
        this.status = status;
        this.description = description;
    }
}
