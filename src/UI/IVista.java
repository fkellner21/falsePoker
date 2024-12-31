package UI;

public interface IVista<T> extends IError {
    public void cargarDatos(T dato);
    public void cargarInformacionAdicional(T dato);
}
