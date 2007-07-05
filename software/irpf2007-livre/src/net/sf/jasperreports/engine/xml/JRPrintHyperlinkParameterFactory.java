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
package net.sf.jasperreports.engine.xml;

import net.sf.jasperreports.engine.JRPrintHyperlinkParameter;
import net.sf.jasperreports.engine.JRPrintHyperlinkParameters;

import org.xml.sax.Attributes;


/**
 * Factory that creates {@link JRPrintHyperlinkParameterFactory print hyperlink parameters}
 * from <code>hyperlinkParameter</code> XML elements.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRPrintHyperlinkParameterFactory.java 1355 2006-08-04 17:31:54 +0300 (Fri, 04 Aug 2006) lucianc $
 * @see JRPrintHyperlinkParameters#addParameter(JRPrintHyperlinkParameter)
 */
public class JRPrintHyperlinkParameterFactory extends JRBaseFactory
{

	public static final String TAG_HYPERLINK_PARAMETER = "hyperlinkParameter";
	
	public static final String ATTRIBUTE_name = "name";
	public static final String ATTRIBUTE_class = "class";
	
	public Object createObject(Attributes attrs)
	{
		JRPrintHyperlinkParameter parameter = new JRPrintHyperlinkParameter();
		parameter.setName(attrs.getValue(ATTRIBUTE_name));
		
		String valueClass = attrs.getValue(ATTRIBUTE_class);
		if (valueClass != null)
		{
			parameter.setValueClass(valueClass);
		}
		
		return parameter;
	}

}
