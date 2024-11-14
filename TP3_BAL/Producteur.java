public class Producteur {
    private Producteur contenuBoîte;
    private String chMonitor;

    public void run(){
        chMonitor.write(contenuBoîte);
    }
}
