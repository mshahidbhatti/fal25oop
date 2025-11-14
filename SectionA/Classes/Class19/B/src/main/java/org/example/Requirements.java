package org.example;

import java.io.Serializable;

public interface Requirements extends MultiMediaPlayer, Serializable {
    void add();
    void update();
    void delete();
    void read();
}
