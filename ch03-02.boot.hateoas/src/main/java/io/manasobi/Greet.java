package io.manasobi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greet extends ResourceSupport {

    private String message;
}
