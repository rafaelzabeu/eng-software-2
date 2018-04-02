import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {

	private String descricao;
	private List<Resultado> resultados;
	private boolean fechado;
	
	public Jogo(String descricao) {
		this.descricao = descricao;
		this.resultados = new ArrayList<Resultado>();
	}
	
	public void anota(Resultado resultado) {
		if(resultados.isEmpty() || 
                !resultados.get(ultimoResultadoVisto()).getParticipante().equals(resultado.getParticipante())) {
            resultados.add(resultado);
        }
		
		
	}

	private int ultimoResultadoVisto() {
		return resultados.size()-1;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Resultado> getResultados() {
		return Collections.unmodifiableList(resultados);
	}

	public Resultado getUltimoResultadoVisto()
	{
		return resultados.get(ultimoResultadoVisto());
	}

	public void encerrar() throws Exception
	{
		if(getResultados().size() < 2)
			throw new Exception();
	}
	
}
