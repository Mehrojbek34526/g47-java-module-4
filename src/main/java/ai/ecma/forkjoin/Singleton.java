package ai.ecma.forkjoin;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 19:25
 **/
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (instance) {
                if (instance == null)
                    instance = new Singleton();
            }
        }

        return instance;
    }

}
