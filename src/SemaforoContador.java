import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class SemaforoContador {
    private final AtomicInteger permisos;

    public SemaforoContador(int permisosIniciales) {
        this.permisos = new AtomicInteger(permisosIniciales);
    }

    public void Wait() {
        while (true) {
            int actual = permisos.get();
            if (actual > 0) {
                // Intenta restar un permiso
                if (permisos.compareAndSet(actual, actual - 1)) {
                    return; // Obtuvo el permiso
                }
            }
            // No hay permisos disponibles o fallo en compareAndSet: esperar brevemente
            LockSupport.parkNanos(1000); // Espera muy corta para no quemar CPU
        }
    }

    public void Signal() {
        permisos.incrementAndGet(); // Libera un permiso
    }

    public int disponibles() {
        return permisos.get();
    }
}
