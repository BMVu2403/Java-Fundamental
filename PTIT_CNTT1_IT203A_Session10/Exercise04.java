interface RemoteControl {
    void powerOn();

    default void checkBattery() {
        System.out.println("Pin on dinh");
    }
}

public class Exercise04 {
    public static void main(String[] args) {
        RemoteControl smartLight = new RemoteControl() {
            public void powerOn() {
                System.out.println("Den da bat");
            }
        };
        smartLight.powerOn();
        smartLight.checkBattery();
    }
}
