package com.shh.model;

public final class Command {

    private final CommandType type;
    private final Integer id;
    private final String value;

    public Command(CommandType type, Integer id, String value) {
        this.type = type;
        this.id = id;
        this.value = value;
    }

    public  CommandType getType() {
        return type;
    }
    public Integer getId() {
        return id;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Command{" +
                "type=" + type +
                ", id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
