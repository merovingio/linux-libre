/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2006 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 303 Second Street, Suite 450 North
 * San Francisco, CA 94107
 * http://www.jaspersoft.com
 */
package net.sf.jasperreports.engine.design;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRHyperlinkParameter;
import net.sf.jasperreports.engine.base.JRBaseHyperlinkParameter;


/**
 * Implementation of {@link JRHyperlinkParameter JRHyperlinkParameter}
 * that can be used for report designing purposes.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRDesignHyperlinkParameter.java 1355 2006-08-04 17:31:54 +0300 (Fri, 04 Aug 2006) lucianc $
 */
public class JRDesignHyperlinkParameter extends JRBaseHyperlinkParameter
{
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	
	/**
	 * Creates a blank hyperlink parameter.
	 */
	public JRDesignHyperlinkParameter()
	{
	}
	
	
	/**
	 * Sets the paramter name.
	 * 
	 * @param name the name
	 * @see #getName()
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	
	/**
	 * Sets the parameter value expression.
	 * <p>
	 * This expression will be evaluated at fill time and the resulting
	 * value will be saved in the print hyperlink instance.
	 * </p>
	 * 
	 * @param valueExpression the expression that produces the parameter value
	 */
	public void setValueExpression(JRExpression valueExpression)
	{
		this.valueExpression = valueExpression;
	}

}
