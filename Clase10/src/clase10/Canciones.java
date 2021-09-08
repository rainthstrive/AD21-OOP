package clase10;

public class Canciones extends TiposMusicales{
    private String nombreCancion;

    Canciones(String nombreCancion, String tipo){
    	super(tipo);
    	setNombreCancion(nombreCancion);
    }

    public String getNombreCancion(){
        return nombreCancion;
    }
    public void setNombreCancion(String nombreCancion){
    	this.nombreCancion = nombreCancion;
    }
}