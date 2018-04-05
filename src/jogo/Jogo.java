package jogo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo implements IJogo {

	private String descricao;
	private List<IResultado> resultados;
	private boolean fechado;
	
	public Jogo(String descricao) {
		this.descricao = descricao;
		this.resultados = new ArrayList<IResultado>();
	}
	
	public void anota(IResultado resultado) throws Exception {
		
		if(fechado)
		{
			throw new Exception("Um jogo fechado n�o pode ter novos participantes.");
		}
		
		if(resultados.isEmpty() || !temParticipante(resultado.getParticipante())) {
            resultados.add(resultado);
        }
	}
	
	public boolean temParticipante(Participante p)
	{
		for(IResultado r : resultados)
		{
			if(r.getParticipante().equals(p))
			{
				return true;
			}
		}
		return false;
	}

	private int ultimoResultadoVisto() {
		return resultados.size()-1;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<IResultado> getResultados() {
		return Collections.unmodifiableList(resultados);
	}

	public IResultado getUltimoResultadoVisto()
	{
		return resultados.get(ultimoResultadoVisto());
	}

	public void encerrar() throws Exception
	{
		if(getResultados().size() < 2)
			throw new Exception("Jogo nao pode ter menos de 2 jogadores!");

		fechado = true;
	}

	@Override
	public boolean getEncerrado() {
		return fechado;
	}
	
}
