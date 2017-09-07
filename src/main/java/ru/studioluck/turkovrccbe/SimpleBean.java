package ru.studioluck.turkovrccbe;

public class SimpleBean {
    private String someString;

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SimpleBean{");
        sb.append("someString='").append(someString).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
