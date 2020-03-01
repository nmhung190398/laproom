package com.nmhung.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "tbluser")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullname;

    @Column(name="email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity role;

    @OneToMany(mappedBy = "subject")
    private List<ClassEntity> classes;
}
