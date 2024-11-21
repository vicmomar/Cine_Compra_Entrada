
public class Exemple02CreateThreads2 implements Runnable {


    //Propietats
    private String nomFil;

    //constructor
    public Exemple02CreateThreads2(String nomFil) {
        this.nomFil = nomFil;
    }

    //mètode run
    @Override
    public void run() {
        String nomActual = Thread.currentThread().getName();
        System.out.println("Fil [" +nomActual+ "] ==> Hello I'm "+ nomActual);
        System.out.println("Fil [" +nomActual+ "] ==> " +nomActual+ " finished.");
    }

    //main
    public static void main(String[] args) {
        System.out.println("\nMain thread ==> Starts");

        //crear obj 1 Runnable
        Exemple02CreateThreads2 objRun1 = new Exemple02CreateThreads2("Tread 1");

        //crear obj 2 Runnable
        Exemple02CreateThreads2 objRun2 = new Exemple02CreateThreads2("Thread 2");

        //crear fil 1
        Thread fil1 = new Thread(objRun1, objRun1.nomFil);

        //crear fil 2
        Thread fil2 = new Thread(objRun2, objRun2.nomFil);

        System.out.println("\nMain thread ==> Executing new thread...");
        fil1.start();
        fil2.start();
        try {
            fil1.join();
            fil2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread ==> just finished.");
    }
}
