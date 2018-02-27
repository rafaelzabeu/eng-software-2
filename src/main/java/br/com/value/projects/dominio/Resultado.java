package br.com.value.projects.dominio;

public class Resultado implements Comparable<Resultado> {

	private Participante participante;
	private double metrica;
	
	public Resultado(Participante participante, double metrica) {
		this.participante = participante;
		this.metrica = metrica;
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
