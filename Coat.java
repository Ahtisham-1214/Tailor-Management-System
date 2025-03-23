public class Coat implements Measurement {
    private float chest;
    private float waist;
    private float sleeves;
    private float shoulder;
    private float sleevesWidth;
    private byte status; // 0 for pending, 1 for processing, 2 for completed, 3 for delivered
    private String description;

    public Coat(float chest, float waist, float sleeves, float shoulder, float sleevesWidth, byte status, String description) {
        this.chest = chest;
        this.waist = waist;
        this.sleeves = sleeves;
        this.shoulder = shoulder;
        this.sleevesWidth = sleevesWidth;
        this.status = status;
        this.description = description;
    }
}
