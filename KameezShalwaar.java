import java.util.Date;

public class KameezShalwaar implements Measurement {
    private float trouserLength;
    private float trouserType;
    private float trouserAnkle;

    private float kameezLength;
    private float sleeves;
    private byte sleevesType; // 1 for Square, 2 for Round cuff
    private byte kameezType; // 1 for Square, 2 for Round Daman
    private float shoulder;
    private float neck;
    private byte collarType;
    private String description;
    private int quantity;
    private Date orderDate;
    private Date deliveryDate;

    public float getTrouserLength() {
        return trouserLength;
    }

    public void setTrouserLength(float trouserLength) {
        this.trouserLength = trouserLength;
    }

    public float getTrouserType() {
        return trouserType;
    }

    public void setTrouserType(float trouserType) {
        this.trouserType = trouserType;
    }

    public float getTrouserAnkle() {
        return trouserAnkle;
    }

    public void setTrouserAnkle(float trouserAnkle) {
        this.trouserAnkle = trouserAnkle;
    }

    public float getKameezLength() {
        return kameezLength;
    }

    public void setKameezLength(float kameezLength) {
        this.kameezLength = kameezLength;
    }

    public float getSleeves() {
        return sleeves;
    }

    public void setSleeves(float sleeves) {
        this.sleeves = sleeves;
    }

    public byte getSleevesType() {
        return sleevesType;
    }

    public void setSleevesType(byte sleevesType) {
        this.sleevesType = sleevesType;
    }

    public byte getKameezType() {
        return kameezType;
    }

    public void setKameezType(byte kameezType) {
        this.kameezType = kameezType;
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

    public byte getCollarType() {
        return collarType;
    }

    public void setCollarType(byte collarType) {
        this.collarType = collarType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public KameezShalwaar(float trouserLength, float trouserType, float trouserAnkle, float kameezLength, float sleeves, byte sleevesType, byte kameezType, float shoulder, float neck, byte collarType, String description, int quantity, Date orderDate, Date deliveryDate) {
        this.trouserLength = trouserLength;
        this.trouserType = trouserType;
        this.trouserAnkle = trouserAnkle;
        this.kameezLength = kameezLength;
        this.sleeves = sleeves;
        this.sleevesType = sleevesType;
        this.kameezType = kameezType;
        this.shoulder = shoulder;
        this.neck = neck;
        this.collarType = collarType;
        this.description = description;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
    }
}