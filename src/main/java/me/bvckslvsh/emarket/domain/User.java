package me.bvckslvsh.emarket.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    private static final String NAMESEQ = "userseq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAMESEQ)
    @SequenceGenerator(name = NAMESEQ, sequenceName = NAMESEQ, allocationSize = 1)
    private long id;
    private String name;
    private String password;
    private String email;
    private boolean archive;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Cart cart;
}
