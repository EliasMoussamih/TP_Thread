public abstract class Cemafaur {

    protected int valeur=0;

    protected Cemafaur(int valeurInitiale){
	valeur = valeurInitiale>0 ? valeurInitiale:0;
    }

    public synchronized void syncWait(){
	try {
	    while(valeur<=0){
		wait();
        }
	    valeur--;
	} catch(InterruptedException e){}
    }

    public synchronized void syncSignal(){
	if(++valeur > 0) notifyAll();
    }
}
