package generica.T_Consolidacion.Model;

public class Bog_Mod_Consolidacion {

	private String id;
	private String ciudad;
	private Integer total_ventas;
	
	public Bog_Mod_Consolidacion() {}

	public Bog_Mod_Consolidacion(String id, String ciudad, Integer total_ventas) {
		super();
		this.id = id;
		this.ciudad = ciudad;
		this.total_ventas = total_ventas;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Integer getTotal_ventas() {
		return total_ventas;
	}
	public void setTotal_ventas(Integer total_ventas) {
		this.total_ventas = total_ventas;
	}

	@Override
	public String toString() {
		return "Bog_Mod_Consolidacion [id=" + id + ", ciudad=" + ciudad + ", total_ventas=" + total_ventas + "]";
	}

}