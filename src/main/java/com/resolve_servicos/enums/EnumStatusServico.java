package com.resolve_servicos.enums;

public enum EnumStatusServico {
    SOLICITADO("Solicitado"),
    ORCAMENTO("Orçamento"),
    AGENDADO("Agendado"),
    EM_EXECUCAO("Em Execução"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");

    private final String descricao;

    EnumStatusServico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
