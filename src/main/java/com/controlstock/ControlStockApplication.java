package com.controlstock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controlstock.model.Deposito;
import com.controlstock.model.Producto;
import com.controlstock.model.Ubicacion;
import com.controlstock.repositories.DepositoRepository;
import com.controlstock.repositories.ProductoRepository;
import com.controlstock.repositories.UbicacionRepository;

@SpringBootApplication
public class ControlStockApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ControlStockApplication.class, args);
	}
	
	@Autowired
	private DepositoRepository depositoRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Carga Inicial
		//Depositos
		Deposito depo1 = new Deposito();
		depo1.setCodDeposito("AR01");
		depositoRepository.save(depo1);
		
		Deposito depo2 = new Deposito();
		depo2.setCodDeposito("BR05");
		depositoRepository.save(depo2);
		
		Deposito depo3 = new Deposito();
		depo3.setCodDeposito("AR02");
		depositoRepository.save(depo3);
		
		//Productos
		Producto prod1 = new Producto();
		prod1.setCodProducto("MLA813727183");
		productoRepository.save(prod1);
		
		Producto prod2 = new Producto();
		prod2.setCodProducto("MLA222222222");
		productoRepository.save(prod2);
		
		Producto prod3 = new Producto();
		prod3.setCodProducto("MLA333333333");
		productoRepository.save(prod3);
		
		//Ubicaciones
		Ubicacion ubi1 = new Ubicacion();
		ubi1.setCodUbicacion("LM-00-00-IZ");
		ubicacionRepository.save(ubi1);
		
		Ubicacion ubi2 = new Ubicacion();
		ubi2.setCodUbicacion("AL-04-02-DE");
		ubicacionRepository.save(ubi2);
		
		Ubicacion ubi3 = new Ubicacion();
		ubi3.setCodUbicacion("AL-00-00-DE");
		ubicacionRepository.save(ubi3);
		
	}
}
