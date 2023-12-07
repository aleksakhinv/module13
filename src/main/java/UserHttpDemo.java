import model.*;
import service.UserHttpService;

import java.io.IOException;

public class UserHttpDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        User user = createDefaultUser();

        UserHttpService userHttpService = new UserHttpService();

        System.out.println("--- Create new User ---");
        User createdUser = userHttpService.createUser(user);
        System.out.println(createdUser);
        System.out.println();


        System.out.println("--- Information about all Users ---");
        User[] allUsers = userHttpService.getAllUsers();
        for(User u : allUsers) {
            System.out.println(u);
        }
        System.out.println();

        System.out.println("--- Get User by ID ---");
        User userById = userHttpService.getUserById(1);
        System.out.println(userById);
        System.out.println();

        System.out.println("--- Update User ---");
        userById.setName("UPDATE Name");
        User updatedUser = userHttpService.updateUser(userById);
        System.out.println(updatedUser);
        System.out.println();

        System.out.println("--- Get User by Username ---");
        User userByUsername = userHttpService.getUserByUsername("Kamren");
        System.out.println(userByUsername);
        System.out.println();

        System.out.println("--- Delete User ---");
        int userDeleteStatusCode = userHttpService.deleteUser(1);
        System.out.println("User deleted. Status code: "+ userDeleteStatusCode);

    }

    private static User createDefaultUser() {
        Geo geo = new Geo();
        geo.setLat("50.45466");
        geo.setLng("30.5238");

        Address address = new Address();
        address.setStreet("New Street");
        address.setSuite("777");
        address.setCity("Kyiv");
        address.setZipcode("01001");
        address.setGeo(geo);

        Company company = new Company();
        company.setName("My Company");
        company.setCatchPhrase("Run and go");
        company.setBs("Some text");

        User user = new User();
        user.setId(1);
        user.setName("Vitalii");
        user.setUsername("UserVitalii");
        user.setEmail("vitalii@gmail.com");
        user.setAddress(address);
        user.setPhone("+380 97 777 77 77");
        user.setWebsite("mywebsite.com");
        user.setCompany(company);
        return user;
    }
}
