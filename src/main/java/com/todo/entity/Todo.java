package com.todo.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity(name = "todo")
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

    public void copy(Todo todo){
        this.todoName = todo.todoName;
        this.todoContent = todo.todoContent;
        this.todoSuccess = todo.todoSuccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Todo todo = (Todo) o;
        return todoNo != null && Objects.equals(todoNo, todo.todoNo);
    }
        @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
