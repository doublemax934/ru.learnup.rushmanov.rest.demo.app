package ru.learnup.rushmanov.spring.mvc.rest.entity;
import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String ticketTitle;
    @Column(name="price")
    private int price;
    @Column(name="status")
    private String status;
    @Column(name="seat_number")
    private  int seatNumber;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name ="theatrical_performance_id")
//    private TheatricalPerformance theatricalPerformance;


    public Ticket() {
    }

//    public TheatricalPerformance getTheatricalPerformance() {
//        return theatricalPerformance;
//    }
//
//    public void setTheatricalPerformance(TheatricalPerformance theatricalPerformance) {
//        this.theatricalPerformance = theatricalPerformance;
//    }

    public Ticket(String ticketTitle, int price, int seatNumber) {
        this.ticketTitle = ticketTitle;
        this.price = price;
        this.status = "on sale";
        this.seatNumber=seatNumber;
    }

    public int getPrice() {
        return price;
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

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
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


    @Override
    public String toString() {
        return ticketTitle+ " {price; " +
                 + price +
                ", seat number: " + seatNumber +
                ", id: '" + id + '\'' +
                '}';
    }
}