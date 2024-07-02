package org.example.hexlet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MainPage {
    private boolean visited;
    public boolean iszVisited() {
        return visited;
    }
}
