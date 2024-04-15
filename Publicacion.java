public class Publicacion {
    //Atributos
    private User usuario;
    private String mensaje;

    //Constructor
    public Publicacion (User usuario, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
    }

    //Getter y Setter
    public String getUsuario () {
        return usuario.getnUser();
    }
    public String getMensaje () {
        return mensaje;
    }
    public void setUsuario (String nUser) {
        usuario.setnUser(nUser);
    }
    public void setMensaje (String mensaje) {
        this.mensaje = mensaje;
    }
}
