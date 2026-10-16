package com.examenES.LP2_ES_Quispe_Yhon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examenES.LP2_ES_Quispe_Yhon.model.OrdenQuispeYhon;

public interface OrdenRepository extends JpaRepository<OrdenQuispeYhon, Integer> {

	@Query("""
			select o from OrdenQuispeYhon o
			where
				(o.cliente.idCliente = :idCliente or :idCliente is null)
			order by
				o.idOrden desc
			""")
	List<OrdenQuispeYhon> findByFilters(@Param("idCliente") Integer idCliente);
}
