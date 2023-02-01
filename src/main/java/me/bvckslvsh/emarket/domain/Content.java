package me.bvckslvsh.emarket.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contents")
public class Content {

    private static final String NAMESEQ = "contentseq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAMESEQ)
    @SequenceGenerator(name = NAMESEQ, sequenceName = NAMESEQ, allocationSize = 1)
    private Long id;
    private String title;
    private BigDecimal price;
    private String imageurl;
    private String description;

    private long categoryId;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "content_categories",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
}

