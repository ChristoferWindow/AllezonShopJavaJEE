package pl.jazapp.app.webapp.auction;

import pl.jazapp.app.auctionParameter.AuctionParameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;

@Named
@RequestScoped
public class AuctionRequest {
    private Long id;

    private String title;

    private String description;

    private Float price;

    private Long categoryId;

    private Long ownerId;

    private Long version;

    private List<String> photoList;

    private HashMap<String, String> parameterList;

    private String param1Name;

    private String param2Name;

    private String param3Name;

    private String param1Value;

    private String param2Value;

    private String param3Value;

    private String photo1;

    private String photo2;

    private String photo3;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList;
    }

    public HashMap<String, String> getParameterList() {
        return parameterList;
    }

    public void setParameterList(HashMap<String, String> parameterList) {
        this.parameterList = parameterList;
    }

    public String getParam1Name() { return param1Name; }

    public void setParam1Name(String param1Name) { this.param1Name = param1Name; }

    public String getParam2Name() { return param2Name; }

    public void setParam2Name(String param2Name) { this.param2Name = param2Name; }

    public String getParam3Name() {
        return param3Name;
    }

    public void setParam3Name(String param3Name) {
        this.param3Name = param3Name;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getParam1Value() {
        return param1Value;
    }

    public void setParam1Value(String param1Value) {
        this.param1Value = param1Value;
    }

    public String getParam2Value() {
        return param2Value;
    }

    public void setParam2Value(String param2Value) {
        this.param2Value = param2Value;
    }

    public String getParam3Value() {
        return param3Value;
    }

    public void setParam3Value(String param3Value) {
        this.param3Value = param3Value;
    }
}
