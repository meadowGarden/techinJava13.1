package test;

import lt.techin.stream.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main() {
        List<lt.techin.stream.User> users = new ArrayList<>();
        users.add(new lt.techin.stream.User("a", 15, false));
        users.add(new lt.techin.stream.User("b", 16, true));
        users.add(new lt.techin.stream.User("c", 18, true));
        users.add(new lt.techin.stream.User("d", 12, false));
        users.add(new lt.techin.stream.User("e", 11, true));

        System.out.println(noneMatch(users, 10));

    }

    public static boolean noneMatch(List<User> users, int age){
        return users.stream()
                .anyMatch(u -> u.getAge() == age);
//        throw new UnsupportedOperationException("Not implemented");
    }

}
