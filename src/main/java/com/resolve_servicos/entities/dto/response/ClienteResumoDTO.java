package com.resolve_servicos.entities.dto.response;

public class ClienteResumoDTO {

    private long clienteId;
    private String nome;
    private String telefone;
    private String endereco;
    private Integer totalServico;

    public ClienteResumoDTO() {
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTotalServico() {
        return totalServico;
    }

    public void setTotalServico(Integer totalServico) {
        this.totalServico = totalServico;
    }
}
