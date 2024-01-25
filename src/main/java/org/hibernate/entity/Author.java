package org.hibernate.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity // класс author - персистентный объект связи с бд
@Getter //шаблоны
@Setter
//@Table(name="") другое название таблицы а не author
public class Author implements Serializable { // POJO Serializable для сериализации(хранения)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//генерация id при добавлении новой записи
    //@Column(name="") другое название столбца а не id,name
    private long id;
    private String name;
}
