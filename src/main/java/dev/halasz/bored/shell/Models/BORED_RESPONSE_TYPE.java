package dev.halasz.bored.shell.Models;
//["education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork"]

import java.util.Arrays;
import java.util.Optional;

public enum BORED_RESPONSE_TYPE {
    education("education"),
    recreational("recreational"),
    social("social"),
    diy("diy"),
    charity("charity"),
    cooking("cooking"),
    relaxation("relaxation"),
    music("music"),
    busywork("busywork");

    private final String type;

    BORED_RESPONSE_TYPE(String type) {
        this.type = type.toUpperCase();
    }

    public static Optional<BORED_RESPONSE_TYPE> get(String inputType) {
        return Arrays.stream(BORED_RESPONSE_TYPE.values())
                .filter(type -> type.toString().equals(inputType))
                .findFirst();
    }

//    public String[] getAsArr(){
//        return Arrays.stream(BORED_RESPONSE_TYPE.values()).map(Enum::name).toList();
//    }
}
