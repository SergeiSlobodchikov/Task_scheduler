package Seminar7;

public class SatellitePhone extends Phone implements BatteryLife {
    private int batteryLife;
    private int signalStrength;

    public SatellitePhone(String phoneNumber, int batteryLife, int signalStrength) {
        super(phoneNumber);
        this.batteryLife = batteryLife;
        this.signalStrength = signalStrength;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }

    @Override
    public void call(String number) {
        System.out.println("Звонок на" + number + " со спутникового телефона " + getPhoneNumber() + " сила сигнала  " + signalStrength);
    }

    @Override
    public void answer() {
        System.out.println("Ответ на вызов по спутниковому телефону " + getPhoneNumber() + "  сила сигнала " + signalStrength);
    }

    @Override
    public int getBatteryLevel() {
        return batteryLife;
    }

    @Override
    public void chargeBattery() {
        batteryLife = 100;
    }
}