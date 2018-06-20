package com.ceac.campus.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.ceac.campus.objects.Producto;

//Crea un método o función por cada opción del menú (introducirProds(), visualizaProds(), guardaProds(), leeProds()).
public interface OperacionesProductosService {

	void introducirProds(Producto product);
	
	List<Producto> visualizaProds() throws NumberFormatException, URISyntaxException, IOException;
	
	void guardaProds(Producto product) throws URISyntaxException, IOException;
	
	List<Producto> leeProds() throws NumberFormatException, URISyntaxException, IOException;
	
}
