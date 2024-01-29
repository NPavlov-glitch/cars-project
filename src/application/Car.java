package application;

public class Car {
	private int id;
    private String model;
    private int year;
    private String carClass; // luxury, family, city
    private String category; // sedan, SUV, wagon
    private String features;
    private String photos;
    private boolean smoker; // true if smoker, false if non-smoker

    // Constructors
    public Car(String model, int year, String carClass, String category, String features, String photos, boolean smoker) {
    	this.model = model;
        this.year = year;
        this.carClass = carClass;
        this.category = category;
        this.features = features;
        this.photos = photos;
        this.smoker = smoker;
    }

    // Getters and Setters

    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }
}
