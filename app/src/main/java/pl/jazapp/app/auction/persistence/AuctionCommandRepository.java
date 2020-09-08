package pl.jazapp.app.auction.persistence;

import org.hibernate.Session;
import pl.jazapp.app.auctionParameter.AuctionParameter;
import pl.jazapp.app.category.persistence.Category;
import pl.jazapp.app.parameter.persistence.Parameter;
import pl.jazapp.app.photo.persistence.Photo;
import pl.jazapp.app.user.User;
import pl.jazapp.app.user.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class AuctionCommandRepository {

    @PersistenceContext()
    private EntityManager em;

    @Transactional
    public void create(
            String title,
            String description,
            Float price,
            Category category,
            UserEntity user,
            Long version,
            List<Photo> photo,
            Set<AuctionParameter> auctionParameters
    ){
        try {
            Auction auction = new Auction();
            for (Photo photoItem : photo) {
                photoItem.setAuction(auction);
            }
            for (AuctionParameter auctionParameter: auctionParameters) {
                auctionParameter.setAuction(auction);
            }
            auction.setTitle(title);
            auction.setDescription(description);
            auction.setPrice(price);
            auction.setCategory(category);
            auction.setUser(user);
            auction.setVersion(version);
            auction.setPhoto(photo);
            auction.setAuctionParameters(auctionParameters);
            em.persist(auction);
            em.flush();
        }
        catch (RuntimeException e) {
            throw e; // or display error message
        }
    }

    @Transactional
    public void update(
            Auction auction,
            String title,
            String description,
            Float price,
            Category category,
            List<Photo> photo,
            List<AuctionParameter> auctionParameters
    ) {
        var merge = em.merge(auction);
        merge.setTitle(title);
        merge.setDescription(description);
        merge.setPrice(price);
        merge.setCategory(category);
        merge.setVersion(auction.getVersion() + 1);
        em.getTransaction().begin();
        em.persist(merge);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
