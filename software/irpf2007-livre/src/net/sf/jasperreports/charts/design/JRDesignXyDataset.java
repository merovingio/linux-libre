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

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.charts.JRXyDataset;
import net.sf.jasperreports.charts.JRXySeries;
import net.sf.jasperreports.engine.JRChartDataset;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.design.JRDesignChartDataset;
import net.sf.jasperreports.engine.design.JRVerifier;



/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRDesignXyDataset.java 1364 2006-08-31 18:13:20 +0300 (Thu, 31 Aug 2006) lucianc $
 */
public class JRDesignXyDataset extends JRDesignChartDataset implements JRXyDataset
{


	/**
	 *
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	private List xySeriesList = new ArrayList();


	/**
	 *
	 */
	public JRDesignXyDataset(JRChartDataset dataset)
	{
		super(dataset);
	}


	/**
	 *
	 */
	public JRXySeries[] getSeries()
	{
		JRXySeries[] xySeriesArray = new JRXySeries[xySeriesList.size()];
		
		xySeriesList.toArray(xySeriesArray);

		return xySeriesArray;
	}
	

	/**
	 * 
	 */
	public List getSeriesList()
	{
		return xySeriesList;
	}

	
	/**
	 *
	 */
	public void addXySeries(JRXySeries xySeries)
	{
		xySeriesList.add(xySeries);
	}
	

	/**
	 *
	 */
	public JRXySeries removeXySeries(JRXySeries xySeries)
	{
		if (xySeries != null)
		{
			xySeriesList.remove(xySeries);
		}
		
		return xySeries;
	}


	/** 
	 * 
	 */
	public byte getDatasetType() {
		return JRChartDataset.XY_DATASET;
	}
	
	
	/**
	 *
	 */
	public void collectExpressions(JRExpressionCollector collector)
	{
		collector.collect(this);
	}


	public void validate(JRVerifier verifier)
	{
		verifier.verify(this);
	}


}