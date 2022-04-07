package br.org.fatec.efol.model.fol;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum StatusFol {

    IN_EFFECT,

    CANCELLED,

    INCORPORATED;

    public static List<String> allValues() {
        return Stream.of(StatusFol.values()).map(StatusFol::name).collect(Collectors.toList());
    }

    public static StatusFol fromString(String status) {
        if (StringUtils.isNotEmpty(status) && allValues().contains(status)) {
            return StatusFol.valueOf(status);
        }

        return null;
    }
}
