package web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rolesName")
    private String rolesName;

    @ManyToMany(mappedBy = "roleSet", cascade = CascadeType.PERSIST)
//    @JoinTable(name = "user_and_role",
//            joinColumns = @JoinColumn(name = "role_id"),
//    inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> userSet = new HashSet<>();

    public Role(){
    }
    public Role(String rolesName){
        this.rolesName = rolesName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }


    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

}
