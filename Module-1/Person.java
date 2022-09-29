import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    public static void sortPerson(ArrayList<Person> persons) {
        for(int i = 0; i < persons.size(); i++) {
            for(int j = i+1 ; j < persons.size(); j++) {
                if(persons.get(i).name.compareTo(persons.get(j).name) > 0) {
                    Collections.swap(persons, i, j);
                }
                if(persons.get(i).name.compareTo(persons.get(j).name) == 0) {
                    if(persons.get(i).age > persons.get(j).age) {
                        Collections.swap(persons, i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Guillaume",20));
        persons.add(new Person("John",50));
        persons.add(new Person("Guillaume",10));
        persons.add(new Person("John",10));
        persons.add(new Person("Luc",5));

        sortPerson(persons);
        System.out.println(persons);
    }
}