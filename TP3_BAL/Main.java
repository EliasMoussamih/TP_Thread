public class Main {
    private String buffer;
    private boolean disponible;

    public synchronized void write(String buffer, Boolean disponible) {
        this.buffer = buffer;
        this.disponible = disponible;
    }

    public synchronized String read() {
        return buffer;
    }
}
