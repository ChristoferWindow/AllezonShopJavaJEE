package pl.jazapp.app.auction;

import pl.jazapp.app.auction.persistence.Auction;
import pl.jazapp.app.auction.persistence.AuctionCommandRepository;
import pl.jazapp.app.auction.persistence.AuctionQueryRepository;
import pl.jazapp.app.auctionParameter.AuctionParameter;
import pl.jazapp.app.category.persistence.Category;
import pl.jazapp.app.department.Department;
import pl.jazapp.app.parameter.persistence.Parameter;
import pl.jazapp.app.photo.persistence.Photo;
import pl.jazapp.app.user.User;
import pl.jazapp.app.user.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class AuctionService {

    @Inject
    AuctionQueryRepository queryRepository;
    @Inject
    AuctionCommandRepository commandRepository;

    public List<Auction> getAll(){
        return queryRepository.getAll();
    }
    public Optional<Auction> getById(Long id) {
        return queryRepository.getById(id);
    }
    public Optional<Auction> getByName(String name) {
        return queryRepository.getByTitle(name);
    }
    public void update(
            Auction auction,
            String title,
            String description,
            Float price,
            Category category,
            List<Photo> photo,
            List<AuctionParameter> auctionParameters
    ) {
        commandRepository.update(auction,title,description,price,category,photo,auctionParameters);
    }
    public void create(
            String title,
            String description,
            Float price,
            Category category,
            UserEntity user,
            List<Photo> photo,
            Set<AuctionParameter> auctionParameters
    ) {
        commandRepository.create(title,description,price,category,user,1L,photo, auctionParameters);
    }
}
