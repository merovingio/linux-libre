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
package net.sf.jasperreports.engine.export;

import java.awt.Color;

import net.sf.jasperreports.engine.JRBox;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.base.JRBasePrintElement;
	
	
/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRExporterGridCell.java 1229 2006-04-19 13:27:35 +0300 (Wed, 19 Apr 2006) teodord $
 */
public class JRExporterGridCell
{


	/**
	 *
	 */
	public static final JRExporterGridCell OCCUPIED_CELL = 
		new JRExporterGridCell(
			new JRBasePrintElement(null),
			null,
			0,
			0,
			1,
			1
		); 


	/**
	 *
	 */
	public JRPrintElement element = null; 
	public Integer[] elementIndex = null;
	
	protected Color backcolor;
	protected Color forecolor;
	protected JRBox box;
	
	public int width = 0;
	public int height = 0;
	public int colSpan = 0;
	public int rowSpan = 0;


	/**
	 * @deprecated Replaced by {@link #JRExporterGridCell(JRPrintElement, Integer[], int, int, int, int)}.
	 */
	public JRExporterGridCell
	(
		JRPrintElement element, 
		int width, 
		int height,
		int colSpan, 
		int rowSpan
	)
	{
		this(
			element,
			null,
			width,
			height,
			colSpan,
			rowSpan
			);
	}


	/**
	 *
	 */
	public JRExporterGridCell
	(
		JRPrintElement element, 
		Integer[] elementIndex,
		int width, 
		int height,
		int colSpan, 
		int rowSpan
	)
	{
		this.element = element;
		this.elementIndex = elementIndex;
		this.width = width;
		this.height = height;
		this.colSpan = colSpan;
		this.rowSpan = rowSpan;
	}


	public Color getBackcolor()
	{
		return backcolor;
	}


	public void setBackcolor(Color backcolor)
	{
		this.backcolor = backcolor;
	}


	public JRBox getBox()
	{
		return box;
	}


	public void setBox(JRBox box)
	{
		this.box = box;
	}


	public Color getForecolor()
	{
		return forecolor;
	}


	public void setForecolor(Color forecolor)
	{
		this.forecolor = forecolor;
	}


}
