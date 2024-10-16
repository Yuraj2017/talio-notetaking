package commons;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.io.Serializable;


public class Subtask implements Serializable {

    public String name;

    public boolean checked;

    public Subtask() {}

    public Subtask(String name) {
        this.name = name;
        checked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChecked(boolean b) {
        this.checked = b;
    }

    public boolean getChecked() {
        return this.checked;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this,o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "name='" + name + '\'' +
                ", checked=" + checked +
                '}';
    }
}
