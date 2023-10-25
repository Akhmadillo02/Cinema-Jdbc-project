package uz.najottalim.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cinema {
    private Long id;
    private String name;
    private String director;
    private String producer;
    private LocalTime duration;
    private LocalDate date;
    private Long budget;

    public Cinema(Long id, String name, String director, String producer, LocalTime duration, LocalDate date, Long budget) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.producer = producer;
        this.duration = duration;
        this.date = date;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", budget=" + budget +
                "}\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}
