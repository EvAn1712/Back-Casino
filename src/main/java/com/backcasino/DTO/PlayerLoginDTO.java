package com.backcasino.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerLoginDTO {
    private String username;
    private String password;

    public PlayerLoginDTO() {
    }

    public PlayerLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }



}
