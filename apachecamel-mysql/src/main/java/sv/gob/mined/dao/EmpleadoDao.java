package sv.gob.mined.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sv.gob.mined.entidad.Empleados;

public interface EmpleadoDao extends JpaRepository<Empleados, Long>{

	@Query(value="SELECT * FROM EMPLEADOS WHERE IDENTIFICADOR = :id", nativeQuery=true)
	public Empleados obtenerEmpleadoPorId(@Param("id") Long id );
	
	@Modifying
	@Query(value="UPDATE Empleados emp SET emp.direccion = :direccion WHERE emp.identificador = :id")
	int actualizarEmpleado(@Param("direccion") String direccion, @Param("id") Long id );
	
	
}
