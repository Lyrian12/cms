package com.example.cms.entries;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Entity
@Table(name = "entries")
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    private String Desc;
    private String author;
    private String category;
    private String tag;
    private String link;
    private Date create_at;
}
