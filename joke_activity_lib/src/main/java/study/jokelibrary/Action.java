package study.jokelibrary;


import java.io.Serializable;

public interface Action<T> extends Serializable {
    T method();
}
