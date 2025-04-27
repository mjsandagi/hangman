import java.util.Scanner;

// Handler is an abstract base class providing shared functionality
// for the Input and Output handling classes. It manages a shared 
// scanner instance for reading from STDIN.
public abstract class Handler {
    protected final Scanner scanner;

    // The constructer initialises the scanner to read from STDIN.
    public Handler() {
        this.scanner = new Scanner(System.in);
    }

    // Releases system resources by closing the scanner resource. 
    protected void closeResources() {
        scanner.close();
    }
}