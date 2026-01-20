package com.resolve_servicos.entities.dto.request;

public class TipoServicoRequestDTO {

    private String nome;
    private String descricao;

    public TipoServicoRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
