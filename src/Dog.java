import java.util.Objects;

/**
 * ClassName：Dog
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Author:XiaoYang
 * @Create:2024/2/1 - 12:19
 */
public class Dog {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private String name;




}
