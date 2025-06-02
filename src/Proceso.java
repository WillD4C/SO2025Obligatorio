public class Proceso {
    private int Prioridad;
    private int idProceso;
    private String tipoProceso;
    private Boolean esActivo;
    private int horaInicio;
    private int horaFin;
    private String Motivo;

    public Proceso(int Prioridad, int idProceso, String tipoProceso,
                    int horaInicio, String Motivo) {
        this.Prioridad = Prioridad;
        this.idProceso = idProceso;
        this.tipoProceso = tipoProceso;
        this.esActivo = false;
        this.horaInicio = horaInicio;
        this.horaFin = 0;
        this.Motivo = Motivo;
    }

    public int getIdProceso() { return idProceso; }
    public int getPrioridad() { return Prioridad; }
    public String getTipoProceso() { return tipoProceso; }
    public int getHoraInicio() { return horaInicio; }
    public int getHoraFin() { return horaFin; }
    public String getMotivo() { return Motivo; }
    @Override
    public String toString() {
        return "Proceso{" +
                "idProceso=" + idProceso +
                ", Prioridad=" + Prioridad +
                ", tipoProceso='" + tipoProceso + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", Motivo='" + Motivo + '\'' +
                '}';
    }

    public boolean ObtenerEstado(){
        return esActivo;
    }
    public void Ejecutar(){

    }
    public void Esperar(){

    }
    public void imprimir(){

    }
}
