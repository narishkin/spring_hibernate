package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

//    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "car")
//    User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private long id;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_series")
    private int series;

    public Car(){}

    public Car(String model, int series) {

        this.model = model;
        this.series = series;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


}
