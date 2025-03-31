package interfaces;

import model.No;

public interface INo {
    No getProx();

    void setProx(No primeiro);

    Integer getConteudo();

    void setConteudo(Integer conteudo);

    No getAnt();

    void setAnt(No ant);
}
