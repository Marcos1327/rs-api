package com.resolve_servicos.entities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_tipos_servicos")
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoServicoId;

    private String nomeTipoServico;
    private String descricao;
    private Boolean ativo = true;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAtualizacao;
    @OneToMany(mappedBy = "tipoServico")
    private List<Servico>  servicos = new ArrayList<>();

    public TipoServico() {
    }

    public Long getTipoServicoId() {
        return tipoServicoId;
    }

    public String getNomeTipoServico() {
        return nomeTipoServico;
    }

    public void setNomeTipoServico(String nomeTipoServico) {
        this.nomeTipoServico = nomeTipoServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
