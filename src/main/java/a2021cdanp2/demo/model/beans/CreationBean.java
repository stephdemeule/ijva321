package a2021cdanp2.demo.model.beans;


import javax.persistence.*;


@Entity
@Table(name = "creation")
public class CreationBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Double price;
    private String date;
    private String url1;
    private String url2;

    @Transient
    private String pwd;


    public CreationBean() {
    }

    public CreationBean(String name, Double price, String date, String url1, String url2) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.url1 = url1;
        this.url2 = url2;
    }

    @Override
    public String toString() {
        return "CreationBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", url1='" + url1 + '\'' +
                ", url2='" + url2 + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
