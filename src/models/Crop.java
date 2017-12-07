package models;

public class Crop implements Comparable<Crop>{

    private String cultivation, texture, sand;
    private byte ph, p, ca, na, k, fe,humidity, temperature;
    private models.Date plantingDate;
    private short cultivationTimeInDays;
    private  int id;

    public Crop(String cultivation, String texture, String sand, byte ph, byte p, byte ca, byte na, byte k, byte fe,
                byte humidity, byte temperature, short cultivationTimeInDays, int id) {
        this.cultivation = cultivation;
        this.texture = texture;
        this.sand = sand;
        this.ph = ph;
        this.p = p;
        this.ca = ca;
        this.na = na;
        this.k = k;
        this.fe = fe;
        this.humidity = humidity;
        this.temperature = temperature;
        this.cultivationTimeInDays = cultivationTimeInDays;
        this.id = id;
    }

    public Crop(String cultivation, byte ph, byte p, byte ca, byte na, byte k, byte fe, String texture, String sand,
                byte humidity, byte temperature, Date plantingDate, short cultivationTimeInDays, int id) {

        this.cultivation = cultivation;
        this.ph = ph;
        this.p = p;
        this.ca = ca;
        this.na = na;
        this.k = k;
        this.fe = fe;
        this.texture = texture;
        this.sand = sand;
        this.humidity = humidity;
        this.temperature = temperature;
        this.plantingDate = plantingDate;
        this.cultivationTimeInDays = cultivationTimeInDays;
        this.id = id;
    }

    public String getCultivation() {
        return cultivation;
    }

    public void setCultivation(String cultivation) {
        this.cultivation = cultivation;
    }

    public byte getPh() {
        return ph;
    }

    public void setPh(byte ph) {
        this.ph = ph;
    }

    public byte getP() {
        return p;
    }

    public void setP(byte p) {
        this.p = p;
    }

    public byte getCa() {
        return ca;
    }

    public void setCa(byte ca) {
        this.ca = ca;
    }

    public byte getNa() {
        return na;
    }

    public void setNa(byte na) {
        this.na = na;
    }

    public byte getK() {
        return k;
    }

    public void setK(byte k) {
        this.k = k;
    }

    public byte getFe() {
        return fe;
    }

    public void setFe(byte fe) {
        this.fe = fe;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getSand() {
        return sand;
    }

    public void setSand(String sand) {
        this.sand = sand;
    }

    public byte getHumidity() {
        return humidity;
    }

    public void setHumidity(byte humidity) {
        this.humidity = humidity;
    }

    public byte getTemperature() {
        return temperature;
    }

    public void setTemperature(byte temperature) {
        this.temperature = temperature;
    }

    public Date getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(Date plantingDate) {
        this.plantingDate = plantingDate;
    }

    public short getCultivationTimeInDays() {
        return cultivationTimeInDays;
    }

    public void setCultivationTimeInDays(short cultivationTimeInDays) {
        this.cultivationTimeInDays = cultivationTimeInDays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "cultivation='" + cultivation + '\'' +
                ", texture='" + texture + '\'' +
                ", sand='" + sand + '\'' +
                ", ph=" + ph +
                ", p=" + p +
                ", ca=" + ca +
                ", na=" + na +
                ", k=" + k +
                ", fe=" + fe +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                ", plantingDate=" + plantingDate +
                ", cultivationTimeInDays=" + cultivationTimeInDays +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Crop o) {
        return 0;
    }
}
