
class Pelicula {
    private String nombre;
    private int año;
    private boolean enExhibicion;

    public Pelicula(String nombre, int año, boolean enExhibicion) {
        this.nombre = nombre;
        this.año = año;
        this.enExhibicion = enExhibicion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAño() {
        return año;
    }

    public boolean isEnExhibicion() {
        return enExhibicion;
    }

    public void setEnExhibicion(boolean enExhibicion) {
        this.enExhibicion = enExhibicion;
    }
}