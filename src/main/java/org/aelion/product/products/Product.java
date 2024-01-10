package org.aelion.product.products;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     * @var Product id
     */
    @NotNull
    @NotBlank
    @NotEmpty
    private String id;
    /**
     * @var Product name
     */
    @NotNull
    @NotBlank
    @NotEmpty
    private String label;

    /**
     * @var Product stock
     */
    @NotNull
    @Min(0)
    private int stock;
}
