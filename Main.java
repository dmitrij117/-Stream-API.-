import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count = persons.stream().
                filter((p) -> p.getAge() < 18).
                count();
        System.out.println("Несовершеннолетних: " + count);

        List<String> fam = persons.stream().filter((a) -> a.getAge() >= 18 && a.getAge() < 27 && a.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Фамилии призывников: " + fam);

        List<Person> works = persons.stream().filter((w) -> w.getAge() >= 18 && w.getAge() < 60
                || w.getSex() == Sex.MAN && w.getAge() >= 60 && w.getAge() < 65)
                .filter((e) -> e.getEducation() == Education.HIGHER).sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("Потенциально работоспособные люди с высшим образованием:" + works);
    }
}
