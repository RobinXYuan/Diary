package com.gooddiary.diary.model.authority;


public enum  Permission {
    READ(1), WRITE(2), FOLLOW(4), MODIFY(8), ADMINISTRATOR(16);

    private int value;

    Permission(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Permission parse(int id) {
        Permission permission = null; // Default
        for (Permission item : Permission.values()) {
            if (item.getValue()==id) {
                permission = item;
                break;
            }
        }
        return permission;
    }
}
