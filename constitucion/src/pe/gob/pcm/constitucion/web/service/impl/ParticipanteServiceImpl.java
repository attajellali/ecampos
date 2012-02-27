package pe.gob.pcm.constitucion.web.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.pcm.constitucion.web.dao.ParametroDAO;
import pe.gob.pcm.constitucion.web.dao.ParticipanteDAO;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T022accionista;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;
import pe.gob.pcm.constitucion.web.service.ParticipanteService;
import pe.gob.pcm.constitucion.web.util.ParametrosUtil;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

	private static final Logger logger = Logger.getLogger(ParticipanteServiceImpl.class);
	
	@Autowired
	private ParticipanteDAO participanteDAO;
	@Autowired
	private ParametroDAO parametroDAO;
	
	@Override
	public List<T022accionista> listarAccionistas( int idtramite ) {
		return participanteDAO.listarAccionistas(idtramite);
	}

	@Override
	public List<T025pernat> listarPersonasNaturales( int idtramite ) {
		return participanteDAO.listarPersonasNaturales(idtramite);
	}

	@Override
	public List<T026perjur> listarPersonasJuridicas( int idtramite ) {
		return participanteDAO.listarPersonasJuridicas(idtramite);
	}

	@Override
	public void registrarAccionistas(T022accionista accionista) {
		participanteDAO.registrarAccionistas(accionista);
	}

	@Override
	@Transactional
	public void registrarPersonaNatural(T025pernat accionista) {
		logger.debug("registra persona natural");
		participanteDAO.registrarPersonaNatural(accionista);
		
	//	if( !Utiles.nullToBlank(accionista.getMontoAporte()).equals("") ){
			logger.debug( accionista.getNumDocum() + " " + accionista.getCodTipdoc()  + " " +accionista.getT020tramite().getNumTramite() );
			T022accionista as = participanteDAO.obtenerAccionista( accionista.getNumDocum() , accionista.getCodTipdoc() , accionista.getT020tramite() );
		
			T022accionista acc = new T022accionista();
			
			if(as != null){ 
				logger.debug("exste acionista");
				acc.setIdAccionista( as.getIdAccionista() );
			}
			
			acc.setFecRegistro( new Date());
			
			acc.setMtoAporte( accionista.getMontoAporte() );
			acc.setIndAporte( accionista.getIndAporte() );
			acc.setCodParticipa( accionista.getCodParticipa() );
			
			acc.setNumDocum( accionista.getNumDocum() );
			acc.setCodTipdoc( accionista.getCodTipdoc());
			acc.setT020tramite( accionista.getT020tramite() );
			logger.debug("registra accionista");
			participanteDAO.registrarAccionistas( acc );
	//	}
	}

	@Override
	public void registrarPersonaJuridica(T026perjur accionista) {
		participanteDAO.registrarPersonaJuridica(accionista);
		
		//if( !Utiles.nullToBlank(accionista.getMontoAporte()).equals("") ){			
			T022accionista acc = new T022accionista();
			acc.setFecRegistro( new Date());
			
			acc.setMtoAporte( accionista.getMontoAporte() );
			acc.setIndAporte( accionista.getIndAporte() );
			acc.setCodParticipa( accionista.getCodParticipa() );
			
			acc.setNumDocum( accionista.getNumDocum() );
			acc.setCodTipdoc( accionista.getCodTipdoc());
			acc.setT020tramite( accionista.getT020tramite() );
			logger.debug("registra accionista");
			participanteDAO.registrarAccionistas( acc );
		//}
		
	}

	@Override
	public void modificarAccionistas(T022accionista accionista) {
		participanteDAO.modificarAccionistas(accionista);
	}

	@Override
	public void modificarPersonaNatural(T025pernat accionista) {
		participanteDAO.modificarPersonaNatural(accionista);
	}

	@Override
	public void modificarPersonaJuridica(T026perjur accionista) {
		participanteDAO.modificarPersonaJuridica(accionista);
	}

	@Override
	public void eliminarAccionistas(T022accionista accionista) {
		participanteDAO.eliminarAccionistas(accionista);
	}

	@Override
	public void eliminarPersonaNatural(T025pernat accionista) {
		participanteDAO.eliminarPersonaNatural(accionista);
	}

	@Override
	public void eliminarPersonaJuridica(T026perjur accionista) {
		participanteDAO.eliminarPersonaJuridica(accionista);
	}

	@Override
	public T025pernat obtenerParticipantePn(String cod) {
		return participanteDAO.obtenerParticipantePn(cod);
	}

	@Override
	public T025pernat completarParticipante(T020tramite trm, T025pernat per) {
		per.setIndAporte( trm.getIndAporte() + "" );
		if(	StringUtils.isNotEmpty( per.getCodUbigeo())){
			per.setCodDepa( per.getCodUbigeo().substring(0,2) + "0000" ) ;
			per.setCodProv( per.getCodUbigeo().substring(2,4) + "00" );
		}
		return per;
	}

	@Override
	public T025pernat completarParticipanteVista(T020tramite trm, T025pernat per) {
		//codParticipa	->descParticipa = parametroDAO.obtenerParametro(ParametrosUtil.TIPO_PARTICIPANTE , per.getCodParticipa() );
		String descDepa = parametroDAO.obtenerParametro(ParametrosUtil.UBIGEO, per.getCodProv() );
		//codTipdoc		->descTipdoc = parametroDAO.obtenerParametro(ParametrosUtil.TIPO_DOCUMENTO , per.getCodTipdoc());
		//codPais		->descPais = "Peru"
		//codDepa		->descDepa = parametroDAO.obtenerParametro(ParametrosUtil.UBIGEO, per.getCodDepa().substring(0,2) + "0000");
		//codProv		->descProv
		//codUbigeo		->descUbigeo
		//codEstcivil	->descEstcivil
		//codTdcon		->descTdcon
		return per;
	}

}
