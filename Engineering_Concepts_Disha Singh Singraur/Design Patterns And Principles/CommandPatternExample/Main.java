public class Main {
    public static void main(String[] args) {
        System.out.println("--- Command Pattern Test ---");

        // Receiver
        Light livingRoomLight = new Light();

        // Concrete Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn Light On
        System.out.println("Setting Command: Turn Light ON");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println();

        // Turn Light Off
        System.out.println("Setting Command: Turn Light OFF");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
