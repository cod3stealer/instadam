import java.util.ArrayList;
import java.util.List;
public class PanelRegistros {
    //Atributos
    private List<User> usuario;
    private List<Publicacion> publis;

    //Constructor
    public PanelRegistros () {
        this.usuario = new ArrayList<>();
        this.publis = new ArrayList<>();
    }

    //Metodos de Usuario y Publicacion
    public boolean signup (String nUser, String nPass) {
        //Para el registro es necesario que no existe el usuario de antes.
        //Se comprueba la lista de usuarios registrados,
        //si existe ya retorna un FALSE
        //si no existe, añade un usuario a la lista y retorna un true
        for (User user : usuario) {
            if (user.getnUser().equals(nUser)) {
                return false;
            }
        }
        usuario.add(new User(nUser,nPass));
        return true;
    }

    public boolean login (String nUser, String nPass) {
        //Para el inicio de sesion es necesario que el usuario exista de antes.
        //Se comprueba que tanto el nombre como la contraseña coinciden.
        for (User user : usuario) {
            if (user.getnUser().equals(nUser) && user.getnPass().equals(nPass)) {
                return true;
            }
        }
        return false;
    }

    public void pushMensaje (User usuario, String mensaje) {
        publis.add(new Publicacion(usuario,mensaje));
    }

    public List<Publicacion> verPublis() {
        return publis;
    }

    public User getLoggedUser (String nUser) {
        for (User user : usuario) {
            if (user.getnUser().equals(nUser)) {
                return user;
            }
        }
        return null;
    }
}
