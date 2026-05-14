public class Usuario {
    //Atributos
    private String name;
    private String userName;
    private String password;

    //Constructor
//    public Usuario(String name, String userName, String password){
//        this.setName(name);
//        this.setUserName(userName);
//        this.setPassword(password);
//    }

    //Métodos

    //Getters

    public String getName() {
        return name;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword() {
        return password;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
