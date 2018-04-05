package jogo;

public class Resultado implements IResultado, Comparable<Resultado> {

	private Participante participante;
	private double metrica;
	
	public Resultado(Participante participante, double metrica) throws Exception {
		this.participante = participante;
		if(metrica >= 0)
			this.metrica = metrica;
		else
			throw new Exception("A métrica deve ser positiva");
	}

	public Participante getParticipante() {
		return participante;
	}

	public double getMetrica() {
		return metrica;
	}


	@Override
	public int compareTo(Resultado o) {
		double score = o.metrica;
		return (int)(metrica - score);
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resultado res = (Resultado) obj;

        return res.getParticipante().getNome().equals(participante.getNome()) && res.metrica == metrica;

    }
}
