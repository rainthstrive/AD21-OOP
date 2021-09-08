package clase10;

public class TiposMusicales{
    private String tipoMusica;

    TiposMusicales(String tipo) {
        setTipoMusica(tipo);
    }

    public String getTipoMusica(){
        return tipoMusica;
    }
    public void setTipoMusica(String tipo){
        tipoMusica = tipo;
    }
}