package com.ceac.campus.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.ceac.campus.objects.Producto;

public class FileUtils {

	public static final String NOMBRE_FICHERO_PRODUCTOS = "productList.txt";

	/**
	 * Devuelve una lista de productos a partir del fichero productList.txt
	 * 
	 * @return List<Producto>
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public List<Producto> leerFichero() throws URISyntaxException, NumberFormatException, IOException {

		String cadena = "";
		List<Producto> listProduct = new ArrayList<>();
		FileReader f = new FileReader(getProductListFile());
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(cadena, "|");
			int column = 1;
			Producto producto = new Producto();
			while (tokenizer.hasMoreTokens()) {
				if (column == 1) {
					producto.setCode(Integer.parseInt(tokenizer.nextToken()));
				} else if (column == 2) {
					producto.setDescripcion(tokenizer.nextToken());
				} else if (column == 3) {
					producto.setPeso(Float.valueOf(tokenizer.nextToken()));
				}

				column++;
			}
			listProduct.add(producto);

		}
		b.close();

		return listProduct;
	}

	/**
	 * Escribe en el fichero el objeto Producto
	 * 
	 * @param producto
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void escribirFichero(Producto producto) throws URISyntaxException, IOException {
		File ficheroProductos = new File(getProductListFile());
		escribirProductoEnFichero(ficheroProductos, producto);
	}

	/**
	 * Crea el fichero inicial en el caso de no existir
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void escrituraDeFicheroInicial() throws URISyntaxException, IOException {

		File ficheroProductos = new File(getProductListFile());
		if (!ficheroProductos.exists()) {
			escribirProductoEnFichero(ficheroProductos, null);
		}

	}

	private String getProductListFile() throws URISyntaxException {

		return this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()
				+ File.pathSeparator + NOMBRE_FICHERO_PRODUCTOS;
	}

	private void escribirProductoEnFichero(File fichero, Producto producto) throws IOException {

		FileWriter fileWriter = new FileWriter(fichero, true);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(fileWriter);

			if (producto != null) {
				bw.write(producto.getCode() + "|" + producto.getDescripcion() + "|" + producto.getPeso() + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Cierra instancias de FileWriter y BufferedWriter
				if (bw != null)
					bw.close();
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
