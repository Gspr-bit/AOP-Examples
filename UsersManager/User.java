public class User {
    private String username;
    private String password;
    private boolean active;

    /* CONSTRUCTOR */
    public User(String username,
                String password)
    {
        this.username = username;
        this.password = password;
        this.active = false;
    }

    /* GETTERS */
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isActive() {
        return this.active;
    }

    /* SETTERS */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /* MÉTODOS */
    public void changePassword(String username, String oldPassword, String newPassword) throws LoginFailedException, InvalidDataException {
        if (username != this.username || oldPassword != this.password) {
            throw new LoginFailedException("Nombre de usuario o contraseña incorrectos");
        } else if (newPassword.length() < 8) {
            throw new InvalidDataException("La contraseña debe contar con un mínimo de 8 dígitos");
        } else {
            setPassword(newPassword);
            System.out.println("La contraseña ha sido cambiada");
        }
    }

    public void login(String username, String password) throws LoginFailedException {
        if (username == this.username && password == this.password) {
            setActive(true);
            System.out.println(this.username + " ha iniciado sesión");
        } else {
            throw new LoginFailedException("Nombre de usuario o contraseña incorrectos");
        }
    }

    public void logout() {
        setActive(false);
        System.out.println(this.username + "Ha cerrado sesión");
    }
}
