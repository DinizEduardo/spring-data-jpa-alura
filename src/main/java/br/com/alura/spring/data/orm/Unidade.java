package br.com.alura.spring.data.orm;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidades")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    private String endereco;

    @ManyToMany(mappedBy = "unidades", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
