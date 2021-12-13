package generica.T_Proveedores.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proveedores_bogota")
public class Bog_Mod_Proveedores {

	@Id
	private String id;
	private String ciudad_proveedor;
	private String direecion_proveedor;
	private String nombre_proveedor;
	private long telefono_proveedor;
	
	public Bog_Mod_Proveedores() {}

	public Bog_Mod_Proveedores(String id, String ciudad_proveedor, String direecion_proveedor, String nombre_proveedor,
			long telefono_proveedor) {
		super();
		this.id = id;
		this.ciudad_proveedor = ciudad_proveedor;
		this.direecion_proveedor = direecion_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.telefono_proveedor = telefono_proveedor;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}
	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}
	public String getDireecion_proveedor() {
		return direecion_proveedor;
	}
	public void setDireecion_proveedor(String direecion_proveedor) {
		this.direecion_proveedor = direecion_proveedor;
	}
	public String getNombre_proveedor() {
		return nombre_proveedor;
	}
	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}
	public long getTelefono_proveedor() {
		return telefono_proveedor;
	}
	public void setTelefono_proveedor(long telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	@Override
	public String toString() {
		return "Bog_Mod_Proveedores [id=" + id + ", ciudad_proveedor=" + ciudad_proveedor + ", direecion_proveedor="
				+ direecion_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", telefono_proveedor="
				+ telefono_proveedor + "]";
	}
	
}