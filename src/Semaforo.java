import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class Semaforo {
    private final AtomicBoolean libre = new AtomicBoolean(true);

    public void acquire() {
        while (!libre.compareAndSet(true, false)) {
            // Espera activa (spin lock). Se puede usar LockSupport.parkNanos para reducir CPU.
            LockSupport.parkNanos(1000); // Espera breve para evitar consumir mucho CPU
        }
    }

    public void release() {
        libre.set(true);
    }
}
