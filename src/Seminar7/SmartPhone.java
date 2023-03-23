package Seminar7;

public class SmartPhone extends MobilePhone {
    private String operatingSystem;

    public SmartPhone(String phoneNumber, int batteryLife, String operatingSystem) {
        super(phoneNumber, batteryLife);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void browseInternet() {
        System.out.println("Посещение веб-сайтов и просмотр контента в Интернете на " + getPhoneNumber() + " под ОС " + operatingSystem);
    }

    @Override
    public void call(String number) {
        System.out.println("Звонок на" + number + " со смартфона " + getPhoneNumber());
    }

    @Override
    public void answer() {
        System.out.println("Ответ на входящий звонок на смартфоне " + getPhoneNumber());
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Сообщение со смартфона " + getPhoneNumber() + ": " + message);
    }

    @Override
    public void receiveMessage() {
        System.out.println("Получение сообщения на смартфон " + getPhoneNumber());
    }
}