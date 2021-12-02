package apap.tutorial.cineplux.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
import org.springframework.format.annotation.DateTimeFormat;
=======
>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

<<<<<<< HEAD

=======
>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "role")
<<<<<<< HEAD
public class RoleModel implements Serializable{
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
<<<<<<< HEAD
    @Size(max = 50)
    @Column(name = "role", nullable = false)
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
    private String role;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<UserModel> userRole;
<<<<<<< HEAD
}
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
