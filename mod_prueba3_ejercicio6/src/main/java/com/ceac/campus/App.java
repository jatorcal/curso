package com.ceac.campus;

import java.io.IOException;
import java.net.URISyntaxException;

import com.ceac.campus.objects.Producto;
import com.ceac.campus.services.OperacionesProductosService;
import com.ceac.campus.services.OperacionesProductosServiceImpl;
import com.ceac.campus.utilities.FileUtils;

// Crea un método o función que visualice el menú.
public class App {

	public void mostrarMenu() {

	}

	public static void main(String[] args) throws URISyntaxException, IOException {
		FileUtils fileUtils = new FileUtils();
		fileUtils.escrituraDeFicheroInicial();
				
		escribir();
	}
	
	public static void leer() throws NumberFormatException, URISyntaxException, IOException{
		OperacionesProductosService operacionesProductosService = new OperacionesProductosServiceImpl();
		operacionesProductosService.leeProds();
	}
	
	public static void escribir() throws URISyntaxException, IOException {
		Producto nuevoProducto = new Producto();
		nuevoProducto.setCode(5);
		nuevoProducto.setDescripcion("Patatas");
		nuevoProducto.setPeso(Float.parseFloat("12.00"));
		
		OperacionesProductosService operacionesProductosService = new OperacionesProductosServiceImpl();
		operacionesProductosService.guardaProds(nuevoProducto);
	}

}
