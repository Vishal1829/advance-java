package org.advancedjava.lombokdemo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//while generating the toString we can specify which fields we want to not include
//@ToString(exclude = "dept")
//@EqualsAndHashCode
@Builder
//it will keep all data members as private final we do not need to specify explicitly and also it makes
//class as final class
@Value
//@Data covers: EqualsAndHashCode, ToString, Getter, Setter (not constructors)
//@Data
public class Employee {
    int id;
    String name;
    String dept;
}
