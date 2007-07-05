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

import net.sf.jasperreports.charts.JRHighLowDataset;
import net.sf.jasperreports.engine.JRChartDataset;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.JRHyperlink;
import net.sf.jasperreports.engine.design.JRDesignChartDataset;
import net.sf.jasperreports.engine.design.JRVerifier;


/**
 * @author Ionut Nedelcu (ionutned@users.sourceforge.net)
 * @version $Id: JRDesignHighLowDataset.java 1364 2006-08-31 18:13:20 +0300 (Thu, 31 Aug 2006) lucianc $
 */
public class JRDesignHighLowDataset extends JRDesignChartDataset implements JRHighLowDataset
{

	/**
	 *
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	protected JRExpression seriesExpression;
	protected JRExpression dateExpression;
	protected JRExpression highExpression;
	protected JRExpression lowExpression;
	protected JRExpression openExpression;
	protected JRExpression closeExpression;
	protected JRExpression volumeExpression;
	private JRHyperlink itemHyperlink;


	/**
	 *
	 */
	public JRDesignHighLowDataset(JRChartDataset dataset)
	{
		super(dataset);
	}


	public JRExpression getSeriesExpression()
	{
		return seriesExpression;
	}


	public void setSeriesExpression(JRExpression seriesExpression)
	{
		this.seriesExpression = seriesExpression;
	}

	public JRExpression getDateExpression()
	{
		return dateExpression;
	}


	public void setDateExpression(JRExpression dateExpression)
	{
		this.dateExpression = dateExpression;
	}


	public JRExpression getHighExpression()
	{
		return highExpression;
	}


	public void setHighExpression(JRExpression highExpression)
	{
		this.highExpression = highExpression;
	}


	public JRExpression getLowExpression()
	{
		return lowExpression;
	}


	public void setLowExpression(JRExpression lowExpression)
	{
		this.lowExpression = lowExpression;
	}


	public JRExpression getOpenExpression()
	{
		return openExpression;
	}


	public void setOpenExpression(JRExpression openExpression)
	{
		this.openExpression = openExpression;
	}


	public JRExpression getCloseExpression()
	{
		return closeExpression;
	}


	public void setCloseExpression(JRExpression closeExpression)
	{
		this.closeExpression = closeExpression;
	}


	public JRExpression getVolumeExpression()
	{
		return volumeExpression;
	}


	public void setVolumeExpression(JRExpression volumeExpression)
	{
		this.volumeExpression = volumeExpression;
	}

	/** 
	 * 
	 */
	public byte getDatasetType() {
		return JRChartDataset.HIGHLOW_DATASET;
	}


	/**
	 *
	 */
	public void collectExpressions(JRExpressionCollector collector)
	{
		collector.collect(this);
	}

	
	public JRHyperlink getItemHyperlink()
	{
		return itemHyperlink;
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


	public void validate(JRVerifier verifier)
	{
		verifier.verify(this);
	}


}

