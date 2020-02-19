package web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
//@Access(AccessType.FIELD)
public class User  {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column (name = "city")
    private String city;

    @Column(name = "age")
    private Integer age;

//    { CascadeType.PERSIST, CascadeType.MERGE}
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name ="user_and_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roleSet = new HashSet<>();
//    private Set<Role> roleSet;

    public User(){
    }
    public User( String name, String surname, String email, String password, String city, Integer age){
//            , Set<Role> roleSet) {
        //Set<Role> roleSet)
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.city = city;
        this.age = age;
        roleSet = new HashSet<>();
//        this.role = role;
//        this.roleSet = roleSet;
//        this.roleSet = getRoleSet();
//       this.roleSet = roleSet = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }
    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
    public void addRole(Role role){
//        roleSet.setUserSet(this);
        roleSet.add(role);
    }
//    public void removeRole(Role role){
//        roleSet.remove(role);
//    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(surname, user.surname)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!Objects.equals(city, user.city)) return false;
        if (!Objects.equals(age, user.age)) return false;
        return Objects.equals(roleSet, user.roleSet);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (roleSet != null ? roleSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", roleSet=" + roleSet +
                '}';
    }

}
