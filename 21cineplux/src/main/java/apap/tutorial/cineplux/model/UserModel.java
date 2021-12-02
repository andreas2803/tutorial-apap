package apap.tutorial.cineplux.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="user")

<<<<<<< HEAD
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
=======
>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
    private String id;

    @NotNull
    @Size(max = 50)
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Size(max = 50)
<<<<<<< HEAD
    @Column(name = "nama", nullable = false, unique = true)
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
    private String nama;

    @NotNull
    @Size(max = 50)
<<<<<<< HEAD
    @Column(name = "email", nullable = false, unique = true)
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
    private String email;

    @NotNull
    @Lob
<<<<<<< HEAD
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @ManyToOne(fetch =  FetchType.EAGER)
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RoleModel role;
<<<<<<< HEAD
}
=======
>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
