package net.mednikov.datastructures.core;

public class Person implements Comparable<Person>{

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return person.getFirstName().equalsIgnoreCase(this.firstName) &&
                person.getLastName().equalsIgnoreCase(this.lastName);
    }

    @Override
    public int compareTo(Person person) {
        int fname = getFirstName().compareTo(person.getFirstName());
        if (fname != 0){
            return fname;
        } else {
            return getLastName().compareTo(person.getLastName());
        }
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}