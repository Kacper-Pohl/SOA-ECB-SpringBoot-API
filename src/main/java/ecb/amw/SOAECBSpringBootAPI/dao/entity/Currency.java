package ecb.amw.SOAECBSpringBootAPI.dao.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String date;
    private String from;
    private String to;
    private double rate;

    public Currency(){
    }

    public Currency(String date, String from, String to, double rate) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }
}
