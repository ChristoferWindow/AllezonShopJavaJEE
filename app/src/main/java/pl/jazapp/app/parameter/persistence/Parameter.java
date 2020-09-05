package pl.jazapp.app.parameter.persistence;

import pl.jazapp.app.auction.persistence.Auction;
import pl.jazapp.app.auctionParameter.AuctionParameter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parameter")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "parameter")
    private List<AuctionParameter> auction;

    public Parameter(String name) {
        this.name = name;
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

    public List<AuctionParameter> getAuction() {
        return auction;
    }

    public void setAuction(List<AuctionParameter> auction) {
        this.auction = auction;
    }
}

