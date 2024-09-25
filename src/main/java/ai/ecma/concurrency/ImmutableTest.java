package ai.ecma.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 09/09/24 21:05
 **/
public class ImmutableTest {

    public static void main(String[] args) {

        Address address = new Address("Street-1", "Tashkent");

        List<String> hobbies = new ArrayList<>(List.of("Football"));

        ImmutableEmployee employee = new ImmutableEmployee("Ali", "Valiyev", address, hobbies);

        System.out.println("employee = " + employee);

        hobbies.add("Bassketball");

        employee.getAddress().setCity("London");

        address.setCity("London");

        System.out.println("employee = " + employee);

    }

}
