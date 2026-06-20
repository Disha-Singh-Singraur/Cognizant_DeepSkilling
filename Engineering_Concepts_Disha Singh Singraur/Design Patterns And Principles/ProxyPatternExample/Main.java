public class Main {
    public static void main(String[] args) {
        System.out.println("--- Proxy Pattern Test ---");

        Image image1 = new ProxyImage("photo_high_res_1.jpg");
        Image image2 = new ProxyImage("photo_high_res_2.jpg");

        // Image 1 display call (must trigger load from remote server)
        System.out.println("\n[First Call to display image1]");
        image1.display();

        // Image 1 display call again (must bypass load, use cached version)
        System.out.println("\n[Second Call to display image1]");
        image1.display();

        // Image 2 display call (must trigger load from remote server)
        System.out.println("\n[First Call to display image2]");
        image2.display();
    }
}
