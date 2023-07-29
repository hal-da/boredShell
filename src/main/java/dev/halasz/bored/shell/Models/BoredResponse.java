package dev.halasz.bored.shell.Models;

public record BoredResponse(String activity, BORED_RESPONSE_TYPE type, int participants, double price, String link, String key, double accessibility) {
}
