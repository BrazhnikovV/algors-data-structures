import java.util.Objects;

/**
 * Person
 */
public class Person {

    /**
     * @access private
     * String firstName
     */
    private String firstName;

    /**
     * @access private
     * String firstName
     */
    private String lastName;

    /**
     * @access private
     * String firstName
     */
    private int age;

    /**
     * getFirstName - получить имя
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstName - установить имя
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getLastName - получить фамилию
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setLastName - установить фамилию
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getAge - получить возраст
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * setAge - установить возраст
     * @param age - возраст
     */
    public void setAge(int age) {
        if ( age < 0 ) {
            try {
                throw new IllegalAccessException( "Возраст не может быть отрицательным" );
            }
            catch  (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.age = age;
    }

    /**
     * Person - конструктор
     * @param firstName - имя
     * @param lastName  - фамилия
     * @param age       - возраст
     */
    public Person( String firstName, String lastName, int age ) {
        this.setAge( age );
        this.setFirstName( firstName );
        this.setLastName( lastName );
    }

    @Override
    public boolean equals( Object o ) {

        if ( this == o ) {
            return true;
        }

        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }

        Person person = ( Person ) o;

        return this.age == person.age &&
                Objects.equals( this.firstName, person.firstName ) &&
                Objects.equals( this.lastName, person.lastName );
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
