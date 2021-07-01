package com.broker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// anotations needed so that the object can be serialized and deserialized as needed.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symbol {
    private String value;
}
