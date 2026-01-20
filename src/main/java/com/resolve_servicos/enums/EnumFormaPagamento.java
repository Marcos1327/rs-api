package com.resolve_servicos.enums;

public enum EnumFormaPagamento {
    DINHEIRO("Dinheiro"),
    PIX("Pix"),
    CARTAO_CREDITO("Cartão de Crédito"),
    TRANSFERENCIA("Transferência Bancária");

    private final String descricao;

    EnumFormaPagamento(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
