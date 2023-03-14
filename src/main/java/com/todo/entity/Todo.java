package com.todo.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "todo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @Column(name = "no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer todoNo;

    @Column(name = "name")
    private String todoName;

    @Column(name = "content")
    private String todoContent;

    @Column(name = "success")
    @ColumnDefault("'N'")
    @Builder.Default
    private String todoSuccess = "N";

}
