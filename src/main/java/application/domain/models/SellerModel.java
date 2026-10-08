package application.domain.models;

public class SellerModel {
    private Long id;
    private String email;
    private String fullName;
    private String status;

    public SellerModel() {
    }

    public SellerModel(Long id, String email, String fullName, String status) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
