package org.advancedjava.objectmapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
   String id;
   String title;
   String slug;
   LocalDate date;
   Integer timeToRead;
   String tags;
}
