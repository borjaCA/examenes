package entidades;


public class Palmares <T extends Metal, S extends Participante> {



// Campos de la clase Palmares
private long id;
private T medalla;
private S participante;
private Prueba p;
private String ob;



// CPD
public Palmares() {



}



// Constructor oon todos los parametros
public Palmares(long id, T medalla, S participante, Prueba p, String ob) {
this.id = id;
this.medalla = medalla;
this.participante = participante;
this.p = p;
this.ob = ob;
}



public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



public T getMedalla() {
	return medalla;
}



public void setMedalla(T medalla) {
	this.medalla = medalla;
}



public S getParticipante() {
	return participante;
}



public void setParticipante(S participante) {
	this.participante = participante;
}



public Prueba getP() {
	return p;
}



public void setP(Prueba p) {
	this.p = p;
}



public String getOb() {
	return ob;
}



public void setOb(String ob) {
	this.ob = ob;
}



@Override
public String toString() {
	String ret ="";
	ret = "id " + id + "medalla" + medalla.toString() + "prueba" + p.getNombre() + "fecha"+ p.getFecha() + "dorsal" + participante.getDorsal() + " calle" + participante.getCalle() ;
	
	return ret;
}
	

	


}