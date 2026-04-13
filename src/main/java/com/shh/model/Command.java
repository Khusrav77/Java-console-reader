package com.shh.model;

public final class Command {

    private final CommandType type;
    private final Integer id;
    private final Person value;

    public Command(CommandType type, Integer id, Person value) {
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
    public Person getValue() {
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
