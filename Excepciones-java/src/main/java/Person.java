public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    // Constructor

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad de la persona no puede ser menor que 0");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation( String occupation) {
        this.occupation = occupation;
    }

    // Equals para comparar si dos personas son iguales salvo el id que no puede ser el mismo.

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person otherPerson = (Person) obj;

        // hacemos una comparación de los atributos de las personas, pero no la id.

        return name.equals(otherPerson.name) &&
                age == otherPerson.age &&
                occupation.equals(otherPerson.occupation);
    }

    // Mostramos la información de la persona con el metodo ToString

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id + ", name=´" + name + '\'' + ", age=" + age + ", occupation='" + occupation +
                '\'' + '}';

    }
}
