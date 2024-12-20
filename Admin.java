public class Admin extends User {
    public Admin(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void viewDetails() {
        System.out.println("Admin Details:");
        System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
    }

    public void addUser(User user) {
        System.out.println("Adding user: " + user.name);
    }

    public void modifyUser(User user) {
        System.out.println("Modifying user: " + user.name);
    }
}
