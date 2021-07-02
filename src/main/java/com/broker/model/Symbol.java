package com.broker.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Symbol", description = "Abbreviation to uniquely identified publicly traded stock")
// annotations needed so that the object can be serialized and deserialized as needed.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symbol {
    @Schema(description = "symbol value", minLength = 1, maxLength = 5)
    private String value;
}
