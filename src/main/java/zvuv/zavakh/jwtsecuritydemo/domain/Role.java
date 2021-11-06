package zvuv.zavakh.jwtsecuritydemo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "roles")
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role", length = 50, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String getAuthority() {
        return role.toString();
    }
}