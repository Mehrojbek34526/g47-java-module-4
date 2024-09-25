package ai.ecma.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 09/09/24 21:05
 **/
public final class ImmutableEmployee {

    private final String firstName;
    private final String lastName;
    private final Address address;
    private final List<String> hobbies;

    public ImmutableEmployee(String firstName, String lastName, Address address, List<String> hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address.clone();
        this.hobbies = new ArrayList<>(hobbies);
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address.clone();
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);
    }

    @Override
    public String toString() {
        return "ImmutableEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }
}
