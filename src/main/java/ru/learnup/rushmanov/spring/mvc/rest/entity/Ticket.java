package ru.learnup.rushmanov.spring.mvc.rest.entity;
import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String ticketTitle;
    @Column(name="price")
    private int price;
    @Column(name="status")
    private String status;
    @Column(name="seat_number")
    private  int seatNumber;
    @Column(name = "theatrical_performance_id")
    private Integer theatricalPerformanceId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="theatrical_performance_id")
//    private TheatricalPerformance theatricalPerformance;


    public Ticket() {}


    public Ticket(String ticketTitle, int price, int seatNumber, Integer theatricalPerformanceId) {

        this.ticketTitle = ticketTitle;
        this.price = price;
        this.status = "on sale";
        this.seatNumber=seatNumber;
        this.theatricalPerformanceId = null;
    }


    public String buy (int price){
        if(this.price == price){
            this.status = "sold";
        }
        return status;
    }

    public String ticketRefund (int price){
        if(this.price == price){
            this.status = "on sale";
        }
        return status;
    }

    public Integer getTheatricalPerformanceId() {
        return theatricalPerformanceId;
    }

    public void setTheatricalPerformanceId(Integer theatricalPerformanceId) {
        this.theatricalPerformanceId = theatricalPerformanceId;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public TheatricalPerformance getTheatricalPerformance() {
//        return theatricalPerformance;
//    }
//
//    public void setTheatricalPerformance(TheatricalPerformance theatricalPerformance) {
//        this.theatricalPerformance = theatricalPerformance;
//    }

    @Override
    public String toString() {
        return ticketTitle+ " {price; " +
                 + price +
                ", seat number: " + seatNumber +
                ", id: '" + id + '\'' +
                '}';
    }
}