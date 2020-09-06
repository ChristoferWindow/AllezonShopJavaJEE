package pl.jazapp.app.auctionParameter;

import org.hibernate.annotations.Cascade;
import pl.jazapp.app.auction.persistence.Auction;
import pl.jazapp.app.parameter.persistence.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "auction_id")
    @MapsId
    private Auction auction;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "parameter_id")
    @MapsId
    private Parameter parameter;

    public AuctionParameter() {
    }

    public AuctionParameter(String value, Parameter parameter) {
        this.value = value;
        this.parameter = parameter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}
