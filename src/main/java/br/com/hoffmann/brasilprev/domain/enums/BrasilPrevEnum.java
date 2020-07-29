package br.com.hoffmann.brasilprev.domain.enums;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public enum BrasilPrevEnum {

    ANALISE(1, "Analise"),
    APROVADO(2, "Aprovado"),
    REPROVADO(3,"Reprovado");

    private static final Map<Integer, BrasilPrevEnum> STATUS_PEDIDO = new HashMap<>(values().length);
    static {
        STATUS_PEDIDO.putAll(stream(values()).collect(toMap(BrasilPrevEnum::code, identity())));
    }

    private final Integer code;
    private final String description;

    BrasilPrevEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer code() {
        return this.code;
    }

    public Long getCode() {
        return code.longValue();
    }

    public String description() {
        return this.description;
    }

    public static BrasilPrevEnum of(Long enumCode) {

        if (enumCode.equals(ANALISE.getCode())) {
            return ANALISE;
        } else if (enumCode.equals(APROVADO.getCode())) {
            return APROVADO;
        } else if (enumCode.equals(REPROVADO.getCode())) {
            return REPROVADO;
        } else
            return null;
    }
}