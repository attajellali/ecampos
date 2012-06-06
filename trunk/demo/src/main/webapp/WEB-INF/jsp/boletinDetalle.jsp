<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@page import="java.util.List"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Boletines del Ministerio del Interior</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<link href="css/estilos.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript">
	function buscarBoletines(){	
		document.forms[0].action = "buscarBol.htm";
		document.forms[0].submit();
	}
</script>
</head>


<body>
	<form:form action="buscarBol.htm" modelAttribute="imagen">
	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">		
		<tr>
			<td height="115" colspan="2" valign="top">
				<jsp:include page="cabecera.jsp" />
			</td>
		</tr>
		<tr>
			<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
			<td width="690" valign="top">
				<table width="690" border="0" cellpadding="2" cellspacing="2">
	           		<tr>
		                <td colspan="3">&nbsp;</td>
		            </tr>
	            	<tr>
		                <td class="tituloEncabezado" colspan="3" align="center">Oficina de Comunicaci&oacute;n Social / Bolet&iacute;n Informativo</td>
		            </tr>
		            <tr>
		            	<td align="right">&nbsp;</td>
		                <td align="center">&nbsp;</td>
		                <td align="right"><a href="javascript:history.go(-1)"><img name="btnAtras" src="images/regresar_icon.jpg" alt="Atras" border="0" /></a>&nbsp;&nbsp;&nbsp;</td>
	              	</tr>
		            <tr>
		                 <td align="center" colspan="3">	
		                	<c:if test="${not empty beanBoletin }">
								<iframe scrolling="yes" frameborder="0" width="690" height="600" src="pdf.htm?id=${beanBoletin.coImgCodigo}"></iframe>
		                	</c:if>
						</td>
		            </tr>
            	</table>			
        	</td>
		</tr>
		<tr>
			<td colspan="2" class="pie"><jsp:include page="copyright.jsp" /></td>
		</tr>
	</table>
	</form:form>
</body>
</html>