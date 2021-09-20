package clase10;

public class Artistas{
    private String nombreArtista;
    private Canciones[] canciones = new Canciones[5];
    private int index = 0;

    Artistas(String nombreArtista){
        setNombreArtista(nombreArtista);
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
            System.out.println("¡Canción agregada a " + getNombreArtista() + "!");
        }
        else
            System.out.println("Límite de canciones alcanzado");
    }
    
    public void agregarCancion(Canciones[] cancion){
        for(Canciones el: cancion) {
        	if(index < canciones.length)
            {
                canciones[index] = el;
                aumentarIndex();
            }
        	else
                System.out.println("Límite de canciones alcanzado");
        }
    }

    public void listarCanciones(){
    	if(canciones[0]!=null) {
    		System.out.println("__________________________");
	    	System.out.println("****Canciones de "+ getNombreArtista() +"****");
	        for(Canciones el: canciones) {
	        	if(el != null)
	        		System.out.println(el.getNombreCancion() + " - " + el.getTipoMusica());
	        	else
	        		break;
	        }
	        System.out.println("****Fin de la lista****");
	        System.out.println("__________________________");
    	} else
    		System.out.println(getNombreArtista() + " no tiene canciones 😴");
    	
    }
}