package br.com.senac.prejetointegradorteste.repository;

import br.com.senac.prejetointegradorteste.Cadastro;

import java.util.List;

public interface Calculos {
    public void salvarCalculo(Cadastro cadastro);

    public void atualizarCalculo(Cadastro cadastro);

    public void buscarUmCalculo(Cadastro cadastro);
    public List<Calculos> BuscarTodosOsCalculos();
}