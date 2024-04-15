public class User {
    //Atributos
    private String nUser;
    private String nPass;

    //Constructor
    public User (String nUser, String nPass) {
        this.nUser = nUser;
        this.nPass = nPass;
    }

    //Getter y Setter
    public String getnUser () {
        return nUser;
    }
    public String getnPass () {
        return nPass;
    }
    public void setnUser (String nUser) {
        this.nUser = nUser;
    }
    public void setnPass (String nPass) {
        this.nPass = nPass;
    }
}
