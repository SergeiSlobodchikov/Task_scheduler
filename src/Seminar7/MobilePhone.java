package Seminar7;

public class MobilePhone extends Phone implements PhoneInterface, BatteryLife {
    private int batteryLife;

    public MobilePhone(String phoneNumber, int batteryLife) {
        super(phoneNumber);
        this.batteryLife = batteryLife;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    @Override
    public void call(String number) {
        System.out.println("Звонок на телефон "+ number +" с мобильного " + getPhoneNumber());
    }

    @Override
    public void answer() {
        System.out.println("Ответ на звонок на мобильном" + getPhoneNumber());
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Отправить сообщение с мобильного " + getPhoneNumber());
    }

    @Override
    public void receiveMessage() {
        System.out.println("Получить сообщение на мобильный");
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
