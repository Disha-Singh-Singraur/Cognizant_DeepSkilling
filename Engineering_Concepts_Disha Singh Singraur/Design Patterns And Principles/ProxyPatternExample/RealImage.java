public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading " + fileName + " from remote server...");
        try {
            Thread.sleep(1500); // Simulate slow network delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(fileName + " successfully loaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
