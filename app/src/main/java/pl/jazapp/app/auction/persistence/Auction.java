package pl.jazapp.app.auction.persistence;

import org.hibernate.annotations.Cascade;
import pl.jazapp.app.auctionParameter.AuctionParameter;
import pl.jazapp.app.category.persistence.Category;
import pl.jazapp.app.photo.persistence.Photo;
import pl.jazapp.app.user.UserEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity user;

    @Column(name = "version")
    private Long version;

    @OneToMany(mappedBy = "auction", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Photo> photo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auction", cascade = CascadeType.ALL)
    public Set<AuctionParameter> auctionParameters;


    public Auction(){}

    public Auction(
            String title,
            String description,
            Float price,
            Category category,
            UserEntity user,
            Long version,
            List<Photo> photo,
            Set<AuctionParameter> auctionParameters
    ) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.user = user;
        this.version = version;
        this.photo = photo;
        this.auctionParameters = auctionParameters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public Set<AuctionParameter> getAuctionParameters() {
        return auctionParameters;
    }

    public void setAuctionParameters(Set<AuctionParameter> auctionParameters) {
        this.auctionParameters = auctionParameters;
    }
}
