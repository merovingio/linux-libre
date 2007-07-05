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
package net.sf.jasperreports.charts.base;

import java.io.Serializable;

import net.sf.jasperreports.charts.JRTimeSeries;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRHyperlink;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRBaseTimeSeries.java 1364 2006-08-31 18:13:20 +0300 (Thu, 31 Aug 2006) lucianc $
 */
public class JRBaseTimeSeries implements JRTimeSeries, Serializable
{


	/**
	 *
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	protected JRExpression seriesExpression = null;
	protected JRExpression timePeriodExpression = null;
	protected JRExpression valueExpression = null;
	protected JRExpression labelExpression = null;
	protected JRHyperlink itemHyperlink;

	
	/**
	 *
	 */
	protected JRBaseTimeSeries()
	{
	}
	
	
	/**
	 *
	 */
	public JRBaseTimeSeries(JRTimeSeries timeSeries, JRBaseObjectFactory factory)
	{
		factory.put(timeSeries, this);

		seriesExpression = factory.getExpression(timeSeries.getSeriesExpression());
		timePeriodExpression = factory.getExpression(timeSeries.getTimePeriodExpression());
		valueExpression = factory.getExpression(timeSeries.getValueExpression());
		labelExpression = factory.getExpression(timeSeries.getLabelExpression());
		itemHyperlink = factory.getHyperlink(timeSeries.getItemHyperlink());
	}

	
	/**
	 *
	 */
	public JRExpression getSeriesExpression()
	{
		return seriesExpression;
	}
		
	/**
	 *
	 */
	public JRExpression getTimePeriodExpression()
	{
		return timePeriodExpression;
	}
		
	/**
	 *
	 */
	public JRExpression getValueExpression()
	{
		return valueExpression;
	}
		
	/**
	 *
	 */
	public JRExpression getLabelExpression()
	{
		return labelExpression;
	}

	
	public JRHyperlink getItemHyperlink()
	{
		return itemHyperlink;
	}
		
}
