public class TestPersons {
    public static void main(String [] args) {
        Person person1 = new Person(1, "Antonio Alonso", 25, "Programador");
        Person person2 = new Person(2, "Carlos Rodríguez", 30, "Administrativo");

        // Listado de personas

        PersonList list = new PersonList();
        list.addPerson(person1);
        list.addPerson(person2);

        System.out.println("=== Casos prueba ===");

        //Caso 1 : setAge dará error si la edad es negativa

        try {
            System.out.println("\n1. Prueba de setAge con la edad negativa:");
            person1.setAge(-5);
            System.out.println("ERROR: No se ha generado excepción cuando si la edad es negativa");
        } catch (IllegalArgumentException e) {
            System.out.println(" Prueba correcta: " + e.getMessage());
        }

        //Caso 2: findByName, hay que encontrar persona con el formato correcto

        try {
            System.out.println("\n2. Prueba de findByName con el formato correcto:");
            Person found = list.findByName("Carlos Rodríguez");
            if (found != null && found.getName().equals("Carlos Rodríguez")) {
                System.out.println(" Prueba correcta: Se ha encontrado la persona: " + found.getName());
            } else {
                System.out.println("ERROR: No se encontró a la persona");
            }
        } catch (Exception e) {
            System.out.println("ERROR: Se ha producido una excepción inesperada: " + e.getMessage());
        }

        //Caso 3: findByName, hay que generar una excepción con el formato incorrecto

        try {
            System.out.println("\n3. Prueba de findByName con el formato incorrecto:");
            Person found = list.findByName("AntonioAlonso");
            System.out.println("ERROR: No se ha generado la excepción con el formato incorrecto");
        } catch (IllegalArgumentException e) {
            System.out.println(" Prueba correcta: " + e.getMessage());
        }

        //Caso 4: clone nos creará un nuevo objeto con similar contenido y distinto ID.

        try {
            System.out.println("\n4. Prueba del método clone:");
            Person original = person1;
            Person cloned = list.clone(original);

            // Verificamos que las características sean iguales
            if (original.equals(cloned)) {
                System.out.println(" Las características y datos (excepto la ID) son similares");
            } else {
                System.out.println("ERROR: Las características no son iguales");
            }

            // id´s diferentes

            if (original.getId() != cloned.getId()) {
                System.out.println("Los IDs no son iguales");
                System.out.println(" Original ID: " + original.getId());
                System.out.println(" ID clonado: " + cloned.getId());
            } else {
                System.out.println("ERROR: Los IDs son idénticos");
            }
        } catch (Exception e) {
            System.out.println("ERROR: Se ha producido una excepción inesperada: " + e.getMessage());
        }
    }
}
