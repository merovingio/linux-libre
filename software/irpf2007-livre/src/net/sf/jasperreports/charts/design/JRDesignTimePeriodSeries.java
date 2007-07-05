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
package net.sf.jasperreports.charts.design;

import net.sf.jasperreports.charts.base.JRBaseTimePeriodSeries;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRHyperlink;

/**
 * @author Flavius Sana (flavius_sana@users.sourceforge.net)
 * @version $Id: JRDesignTimePeriodSeries.java 1364 2006-08-31 18:13:20 +0300 (Thu, 31 Aug 2006) lucianc $
 */
public class JRDesignTimePeriodSeries extends JRBaseTimePeriodSeries {

	/**
	 * 
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;
	
	/**
	 * 
	 */
	public void setSeriesExpression( JRExpression seriesExpression ){
		this.seriesExpression = seriesExpression;
	}
	
	/**
	 * 
	 */
	public void setStartDateExpression( JRExpression startDateExpression ){
		this.startDateExpression = startDateExpression;
	}

	/**
	 * 
	 */
	public void setEndDateExpression( JRExpression endDateExpression ){
		this.endDateExpression = endDateExpression;
	}
	
	/**
	 * 
	 */
	public void setValueExpression( JRExpression valueExpression ){
		this.valueExpression = valueExpression;
	}
	
	/**
	 * 
	 */
	public void setLabelExpression( JRExpression labelExpression ){
		this.labelExpression = labelExpression;
	}

	/**
	 * Sets the hyperlink specification for chart items.
	 * 
	 * @param itemHyperlink the hyperlink specification
	 * @see #getItemHyperlink()
	 */
	public void setItemHyperlink(JRHyperlink itemHyperlink)
	{
		this.itemHyperlink = itemHyperlink;
	}
}
