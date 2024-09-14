package org.advancedjava.mapoperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    enum Gender { MALE, FEMALE }

    enum City { BOSTON, NEWYORK, DC }

    private record Person(int id, String name, int age, Gender gender, City city) {}

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person(1, "John Doe", 10, Gender.MALE, City.DC),
                new Person(1, "Jack Doe", 23, Gender.MALE, City.DC),
                new Person(3, "Joel Doe", 48, Gender.MALE, City.BOSTON),
                new Person(4, "Joan Doe", 25, Gender.FEMALE, City.DC),
                new Person(6, "Jill Doe", 35, Gender.FEMALE, City.NEWYORK),
                new Person(7, "Jane Doe", 15, Gender.FEMALE, City.DC),
                new Person(8, "Jean Doe", 38, Gender.FEMALE, City.BOSTON)
        );

        // Create a list of Female names
        List<String> femaleNames = persons.stream()
                .filter(p -> p.gender == Gender.FEMALE)
                .map(Person::name)
                .toList();

        // Create a Map of Gender to List of Person
        // Creating Maps Imperative Style
        Map<Gender, List<Person>> genderMap = new HashMap<>();
        for (Person person : persons) {
            //typically we check if the genderMap contains the person's gender and if it doesn't we create
            //a new arrayList and add it to the Map -> the shortcut for that is to use computeIfAbsent
            List<Person> genderList =
                    genderMap.computeIfAbsent(
                        person.gender(),
                        p -> new ArrayList<>()
                     );
            genderList.add(person);
        }

        genderMap.forEach((gender, people) -> {
            System.out.println(gender);
            people.forEach(System.out::println);
        });

        // Functional style of doing the above
        // Create a Map of Person ID => Person Object
        Map<Integer, Person> personMap =
                persons.stream().collect(
                Collectors.toMap(
                        Person::id,
                        Function.identity(),   // equivalent to: p -> p
                        (p1, p2) -> p1
                )
        );

        // Create a Map of Gender to List of Person
        // Functional Style
        Map<Gender, List<Person>> genderListMap =
                persons.stream().collect(
                Collectors.groupingBy(
                        Person::gender  // key for grouping
                )
        );

        // Create a Map of Gender to List of Person Names
        Map<Gender, List<String>> genderListMap1 =
                persons.stream().collect(
                Collectors.groupingBy(
                        Person::gender,  // key for grouping
                        Collectors.mapping(
                                Person::name,
                                Collectors.toList()
                        )
                )
        );

        // Create a Map of Gender to Count of Person List
        Map<Gender, Long> genderCountMap =
                persons.stream().collect(
                Collectors.groupingBy(
                        Person::gender,
                        Collectors.counting()
                )
        );

        // Create a Map of Gender to Map of City to Person List
        Map<Gender, Map<City, List<Person>>> genderCityMap =
                persons.stream().collect(
                Collectors.groupingBy(
                        Person::gender,
                        Collectors.groupingBy(
                                Person::city
                        )
                )
        );
        // Access the Map
        // all males who lives in newyork city
        List<Person> people = genderCityMap
                .computeIfAbsent(Gender.MALE, p -> new HashMap<>())
                .computeIfAbsent(City.NEWYORK, p -> new ArrayList<>());
        System.out.println(people);

        /*
            we can use computeIfAbsent in a map becoz in case if return value is null automatically the second
            value which we provided will be returned and not a null.
         */

        // Create a Map of Gender to Map of City to Person Count
        Map<Gender, Map<City, Long>> genderCityMap1 =
                persons.stream().collect(
                Collectors.groupingBy(
                        Person::gender,
                        Collectors.groupingBy(
                                Person::city,
                                Collectors.counting()
                        )
                )
        );
    }
}

/*
Collectors is a class which contains a lot of static methods which are gonna return us collector implementations and these
collectors implementation are gonna be input to the collect call of the stream, that's what a collect will will take
a Collector interface.

Note:- record in Java is available from Java 16 onwards
 */
