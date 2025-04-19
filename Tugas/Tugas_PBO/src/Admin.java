public class Admin extends User {
    private String username;
    private String password;
    
    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Login Admin Berhasil!");
        super.displayInfo();
        System.out.println("Username: " + username);
    }
}