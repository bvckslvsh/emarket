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


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private BigDecimal price;
    private String imageurl;
    private String description;



    public Content(String title, BigDecimal price, String imageurl, String description) {
        this.title = title;
        this.price = price;
        this.imageurl = imageurl;
        this.description = description;
    }
}

