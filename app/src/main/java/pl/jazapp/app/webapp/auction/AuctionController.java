package pl.jazapp.app.webapp.auction;

import pl.jazapp.app.UserContext;
import pl.jazapp.app.auction.AuctionService;
import pl.jazapp.app.auction.persistence.Auction;
import pl.jazapp.app.auctionParameter.AuctionParameter;
import pl.jazapp.app.category.CategoryService;
import pl.jazapp.app.category.persistence.Category;
import pl.jazapp.app.parameter.persistence.Parameter;
import pl.jazapp.app.photo.PhotoService;
import pl.jazapp.app.photo.persistence.Photo;
import pl.jazapp.app.user.UserEntity;
import pl.jazapp.app.user.UserService;
import pl.jazapp.app.webapp.categories.CategoryRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.*;

@Named
@RequestScoped
public class AuctionController {

    @Inject
    AuctionService service;

    @Inject
    UserContext userContext;

    @Inject
    UserService userService;

    @Inject
    CategoryService categoryService;

    @Inject
    private CategoryRequest categoryRequest;

    public String create(AuctionRequest request) {
        String title = request.getTitle();
        String description = request.getDescription();
        Float price = request.getPrice();

        Photo photo1 = new Photo(request.getPhoto1());
        Photo photo2 = new Photo(request.getPhoto2());
        Photo photo3 = new Photo(request.getPhoto3());
        List<Photo> photo = new ArrayList<>();
        photo.add(photo1);
        photo.add(photo2);
        photo.add(photo3);

        AuctionParameter parameter1 = new AuctionParameter(request.getParam1Value(), new Parameter(request.getParam1Name()));
        AuctionParameter parameter2 = new AuctionParameter(request.getParam2Value(), new Parameter(request.getParam2Name()));
        AuctionParameter parameter3 = new AuctionParameter(request.getParam3Value(), new Parameter(request.getParam3Name()));

        Set<AuctionParameter> auctionParameters = new HashSet<>();
        auctionParameters.add(parameter1);
        auctionParameters.add(parameter2);
        auctionParameters.add(parameter3);

        Optional<Category> category = categoryService.getById(request.getCategoryId());

        Long userId = userContext.getUserId();
        Optional<UserEntity> user = userService.getById(userId);
        if (category.isPresent() && user.isPresent()) {
            service.create(title, description, price, category.get(),user.get(), photo,auctionParameters);
        }

        return "/auctions/mine.xhtml?faces-redirect=true";
    }

    public String OpenEditingSite(AuctionRequest request) {
        var id = request.getId();
        Optional<Auction> auction = service.getById(Long.parseLong(String.valueOf(id)));
        if (auction.isPresent()) {
            return "/auctions/edit.xhtml?auctionId=" + id + "&faces-redirect=true&includeViewParams=true";
        }
        return  "/auctions/mine.xhtml?faces-redirect=true";
    }

    public String update(AuctionRequest request) {
        String title = request.getTitle();
        String description = request.getDescription();
        Float price = request.getPrice();

        Photo photo1 = new Photo(request.getPhoto1());
        Photo photo2 = new Photo(request.getPhoto2());
        Photo photo3 = new Photo(request.getPhoto3());
        List<Photo> photo = new ArrayList<>();
        photo.add(photo1);
        photo.add(photo2);
        photo.add(photo3);

        AuctionParameter parameter1 = new AuctionParameter(request.getParam1Value(), new Parameter(request.getParam1Name()));
        AuctionParameter parameter2 = new AuctionParameter(request.getParam2Value(), new Parameter(request.getParam2Name()));
        AuctionParameter parameter3 = new AuctionParameter(request.getParam3Value(), new Parameter(request.getParam3Name()));

        List<AuctionParameter> auctionParameters = new ArrayList<>();
        auctionParameters.add(parameter1);
        auctionParameters.add(parameter2);
        auctionParameters.add(parameter3);

        Optional<Auction> auction = service.getById(request.getId());
        Optional<Category> category = categoryService.getById(request.getCategoryId());

        if (auction.isPresent() && category.isPresent()) {
            service.update(auction.get() , title, description, price, category.get(),photo,auctionParameters);
        }
        return "/auctions/mine.xhtml?faces-redirect=true";
    }

    public List<Auction> getAll() {
        return service.getAll();
    }

    public AuctionService getService() {
        return service;
    }

    public void setService(AuctionService service) {
        this.service = service;
    }

    public UserContext getUserContext() {
        return userContext;
    }

    public void setUserContext(UserContext userContext) {
        this.userContext = userContext;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public CategoryRequest getCategoryRequest() {
        return categoryRequest;
    }

    public void setCategoryRequest(CategoryRequest categoryRequest) {
        this.categoryRequest = categoryRequest;
    }

    public List<Auction> getUserAuctions() {
        Long userId = userContext.getUserId();
        Optional<UserEntity> user = userService.getById(userId);
        if (user.isPresent()) {
            return service.getUserAuctions(user.get());
        }
        return new ArrayList<>();
    }

    public Auction getGetById(AuctionRequest auctionRequest) {
        var id = auctionRequest.getId();
        var auction = this.service.getById(Long.parseLong(String.valueOf(id)));
        return auction.orElseGet(Auction::new);
    }
}
