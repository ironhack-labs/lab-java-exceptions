package org.example;

public class Person {
        private int id;
        private String name;
        private int age;
        private String occupation;

        // Constructor
        public Person(int id, String name, int age, String occupation) {
            this.id = id;
            this.name = name;
            this.setAge(age);
            this.occupation = occupation;
        }

        // Setters and Getters
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
                throw new IllegalArgumentException("Age cannot be less than 0");
            }
            this.age = age;
        }

        public String getOccupation() {
            return occupation;
        }

        // Equals Method
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Person person = (Person) obj;
            return age == person.age &&
                    name.equals(person.name) &&
                    occupation.equals(person.occupation);
        }

        @Override
        public String toString() {
            return "Person{id=" + id + ", name='" + name + "', age=" + age + ", occupation='" + occupation + "'}";
        }
    }
