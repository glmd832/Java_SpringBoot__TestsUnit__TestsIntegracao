package br.com.java_springboot_testsunit_testsintergracao.dtos;

import br.com.java_springboot_testsunit_testsintergracao.entities.Category;
import br.com.java_springboot_testsunit_testsintergracao.entities.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotBlank(message = "Campo obrigatório.")
    @Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 cracteres.")
    private String title;
    @NotBlank(message = "Campo obrigatório.")
    private String description;
    @Positive(message = "O preço não pode ser negativo.")
    private Double price;
    private String image;
    private List<CategoryDto> categories = new ArrayList<>();

    public ProductDto() {
    }

    public ProductDto(Integer id, String title, String description, Double price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public ProductDto(Product entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        price = entity.getPrice();
        image = entity.getImage();
    }

    public ProductDto(Product entity, Set<Category> categories) { // 0 1 2 cat
        this(entity);
        categories.forEach(cat -> this.categories.add(new CategoryDto(cat)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }
}
