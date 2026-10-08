package application.domain.models;

public class ProductModel {
    private Long id;
    private String name;
    private String sellerId;
    private String status;

    public ProductModel() {
    }

    public ProductModel(Long id, String name, String sellerId, String status) {
        this.id = id;
        this.name = name;
        this.sellerId = sellerId;
        this.status = status;
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

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
