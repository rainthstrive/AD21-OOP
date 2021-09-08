package clase10;

public class Artistas{
    private String nombreArtista;
    private Canciones[] canciones = new Canciones[5];
    private int index = 0;

    Artistas(String nombre, String tipo){
        setNombreArtista(nombre);
    }

    public String getNombreArtista(){
        return nombreArtista;
    }
    public void setNombreArtista(String nombre){
        nombreArtista = nombre;
    }
    private void aumentarIndex(){
        index++;
    }

    public void agregarCancion(Canciones cancion){
        if(index < canciones.length)
        {
            canciones[index] = cancion;
            aumentarIndex();
        }
        else
            System.out.println("Límite de canciones alcanzado");
    }

    // TODO: Definir método para agregar multiples canciones

    public void listarCanciones(){
        // TODO: Definir instrucciones para listar canciones
    }
}