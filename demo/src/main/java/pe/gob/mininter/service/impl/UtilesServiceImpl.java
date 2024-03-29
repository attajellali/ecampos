package pe.gob.mininter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dao.UtilesDao;
import pe.gob.mininter.entities.SiminCorreo;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.service.UtilesService;

@Service
public class UtilesServiceImpl implements UtilesService{
	

	@Autowired
	private UtilesDao utilesDao;
	
	public UtilesServiceImpl( ) { }

	@Override
	public void registrarCorreo(SiminCorreo correo, SiminMaestro usuario) {
		utilesDao.registrarCorreo(correo, usuario);
	}

	@Override
	public List<SiminCorreo> listarCorreos(Integer codEmpleado) {
		return utilesDao.listarCorreos(codEmpleado);
	}

	@Override
	public void actualizarCorreo(Integer codCorreo, String estadoCorreo) {
		utilesDao.actualizarCorreo(codCorreo, estadoCorreo);
	}
	
}
