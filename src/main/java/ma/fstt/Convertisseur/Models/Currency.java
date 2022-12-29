package ma.fstt.Convertisseur.Models;

import jakarta.persistence.*;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class Currency
{
    //Defining book id as primary key
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private String updateTime;

    public Currency() {
    }

    public Currency(String name, Double price, String updateTime) {
        this.name = name;
        this.price = price;
        this.updateTime = updateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getUpdateTime() {
        return updateTime;
    }
}