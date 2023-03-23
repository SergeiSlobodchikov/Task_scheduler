package Seminar7;

public class StationaryPhone extends Phone{
    public StationaryPhone(String phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void call(String number) {
        System.out.println("Звонок" + number + " со стационарного телефона " + getPhoneNumber());
    }

    @Override
    public void answer() {
        System.out.println("Ответ на вызов на стационарном телефоне" + getPhoneNumber());
    }

}