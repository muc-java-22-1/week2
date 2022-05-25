package io.github.mysterix5.studentinterface;

import java.util.Objects;
import java.util.UUID;

public interface Student {

    void sayHello();

    String getID();

    boolean equals(Object o);
    int hashCode();
    String toString();


}
