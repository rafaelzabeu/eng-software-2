package jogo;

import java.util.List;

public interface IJogo {
	public void anota(IResultado resultado);
	public List<IResultado> getResultados();
	public IResultado getUltimoResultadoVisto();
	public void encerrar() throws Exception;
}
