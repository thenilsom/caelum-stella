package br.com.caelum.stella.nfe.builder.cofins.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.cofins.enums.SituacaoTributaria;

import static net.vidageek.mirror.Mirror.on;

public class COFINSBuilderDelegate<T> {

    private final T instance;

    public COFINSBuilderDelegate(final Class<T> clazz) {
        instance = on(clazz).invoke().constructor().withoutArgs();
    }

    public COFINSBuilderDelegate(final Class<T> clazz, final SituacaoTributaria situacaoTributaria) {
        this(clazz);
        on(instance).set().field("codigoSituacaoTributaria").withValue(situacaoTributaria.getCodigo());
    }

    public void withValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        on(instance).set().field("valorBaseCalculo").withValue(valorBaseCalculo.toString());
    }

    public void withAliquotaEmPercentual(final BigDecimal aliquotaEmPercentual) {
        on(instance).set().field("aliquotaEmPercentual").withValue(aliquotaEmPercentual.toString());
    }

    public void withValor(final BigDecimal valor) {
        on(instance).set().field("valor").withValue(valor.toString());
    }

    public void withQuantidadeVendida(final Integer quantidadeVendida) {
        on(instance).set().field("quantidadeVendida").withValue(quantidadeVendida.toString());
    }

    public void withAliquotaEmReais(final BigDecimal aliquotaEmReais) {
        on(instance).set().field("aliquota").withValue(aliquotaEmReais.toString());
    }

    public T getReference() {
        return instance;
    }

}