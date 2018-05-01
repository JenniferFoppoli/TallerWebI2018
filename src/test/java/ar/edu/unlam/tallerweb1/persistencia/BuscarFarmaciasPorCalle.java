package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Comuna;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class BuscarFarmaciasPorCalle extends SpringTest{
	@Test
    @Transactional @Rollback(true)
    public void buscarFarmacia(){
		
		Comuna comuna1 = new Comuna();
		comuna1.setNombre("comuna1");
		getSession().save(comuna1);
		
		Comuna comuna2 = new Comuna();
		comuna2.setNombre("comuna2");
		getSession().save(comuna2);
		
		Comuna comuna3 = new Comuna();
		comuna3.setNombre("comuna3");
		getSession().save(comuna3);
		
		
		Barrio barrio1 = new Barrio();
		barrio1.setNombre("barrio1");
		barrio1.setComuna(comuna1);
		getSession().save(barrio1);
    	
		Barrio barrio2 = new Barrio();
		barrio2.setNombre("barrio2");
		barrio2.setComuna(comuna2);
		getSession().save(barrio2);
		
		Barrio barrio4 = new Barrio();
		barrio4.setNombre("barrio4");
		barrio4.setComuna(comuna3);
		getSession().save(barrio4);
		
		Barrio barrio5 = new Barrio();
		barrio5.setNombre("barrio5");
		barrio5.setComuna(comuna3);
		getSession().save(barrio5);
		
		Barrio barrio6 = new Barrio();
		barrio6.setNombre("barrio6");
		barrio6.setComuna(comuna3);
		getSession().save(barrio6);
		
		Direccion direccion1 = new Direccion();
		direccion1.setCalle("Calle1");
		direccion1.setNumero("1");
		direccion1.setBarrio(barrio1);
		getSession().save(direccion1);
		
		Direccion direccion2 = new Direccion();
		direccion2.setCalle("Calle2");
		direccion2.setNumero("2");
		direccion2.setBarrio(barrio1);
		getSession().save(direccion2);
		
		Direccion direccion3 = new Direccion();
		direccion3.setCalle("Calle2");
		direccion3.setNumero("3");
		direccion3.setBarrio(barrio4);
		getSession().save(direccion3);
		
		Direccion direccion4 = new Direccion();
		direccion4.setCalle("Calle4");
		direccion4.setNumero("4");
		direccion4.setBarrio(barrio2);
		getSession().save(direccion4);
		
		
		Farmacia farmacia1 = new Farmacia();
    	farmacia1.setNombre("farmacia1");
    	farmacia1.setTelefono("2222");
    	farmacia1.setDiaDeTurno("martes");
    	farmacia1.setDireccion(direccion1);
    	getSession().save(farmacia1);
    	
		Farmacia farmacia2 = new Farmacia();
		farmacia2.setDiaDeTurno("lunes");
		farmacia2.setNombre("farmacia2");
		farmacia2.setTelefono("1111");
		farmacia2.setDireccion(direccion2);
		getSession().save(farmacia2);
		
		Farmacia farmacia3 = new Farmacia();
		farmacia3.setDiaDeTurno("martes");
		farmacia3.setNombre("farmacia3");
		farmacia3.setTelefono("1111");
		farmacia3.setDireccion(direccion3);
		getSession().save(farmacia3);
		
		Farmacia farmacia4 = new Farmacia();
		farmacia4.setDiaDeTurno("miercoles");
		farmacia4.setNombre("farmacia4");
		farmacia4.setTelefono("1111");
		farmacia4.setDireccion(direccion4);
		getSession().save(farmacia4);
		
		List<Farmacia> Resultado = getSession().createCriteria(Farmacia.class).createAlias("direccion","direccionBuscada").add(Restrictions.eq("direccionBuscada.calle", "Calle1")).list();
    	for (Farmacia busqueda: Resultado){
    		assertThat(busqueda.getDireccion().getCalle()).isEqualTo("Calle1");
    		
    	}	assertThat(Resultado.size()).isEqualTo(1);

	}}
