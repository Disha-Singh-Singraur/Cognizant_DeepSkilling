public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // Lazy loading: Instantiate RealImage only when display() is called
        // Caching: Reuse the instantiated RealImage on subsequent calls
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
