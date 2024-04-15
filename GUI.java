import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    //Atributos
    private PanelRegistros social;
    private User usuario;

    //Metodo único -> App
    public GUI() {
        social = new PanelRegistros();
        setLayout(new BorderLayout());

        // Layout, botones, listeners...
        JPanel panel = new JPanel();
        setLayout(new GridLayout(8,2));

        //Button de registro de usuarios
        JButton signup = new JButton("Sign up");
        signup.addActionListener(e -> {
            String nUser = JOptionPane.showInputDialog("Nombre de usuario: ");
            String nPass = JOptionPane.showInputDialog("Contraseña: ");
            if (social.signup(nUser,nPass)) {
                JOptionPane.showMessageDialog(null,"Registro realizado con exito!");
            } else {
                JOptionPane.showMessageDialog(null,"Error");
            }
        });

        //Button de inicio de sesion de usuarios
        JButton login = new JButton("Log in");
        login.addActionListener(e -> {
            String nUser = JOptionPane.showInputDialog("Nombre de usuario: ");
            String nPass = JOptionPane.showInputDialog("Contraseña: ");
            if (social.login(nUser, nPass)) {
                usuario = social.getLoggedUser(nUser);
                JOptionPane.showMessageDialog(null,"Inicio de sesion realizado con exito!");
            } else {
                JOptionPane.showMessageDialog(null,"Error");
            }
        });

        //Button publicacion
        JButton push = new JButton("Publicar");
        push.addActionListener(e -> {
            if (usuario != null) {
                String mensaje = JOptionPane.showInputDialog("Qué quieres publicar? ");
                social.pushMensaje(usuario,mensaje);
                JOptionPane.showMessageDialog(null,"Mensaje publicado con exito!");
            } else {
                JOptionPane.showMessageDialog(null,"Error");
            }
        });

        //Button listado de publicacion
        JButton listado = new JButton("Ver listado de publicaciones");
        listado.addActionListener(e -> {
            StringBuilder publis = new StringBuilder();
            for (Publicacion publi : social.verPublis()) {
                publis.append(publi.getUsuario()).append(": ").append(publi.getMensaje()).append("\n");
            }
        });

        /*
        Estas líneas crean un contenedor llamado panel y le agrego cuatro componentes: signup, login, push y listado:
        signup: botón relacionado con el registro de usuarios.
        login: botón para el inicio de sesión del usuario.
        push: botón de publicacion.
        listado: lista que muestra datos de publicaciones.
        */
        panel.add(signup);
        panel.add(login);
        panel.add(push);
        panel.add(listado);

        /*
        Esta línea agrega el panel al panel de contenido de un JFrame (la ventana principal de la aplicación).
        Utiliza el administrador de diseño BorderLayout, que coloca los componentes en cinco regiones:
        norte, sur, este, oeste y centro.
        Aquí, panel se coloca en la región central.
        */
        add(panel,BorderLayout.CENTER);

        /*
        Estas líneas configuran la ventana JFrame:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE): Establece el comportamiento predeterminado para cerrar la ventana.
        JFrame.EXIT_ON_CLOSE asegura que la aplicación finalice cuando el usuario hace clic en el botón de cierre de la ventana (X en la esquina).

        pack(): Este método instruye al administrador de diseño que calcule el tamaño mínimo necesario para que quepan todos los componentes
        en la ventana de forma cómoda, en función de sus tamaños preferidos.

        setVisible(true): Hace que la ventana JFrame sea visible en la pantalla.
        */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
