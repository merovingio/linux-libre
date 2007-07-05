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

import net.sf.jasperreports.engine.base.JRBaseConditionalStyle;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.JRConditionalStyle;

/**
 * @author Ionut Nedelcu (ionutned@users.sourceforge.net)
 * @version $Id: JRDesignConditionalStyle.java 1413 2006-09-28 13:47:40 +0300 (Thu, 28 Sep 2006) teodord $
 */
public class JRDesignConditionalStyle extends JRBaseConditionalStyle implements JRConditionalStyle
{

	/**
	 *
	 */
	public JRDesignConditionalStyle()
	{
	}

	/**
	 *
	 */
	public void setConditionExpression(JRExpression conditionExpression)
	{
		this.conditionExpression = conditionExpression;
	}

	/**
	 *
	 */
	public void setParentStyle(JRStyle parentStyle)
	{
		this.parentStyle = parentStyle;
	}

}
