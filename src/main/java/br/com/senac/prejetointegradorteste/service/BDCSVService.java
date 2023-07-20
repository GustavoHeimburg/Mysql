package br.com.senac.prejetointegradorteste.service;

import br.com.senac.prejetointegradorteste.Cadastro;
import br.com.senac.prejetointegradorteste.repository.Calculos;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BDCSVService implements Calculos {

    private static final Path ARQUIVO_SAIDA = Paths.get("./dados.csv");
    private List<Cadastro> cadastros;
    private int ultimoCodigo;
    @Override
    public void salvarCalculo(Cadastro cadastro) {
    cadastro.setCodigo(ultimoCodigo() + 1);
    }

    @Override
    public void atualizarCalculo(Cadastro cadastro) {



    }

    @Override
    public void buscarUmCalculo(Cadastro cadastro) {

    }

    @Override
    public List<Calculos> BuscarTodosOsCalculos() {
        return null;
    }
}
