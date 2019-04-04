package modelo;

import java.io.Serializable;

public class Equipo implements Serializable,Comparable<Equipo>{
	// completar la clase con Constructor, getter/setters.
	private int id;
	private String nombreCorto;
	private String nombre;
	private int pj;
	private int puntos;
	private int pg;
	private int pe;
	private int pp;
	private int gf;
	private int gc;
	
	public Equipo(int id, String nombreCorto, String nombre, int pj, int puntos, int pg, int pe, int pp, int gf,
			int gc) {
		super();
		this.id = id;
		this.nombreCorto = nombreCorto;
		this.nombre = nombre;
		this.pj = pj;
		this.puntos = puntos;
		this.pg = pg;
		this.pe = pe;
		this.pp = pp;
		this.gf = gf;
		this.gc = gc;
	}
	
	public Equipo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPj() {
		return pj;
	}
	public void setPj(int pj) {
		this.pj = pj;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public int getPe() {
		return pe;
	}
	public void setPe(int pe) {
		this.pe = pe;
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	public int getGf() {
		return gf;
	}
	public void setGf(int gf) {
		this.gf = gf;
	}
	public int getGc() {
		return gc;
	}
	public void setGc(int gc) {
		this.gc = gc;
	}

	@Override
	public int compareTo(Equipo eq) {
		if (this.getNombre().compareToIgnoreCase(eq.getNombre()) > 0)
			return 1;
		else if (this.getNombre().compareToIgnoreCase(eq.getNombre()) < 0)
			return -1;
		else
			return 0;
	}
	
}
