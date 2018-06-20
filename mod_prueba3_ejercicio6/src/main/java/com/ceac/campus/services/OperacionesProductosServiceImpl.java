package com.ceac.campus.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.ceac.campus.objects.Producto;
import com.ceac.campus.utilities.FileUtils;

public class OperacionesProductosServiceImpl implements OperacionesProductosService{

	public void introducirProds(Producto product) {
		
	}

	public List<Producto> visualizaProds() throws NumberFormatException, URISyntaxException, IOException {
		FileUtils fileUtils =  new FileUtils();
		
		return fileUtils.leerFichero();
	}

	public void guardaProds(Producto producto) throws URISyntaxException, IOException {
		FileUtils fileUtils =  new FileUtils();
		
		fileUtils.escribirFichero(producto);
		
	}

	public List<Producto> leeProds() throws NumberFormatException, URISyntaxException, IOException {
		FileUtils fileUtils = new FileUtils();
		List<Producto> listProductos = fileUtils.leerFichero();
		return listProductos;
	}

}
