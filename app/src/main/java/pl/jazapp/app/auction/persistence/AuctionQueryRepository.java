package pl.jazapp.app.auction.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuctionQueryRepository {
    @PersistenceContext()
    private EntityManager em;

    @Transactional
    public List<Auction> getAll(){
        return em.createQuery("from Auction", Auction.class).getResultList();
    }

    @Transactional
    public Optional<Auction> getById(Long id){
        return em.createQuery("from Auction WHERE id = :id", Auction.class).setParameter("id", id).getResultList().stream().findFirst();
    }

    @Transactional
    public Optional<Auction> getByTitle(String title){
        return em.createQuery("from Auction WHERE title =:title", Auction.class).setParameter("title", title).getResultList().stream().findFirst();
    }

    public List<Auction> getByOwnerId(Long id) {
        return em.createQuery("from Auction WHERE owner_id = :id", Auction.class).setParameter("id", id).getResultList();
    }
}
