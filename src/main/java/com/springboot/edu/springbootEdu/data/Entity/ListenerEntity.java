package com.springboot.edu.springbootEdu.data.Entity;

import com.springboot.edu.springbootEdu.data.Entity.listener.ConstructorListener;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Listener")
// ConstructorListener 클래스를 하나의 속성값으로 이 어노테이션을 사용하여 대입을 함
@EntityListeners(ConstructorListener.class)
public class ListenerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
