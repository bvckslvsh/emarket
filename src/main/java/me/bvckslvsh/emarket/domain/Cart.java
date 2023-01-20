package me.bvckslvsh.emarket.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "carts")
public class Cart {

    private static final String NAMESEQ = "cartseq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAMESEQ)
    @SequenceGenerator(name = NAMESEQ, sequenceName = NAMESEQ, allocationSize = 1)
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(name = "carts_content",
    joinColumns = @JoinColumn(name = "cart_id"),
    inverseJoinColumns = @JoinColumn(name = "content_id"))
    private List<Content> contents;
}
