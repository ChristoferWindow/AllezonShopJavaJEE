package pl.jazapp.app.auctionParameter;

import org.hibernate.annotations.Cascade;
import pl.jazapp.app.auction.persistence.Auction;
import pl.jazapp.app.parameter.persistence.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameter {

    @EmbeddedId
    private AuctionParameterId auctionParameterId = new AuctionParameterId();

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    @MapsId("auctionId")
    private Auction auction;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("parameterId")
    @JoinColumn(name = "parameter_id")
    private Parameter parameter = new Parameter();

    public AuctionParameter() {
    }

    public AuctionParameter(String value, Parameter parameter) {
        this.value = value;
        this.parameter = parameter;
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
