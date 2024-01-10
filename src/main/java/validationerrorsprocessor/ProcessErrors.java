package validationerrorsprocessor;

import org.aelion.product.products.dto.ProductInvalidDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ProcessErrors {
    private BindingResult errors;
    public ProcessErrors(BindingResult errors) {
        this.errors = errors;
    }

    public ResponseEntity<?> processErrors() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ProductInvalidDto("Product sent does not respect constraints"));
    }
}
