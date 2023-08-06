package com.tugceozcakir.erpsystem.util;

public enum StatusEnum {
    WAITING,
    APPROVED,
    REJECTED;

    public static StatusEnum fromString(String status) {
        return switch (status) {
            case "waiting" -> WAITING;
            case "approved" -> APPROVED;
            case "rejected" -> REJECTED;
            default -> null;
        };
    }
}