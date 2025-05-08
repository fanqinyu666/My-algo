package 算法复习.小练习;

public class customues {

    private String name;
    private String address;
    private int id;

    public customues(String address, int id, String name) {
        this.address = address;
        this.id = id;
        this.name = name;
    }

    public customues() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "customues{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }



}
