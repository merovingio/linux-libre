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

import net.sf.jasperreports.engine.JasperPrint;

import org.xml.sax.Attributes;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JasperPrintFactory.java 1485 2006-11-14 20:23:17 +0200 (Tue, 14 Nov 2006) teodord $
 */
public class JasperPrintFactory extends JRBaseFactory
{

	
	/**
	 *
	 */
	private static final String ATTRIBUTE_name = "name";
	private static final String ATTRIBUTE_pageWidth = "pageWidth";
	private static final String ATTRIBUTE_pageHeight = "pageHeight";
	private static final String ATTRIBUTE_orientation = "orientation";
	public static final String ATTRIBUTE_formatFactoryClass = "formatFactoryClass";
	public static final String ATTRIBUTE_locale = "locale";
	public static final String ATTRIBUTE_timezone = "timezone";


	/**
	 *
	 */
	public Object createObject(Attributes atts)
	{
		JasperPrint jasperPrint = new JasperPrint();
		
		jasperPrint.setName(atts.getValue(ATTRIBUTE_name));

		String pageWidth = atts.getValue(ATTRIBUTE_pageWidth);
		if (pageWidth != null && pageWidth.length() > 0)
		{
			jasperPrint.setPageWidth(Integer.parseInt(pageWidth));
		}

		String pageHeight = atts.getValue(ATTRIBUTE_pageHeight);
		if (pageHeight != null && pageHeight.length() > 0)
		{
			jasperPrint.setPageHeight(Integer.parseInt(pageHeight));
		}

		Byte orientation = (Byte)JRXmlConstants.getOrientationMap().get(atts.getValue(ATTRIBUTE_orientation));
		if (orientation != null)
		{
			jasperPrint.setOrientation(orientation.byteValue());
		}
		
		String formatFactoryClass = atts.getValue(ATTRIBUTE_formatFactoryClass);
		if (formatFactoryClass != null)
		{
			jasperPrint.setFormatFactoryClass(formatFactoryClass);
		}
		
		String locale = atts.getValue(ATTRIBUTE_locale);
		if (locale != null)
		{
			jasperPrint.setLocaleCode(locale);
		}
		
		String timezone = atts.getValue(ATTRIBUTE_timezone);
		if (timezone != null)
		{
			jasperPrint.setTimeZoneId(timezone);
		}

		return jasperPrint;
	}
	

}
