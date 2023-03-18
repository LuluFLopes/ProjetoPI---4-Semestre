package br.com.senacsp.ProjetoPI.enumeracoes.produto;

public enum Avaliacao {
    PESSIMO(1.0),
    MUITO_RUIM(1.5),
    RUIM(2.0),
    MEDIO(2.5),
    BOM(3.0),
    MUITO_BOM(3.5),
    OTIMO(4.0),
    EXCELENTE(4.5),
    PERFEITO(5.0);

    private Double nota;

    Avaliacao(Double nota) {
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }
}
