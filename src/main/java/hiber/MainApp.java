package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car car1 = new Car("Porsche", 911);
        Car car2 = new Car("Audi", 100);
        Car car3 = new Car("Mercedes", 202);
        Car car4 = new Car("Toyota", 80);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

        List<User> users = userService.listUsers();
        getUsersList(users);
        List<User> selectedUsers = userService.listSelectedUsers();
        getUsersList(selectedUsers);

        context.close();
    }

    private static void getUsersList(List<User> selectedUsers) {
        for (User selectedUser : selectedUsers) {
            System.out.println("Id = " + selectedUser.getId());
            System.out.println("First Name = " + selectedUser.getFirstName());
            System.out.println("Last Name = " + selectedUser.getLastName());
            System.out.println("Email = " + selectedUser.getEmail());
            System.out.println("Car = " + selectedUser.getCar().getModel());
            System.out.println("Serie = " + selectedUser.getCar().getSeries());
            System.out.println();
        }
    }
}
